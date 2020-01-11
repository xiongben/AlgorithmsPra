package com.xiongben.tree;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
//        int[] arr = new int[8];
//        for(int i=0;i<8;i++){
//            arr[i] = (int)(Math.random()*80);
//
//        }
        int[] arr = {4,6,8,5,9};
        for(int no: arr){
            System.out.print(no + ",");
        }
        System.out.println();
        heapSort(arr);
        for(int no: arr){
            System.out.print(no + ",");
        }

    }

    public static void heapSort(int arr[]){
        int temp = 0;
        System.out.println("堆排序");
//        adjustHeap(arr,1,arr.length);
//        System.out.println(Arrays.toString(arr));
//        adjustHeap(arr,0,arr.length);
//        System.out.println(Arrays.toString(arr));
        for (int i = arr.length/2 -1;i>=0;i--){
            adjustHeap(arr,i,arr.length);
        }

        for (int j=arr.length-1;j>0;j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);
        }
    }

    public static void adjustHeap(int[] arr,int i,int length) {
        int temp = arr[i];
        for (int k=i*2+1;k<length;k=k*2+1){
            if(k+1<length && arr[k] < arr[k+1]){
                k++;
            }
            if(arr[k] > temp){
                arr[i] = arr[k];
                i = k;
            }else {
                break;
            }
        }
        arr[i] = temp;
    }
}
