package leetcode;//Учитывая две строки s и t, верните true, если s является подпоследовательность t , или false в противном случае .
//
//Подпоследовательность строки — это новая строка , которая формируется из исходной строки путем удаления некоторых
// (может быть ни одного) символов без нарушения относительного положения остальных символов.
// (т. е. "ace" является подпоследовательностью, а "aec" не является).
//Пример 1:
//
//Ввод: s = «abc», t = «ahbgdc»
//Выход: true
//Пример 2:
//
//Ввод: s = «axc», t = «ahbgdc»
//Вывод: false


public class Task392 {
    public static boolean isSubsequence(String s, String t) {
        if (s.length() > t.length() || s.isBlank()) { //сравниваем длину двух строк, если s<t, возвращаем false
            return false;
        }
        int indexS = 0;
        int indexT = 0;
        while (indexS < s.length() && indexT < t.length()) {
            if (s.charAt(indexS) == t.charAt(indexT)) { //посимвольно сравниваем s и t
                indexS++; // если символ строки s = символу строки t, переходим к следующему символу строки s
            }
            indexT++; // переходим к следующему символу строки t
        }
        return indexS == s.length();  //проверяем, кончились ли символы в исходноой строке s
    }

    public static boolean isSubsequence1(String s, String t) {
        if (s.length() > t.length() || s.isBlank()) { //сравниваем длину двух строк, если s<t, возвращаем false
            return false;
        }
        int indexS = 0;
        for (int indexT = 0; indexT < t.length(); indexT++) {
            if (s.charAt(indexS) == t.charAt(indexT)) {
                indexS++;
            }
            if (indexS == s.length()) {
                return true;
            }
        }
        return false;
    }

//    public static boolean isSubsequence2(String s, String t) {
//        if (s.length() > t.length() || s.isBlank()) { //сравниваем длину двух строк, если s<t, возвращаем false
//            return false;
//        }
//
//        boolean res = t.chars()
//                .filter(e -> s.contains())
//
//
//        return res;
//    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("acb", "ahbgdc"));

    }
}


//   public static boolean isSubsequence2(String s, String t) {
//       Map<Character, List<Integer>> map = new HashMap<>();
//       for (int idxT = 0; idxT < t.length(); idxT++) {
//           if (map.containsKey(t.charAt(idxT))) {
//               map.get(t.charAt(idxT)).add(idxT);
//           } else {
//               ArrayList<Integer> indices = new ArrayList<Integer>();
//               indices.add(idxT);
//               map.put(t.charAt(idxT), indices);
//           }
//       }
//       return false;
//   }
