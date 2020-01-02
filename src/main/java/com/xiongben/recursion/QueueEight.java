package com.xiongben.recursion;

public class QueueEight {

    int max = 8;
    int[] array = new int[max];
    static int count = 0;
    static int judgeCount = 0;

    public static void main(String[] args) {
        QueueEight queue8 = new QueueEight();
        queue8.check(0);
        System.out.printf("一共有%d解法",count);
        System.out.printf("一共判断冲突的次数是%d",judgeCount);
    }

    private void check(int n){
        if(n == 8){
          print();
          return;
        }
        for (int i=0;i<max;i++){
            array[n] = i;
            if(judge(n)){
                check(n+1);
            }
        }
    }

    private boolean judge(int n){
        judgeCount++;
        for (int i=0; i<n; i++){
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }

    private void print(){
        count++;
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
