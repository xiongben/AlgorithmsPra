package com.xiongben.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for(int i=0;i<10;i++){
            arr[i] = (int)(Math.random()*8000000);
        }
        System.out.println(Arrays.toString(arr));

        insertSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void insertSort(int[] arr){
        int insertVal = 0;
        int insertIndex = 0;
        for (int i=1;i<arr.length;i++){
            insertVal = arr[i];
            insertIndex = i;
            while (insertIndex > 0 && insertVal<arr[insertIndex-1]){
                arr[insertIndex] = arr[insertIndex-1];
                insertIndex--;
            }
            if(insertIndex != i){
                arr[insertIndex] = insertVal;
            }
        }
    }
}
