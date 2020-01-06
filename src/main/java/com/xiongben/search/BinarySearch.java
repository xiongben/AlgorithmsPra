package com.xiongben.search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,5,7,9,22,42,123,556,666,765,1122,4422,12345};
        int index = binarySearch(arr,0,arr.length-1,666);
        System.out.println("被查找值的序号是：" + index);

    }

    public static int binarySearch(int[] arr,int left,int right,int findVal){
        System.out.println("二分查找被调用");
        if(left > right){
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if(findVal < midVal){
            return binarySearch(arr,left,mid,findVal);
        }else if(findVal > midVal){
            return binarySearch(arr,mid,right,findVal);
        }else {
            return mid;
        }
    }
}
