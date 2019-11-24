package com.xiongben.demo1;

import java.util.Arrays;

public class QuickSort {
    public static void sort(int[] a,int low,int hight){
        int i,j,index,t;
        if(low>hight){
            return;
        }
        i = low;
        j = hight;
        index = a[i];
        while (i < j){
            while (i < j && a[j] >= index){
                j--;
            }
            while (i < j && a[i] <= index){
                i++;
            }
            if(i < j){
                t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        a[low] = a[i];
        a[i] = index;
        sort(a,low,i-1);
        sort(a,i+1,hight);
    }
    public void sortArr(){
        int[] arr1 = {20,5,3,88,90,23,42,76,34,79,12,13,21,22,63,81,27,55};
        sort(arr1,0,arr1.length-1);
        System.out.println(Arrays.toString(arr1));
    }
}
