package com.xiongben.sort;

public class ShellSort {
    public static void main(String[] args) {
        for (int i=2;i<10;i++){
            System.out.println("====="+(i-2)+"=====");
            for (int j=i-2;j>=0;j-=2){
                System.out.println(j);
            }
            System.out.println("==========");
        }
    }
}
