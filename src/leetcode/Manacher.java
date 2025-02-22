package leetcode;

public class Manacher {
    public static String longestPalindrome(String s) {
        //вставляется рандомный символ между символами строки для преобразования четной строки в нечетную
        StringBuilder sPrime = new StringBuilder("#");
        for (char c : s.toCharArray()) {
            sPrime.append(c).append("#");
        }

        int n = sPrime.length(); //создаем переменную равную длине строки с учетом символов #
        int[] palindromeRadii = new int[n];  //массив радиусов палиндрома, то есть расстояние от центра до любого из самых дальних символов палиндрома
        // (например, палиндром длиной 3 имеет палиндромиальный радиус 1)
        int center = 0; //положение центра палиндрома содержащего символ, ближайший к правому концу sPrime
        int radius = 0; //положением самой правой границы этого палиндрома

        //внешний цикл соответствует горизонтальному перемещению
        for (int i = 0; i < n; i++) {
            int mirror = 2 * center - i; //зеркальным отражением i относительно центра (center)

            //Если мы попадаем в пределы радиуса прошлого результата,
            //то начальное значение текущего радиуса можно взять из зеркального результата
            if (i < radius) {
                palindromeRadii[i] = Math.min(radius - i, palindromeRadii[mirror]);
            }

            // Проверяем, чтобы правая граница палиндрома не вышла за правую границу строки (i+1+palR[i] < n)
            // Левая граница палиндрома не вышла за левую границу строки (i-1-palR[i] >=0)
            // Символы правой части палиндрома == символам левой части
            // Если true, то увеличиваем значение текущего радиуса
            while (i + 1 + palindromeRadii[i] < n
                    && i - 1 - palindromeRadii[i] >= 0
                    && sPrime.charAt(i + 1 + palindromeRadii[i]) == sPrime.charAt(i - 1 - palindromeRadii[i])) {
                palindromeRadii[i]++;
            }

            if (i + palindromeRadii[i] > radius) {
                center = i;
                radius = i + palindromeRadii[i];
            }
        }

        int maxLength = 0;
        int centerIndex = 0;
        for (int i = 0; i < n; i++) {
            if (palindromeRadii[i] > maxLength) {
                maxLength = palindromeRadii[i];
                centerIndex = i;
            }
        }
        //Отображаем найденные позиции на оригинальную строку
        int startIndex = (centerIndex - maxLength) / 2;
        String longestPalindrome = s.substring(startIndex, startIndex + maxLength);
        return longestPalindrome;
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}

