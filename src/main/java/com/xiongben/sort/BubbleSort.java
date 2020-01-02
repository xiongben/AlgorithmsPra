package com.xiongben.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for(int i=0;i<10;i++){
            arr[i] = (int)(Math.random()*8000000);
        }
        System.out.println(Arrays.toString(arr));

        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr){
        int temp = 0;
        boolean flag = false;
        for(int i=0;i<arr.length - 1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j] > arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            if(!flag){
                return;
            }
            flag = false;
        }
    }
}
