package com.xiongben.sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53,3,54,667,784,2233,111,34,400};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr){
        //得到数组最大数的位数
        int max = arr[0];
        for (int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        int maxLength = (max + "").length();
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];
        for (int i=1,n=1;i<=maxLength;i++,n*=10){
            for (int j=0;j<arr.length;j++){
                int digitOfElement = arr[j] / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            int index = 0;
            for (int k=0;k<bucketElementCounts.length;k++){
                if(bucketElementCounts[k]!=0){
                    for (int l=0;l<bucketElementCounts[k];l++){
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
                bucketElementCounts[k]=0;
            }

        }
    }
}
