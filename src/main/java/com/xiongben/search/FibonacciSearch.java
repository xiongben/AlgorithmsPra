package com.xiongben.search;


import java.util.Arrays;

public class FibonacciSearch {
    public static void main(String[] args) {
        int[] arr = {1,5,7,9,22,42,123,556,666,765,1122,4422,12345};
        int index = fibonacciSearch(arr,666);
        System.out.println("被查找值的序号是：" + index);


    }

    public static int[] fib(){
        int maxsize = 20;
       int[] fibarr = new int[maxsize];
       fibarr[0] = 1;
       fibarr[1] = 1;
       for(int i=2;i<fibarr.length;i++){
           fibarr[i] = fibarr[i-1] + fibarr[i-2];
       }
       return fibarr;
    }

    public static int fibonacciSearch(int[] arr,int findVal){
        int low = 0;
        int high = arr.length - 1;
        int[] fibarr = fib();
        int k = 0;
        int mid  = 0;
        while (high > fibarr[k] - 1){
            k++;
        }
        int[] temp = Arrays.copyOf(arr,fibarr[k]);
        for (int i=high+1;i<temp.length;i++){
            temp[i] = arr[high];
        }
        while (low <= high){
            mid = low + fibarr[k-1] - 1;
            if(findVal < arr[mid]){
                high = mid - 1;
                k--;
            }else if(findVal > arr[mid]){
                low = mid + 1;
                k-=2;
            }else{
                if(mid <= high){
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;
    }
}
