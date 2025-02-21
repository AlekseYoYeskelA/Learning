//Вам дана индексированная 0 строка num, представляющая собой целое неотрицательное число.
//За одну операцию вы можете выбрать любую цифру из num и удалить ее.
//Обратите внимание, что если вы удалите все цифры num, то num станет равным 0.
//Верните минимальное количество операций, необходимых для превращения числа num в особое. Целое число x считается особым, если оно делится на 25.

//Example 1:
//
//Input: num = "2245047"
//Output: 2
//Explanation: Delete digits num[5] and num[6]. The resulting number is "22450" which is special since it is divisible by 25.
//It can be shown that 2 is the minimum number of operations required to get a special number.
//Example 2:
//
//Input: num = "2908305"
//Output: 3
//Explanation: Delete digits num[3], num[4], and num[6]. The resulting number is "2900" which is special since it is divisible by 25.
//It can be shown that 3 is the minimum number of operations required to get a special number.
//Example 3:
//
//Input: num = "10"
//Output: 1
//Explanation: Delete digit num[0]. The resulting number is "0" which is special since it is divisible by 25.
//It can be shown that 1 is the minimum number of operations required to get a special number.

//Подсказка 1
//Если num содержит одну нулевую цифру, то ответ не более n - 1.

//Подсказка 2
//Число делится на 25, если его последние две цифры — 75, 50, 25 или 00.

//Подсказка 3
//Перебрать все возможные пары индексов, i < j, такие, что num[i] * 10 + num[j] находится в [00,25,50,75].
//Затем установить ответ равным min(answer, n - i - 2) .


//package leetcode;
//
//public class Task2844 {
//    public int minimumOperations(String num) {
//        int result = 0;
//        char[] chars = num.toCharArray();
//        String[] ends = {"00", "25", "50", "75"};
//        for (int i = 0; i < ends.length; i++) {
//            if (num.contains(ends[i])) {
//                int idx = num.lastIndexOf(ends[i]);
//                result = (num.length()-1) - (num.length()-idx);
//            }
//        }
//        return result;
//    }
//}
//
//class Test2844 {
//    public static void main(String[] args) {
//        Task2844 t = new Task2844();
//        String num = "2908305"; //output 3
//        System.out.println(t.minimumOperations(num));
//    }
//}