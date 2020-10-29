package lesson_2;

import java.util.Arrays;

public class HW2 {
    public static void main(String[] args) {
        FirstArray();
        FillArray();
        ChangeArray();
        FillDiagonal();
        MaxAndMin();

    }

    //Задание 1
    public static void FirstArray(){
        int[] arr = {1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0};
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //Задание 2
    public static void FillArray(){
        int [] arr2 = new int[8];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i*3;
        }
        System.out.println(Arrays.toString(arr2));
    }

    //Задание 3
    public static void ChangeArray(){
        int [] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arr3));
        for (int i = 0; i < arr3.length; i++){
            if (arr3[i] < 6){
                arr3[i] = arr3[i] * 2;
            }else
                arr3[i] = arr3 [i];
        }
        System.out.println(Arrays.toString(arr3));
    }

    //Задание 4
    public static void FillDiagonal(){
        int[][] arr4 = new int[5][5];
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                arr4 [i] [i] = 1;
                arr4[i][5 - i - 1] = 1;
                System.out.print(arr4 [i] [j] + "  ");
            }
            System.out.println();
        }
    }

    //Задание 5
    public static void MaxAndMin(){
        int [] a = new int[20];
        for (int i = 0; i < a.length ; i++) {
            a[i] = (int) (Math.random() * 100);
        }
        for (int element : a){
            System.out.print(element + " ");
        }
        System.out.println();
        int max = a[0];
        for (int i : a){
            if (i > max){
                max = i;
            }
        }
        System.out.println(max);

        int min = a[0];
        for (int i: a){
            if (i < min){
                min = i;
            }
        }
        System.out.println(min);
    }
}