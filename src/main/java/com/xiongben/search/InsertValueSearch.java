package com.xiongben.search;

public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = {1,5,7,9,22,42,123,556,666,765,1122,4422,12345};
        int index = insertValueSearch(arr,0,arr.length-1,666);
//        int index = insertValueSearch2(arr,666);
        System.out.println("被查找值的序号是：" + index);

    }


    public static int insertValueSearch(int[] arr,int left,int right,int findVal){
        System.out.println("二分查找被调用");
        if(left > right || findVal < arr[left] || findVal > arr[arr.length-1]){
            return -1;
        }
        int mid = left + (right - left)*(findVal - arr[left])/(arr[right] - arr[left]);
//
//
//        if(mid == 0){
//            mid = (left + right) / 2;
//        }
//        int mid = (left + right) / 2;
//        System.out.println(mid);
        int midVal = arr[mid];
        if(findVal < midVal){
            return insertValueSearch(arr,left,mid-1,findVal);
        }else if(findVal > midVal){
            return insertValueSearch(arr,mid+1,right,findVal);
        }else {
            return mid;
        }
    }

    public static int insertValueSearch2(int[] arr,int findVal){
        if(arr.length == 0){
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        int mid = -1;
        while (low <= high){
            mid = low + (findVal - arr[low]) / (arr[high] - arr[low]);
            if(findVal > arr[mid]){
                low = mid + 1;
            }else if(findVal < arr[mid]){
                high = mid -1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
