package com.xiongben.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {44,66,78,22,4,5,4,5,5,7,1,9,6,4,5,4,78,34,23,11,65,1,2,3};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //插入排序的进阶版
    public static void shellSort(int[] arr){
        for(int gap=arr.length/2;gap>0;gap/=2){
            for (int i = gap;i<arr.length;i++){
                int j = i;
                int temp = arr[j];
                if(arr[j] < arr[j-gap]){
                    while (j-gap >= 0 && temp < arr[j-gap]){
                        arr[j] = arr[j-gap];
                        j = j-gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }
}
