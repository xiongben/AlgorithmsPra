package com.xiongben.linkedList;

public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();
        circleSingleLinkedList.countBoy(1,2,5);

    }
}

class CircleSingleLinkedList {

    private Boy first = null;

    public void addBoy(int nums){
      if(nums < 1){
          System.out.println("输入数值不正确，无法创建链表");
          return;
      }
      Boy temper = null;
      for(int i = 1; i <= nums; i++){
          Boy boy = new Boy(i);
          if(i == 1){
              first = boy;
              first.setNext(first);
              temper = first;
          }else{
              temper.setNext(boy);
              boy.setNext(first);
              temper = temper.getNext();
          }
      }
    }

    public void showBoy() {
       if(first == null){
           System.out.println("没有任何小孩");
           return;
       }
       Boy temper = first;

       while (true){
           System.out.printf("小孩的标号为%d\n",temper.getNo());
           if(temper.getNext() == first){
               break;
           }
           temper = temper.getNext();
       }
    }

    /**
     *
     * @param startNo 表示从第几个小孩开始数数
     * @param countNum 表示取数间隔
     * @param nums 最初小孩总个数
     */
    public void countBoy(int startNo,int countNum,int nums){
       if(startNo < 1 || startNo > nums || countNum > nums || first == null){
           System.out.println("参数不正确");
           return;
       }
       Boy helper = first;
       while (true){
           if(helper.getNext() == first){
               break;
           }
           helper = helper.getNext();
       }

       for (int i = 0 ; i < startNo-1; i++){
           first = first.getNext();
           helper = helper.getNext();
       }

       while (true){
           if(first.getNext() == first){
               System.out.printf("找到被点到的小孩：%d\n",first.getNo());
               break;
           }
           for (int j = 0; j < countNum-1; j++){
               first = first.getNext();
               helper = helper.getNext();
           }
           System.out.printf("找到被点到的小孩：%d\n",first.getNo());
           first = first.getNext();
           helper.setNext(first);
       }

    }
}

class Boy {

    private int no;
    private Boy next;

    Boy(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}