package com.xiongben.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {44,66,78,22,4,5,4,5,5,7,1,9,6,4,5,4,78,34,23,11,65,1,2,3};
        quickSort2(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort2(int[] arr,int left,int right){
        if(left > right){
            return;
        }
        int l = left;
        int r = right;
        int pivot = arr[left];
        int temp = 0; //临时变量，作为交换时使用
        while (l != r){
            while (arr[r] >= pivot && l<r){
                r -= 1;
            }
            while (arr[l] <= pivot && l<r){
                l += 1;
            }

            //交换
            if(l < r){
                temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
        arr[left] = arr[l];
        arr[l] = pivot;
        quickSort2(arr,left,l-1);
        quickSort2(arr,l+1,right);
        return;
    }

    public static void quickSort(int[] arr,int left, int right) {
        if(right <= left){
            return;
        }
        int l = left; //左下标
        int r = right; //右下标
        //pivot 中轴值
        int pivot = arr[(left + right) / 2];
        int temp = 0; //临时变量，作为交换时使用
        //while循环的目的是让比pivot 值小放到左边
        //比pivot 值大放到右边
        while( l < r) {
            //在pivot的左边一直找,找到大于等于pivot值,才退出
            while( arr[l] < pivot) {
                l += 1;
            }
            //在pivot的右边一直找,找到小于等于pivot值,才退出
            while(arr[r] > pivot) {
                r -= 1;
            }
            //如果l >= r说明pivot 的左右两的值，已经按照左边全部是
            //小于等于pivot值，右边全部是大于等于pivot值
            if( l >= r) {
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移
            if(arr[l] == pivot) {
                r -= 1;
            }
            //如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
            if(arr[r] == pivot) {
                l += 1;
            }
        }

        // 如果 l == r, 必须l++, r--, 否则为出现栈溢出
        if (l == r) {
            quickSort(arr, left, l-1);
            quickSort(arr, r+1, right);
        }

    }

}
