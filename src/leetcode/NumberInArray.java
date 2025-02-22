package leetcode;

public class NumberInArray {
    void numberArray(int [] array, int number){
        for(int i = 0; i < array.length; i++){
            for(int j= i+1; j < array.length; j++){
                if(array[i]+array[j]==number){
                    System.out.println("Число " + array[i] + " и число " + array[j] + " в сумме дают число " +  number);
                    return;
                }

            }
        }

        System.out.println("В массиве не найдена пара нужных чисел");

    }

}


class NumberInArrayTest{
    public static void main(String[] args) {
        int [] array = {2,2,2,2};
        int number = 10;
        NumberInArray n = new NumberInArray();
        n.numberArray(array, number);
    }
}