package com.xiongben.sort;

import java.util.Arrays;

public class MergetSort {
    public static void main(String[] args) {
        int[] arr = {44,66,78,22,4,5,4,5,5,7,1,9,6,4,5,4,78,34,23,11,65,1,2,3};
        int[] temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if(left < right){
            int mid = (left+right)/2;
            mergeSort(arr,left,mid,temp);
            mergeSort(arr,mid+1,right,temp);
            merge(arr,left,mid,right,temp);
        }
    }

    public static void merge(int[] arr,int left,int mid,int right, int[] temp){
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i<=mid && right>=j){
            if(arr[i] >= arr[j]){
                temp[t] = arr[j];
                j++;
                t++;
            }else{
                temp[t]=arr[i];
                i++;
                t++;
            }
        }
        while (i<=mid){
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j<=right){
            temp[t] = arr[j];
            j++;
            t++;
        }
        t=0;
        int templeft = left;
        while (templeft<=right){
            arr[templeft] = temp[t];
            t++;
            templeft++;
        }

    }
}
