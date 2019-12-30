package com.xiongben.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArray queue = new CircleArray(5);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s(show):打印队列");
            System.out.println("e(exit):关闭窗口");
            System.out.println("a(add):队列添加元素");
            System.out.println("g(get):队列提取元素");
            System.out.println("h(head):获取队列头部");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入要添加的元素");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("提取出元素%d\n",res);

                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头部是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println("====结束====");
    }
}

class CircleArray {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArray(int num){
        maxSize = num;
        arr = new int[maxSize];
    }

    public boolean isFull(){
        return (rear + 1)%maxSize == front;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    public void addQueue(int num){
        System.out.println(rear + ";"+front+";"+maxSize);
        if(isFull()){
            System.out.println("队列已经满了哦！");
            return;
        }
        arr[rear] = num;
        rear = (rear+1)%maxSize;
    }

    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空！");
        }
        int value = arr[front];
        front = (front+1)%maxSize;
        return value;
    }

    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列是空的，打印不出什么");
            return;
        }
        for (int i = front; i < front+size(); i++){
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }

    public int size(){
        return (rear + maxSize - front) % maxSize;
    }

    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空！");
        }
        return arr[front];
    }
}