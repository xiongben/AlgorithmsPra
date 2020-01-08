package com.xiongben.hashtab;

import java.util.Scanner;

//补上删除的方法
public class HashTab {
    public static void main(String[] args) {
        //创建哈希表
        HashTableClass hashTab = new HashTableClass(7);

        //写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add:  添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("del: 删除雇员");
            System.out.println("exit: 退出系统");
            key = scanner.next();
            if ("add".equals(key)) {
                System.out.println("输入id");
                int id = scanner.nextInt();
                System.out.println("输入名字");
                String name = scanner.next();
                //创建 雇员
                Emp emp = new Emp(id, name);
                hashTab.add(emp);
            } else if ("list".equals(key)) {
                hashTab.list();
            } else if ("find".equals(key)) {
                int id;
                System.out.println("请输入要查找的id");
                id = scanner.nextInt();
                hashTab.findEmpById(id);
            }else if("del".equals(key)){
                int id;
                System.out.println("请输入要查找的id");
                id = scanner.nextInt();
                hashTab.delete(id);
            } else if ("exit".equals(key)) {
                scanner.close();
                System.exit(0);
            }
        }
    }
}

class HashTableClass {
    private EmpLinkedList[] empLinkedListArray;
    private int size;

    HashTableClass(int size){
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];
        for (int i=0;i<empLinkedListArray.length;i++){
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp){
        int empLinkedListNo = hashFun(emp.id);
        empLinkedListArray[empLinkedListNo].add(emp);
    }

    public void delete(int id){
        int empLinkedListNo = hashFun(id);
        System.out.println(empLinkedListNo);
        empLinkedListArray[empLinkedListNo].delete(id);
    }

    public void list(){
        for(int i=0;i<size;i++){
            empLinkedListArray[i].list(i);
        }
    }

    public void findEmpById(int id){
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNo].findEmpById(id);
        if(emp != null){
            System.out.printf("在第%d条链表中找到 雇员 id = %d\n", (empLinkedListNo), id);
        }else{
            System.out.println("在哈希表中，没有找到该雇员~");
        }
    }
    public int hashFun(int id){
        return id % size;
    }

}

class Emp {
    public int id;
    public String name;
    public Emp next;

    Emp(int id,String name){
        this.id = id;
        this.name = name;
    }
}

class EmpLinkedList {
    private Emp head = new Emp(-1,null);

    public void add(Emp emp){
        if(head.next == null){
            head.next = emp;
            return;
        }
        Emp empcur = head;
        while (true){
            if(empcur.next == null){
                break;
            }
            empcur = empcur.next;
        }
        empcur.next = emp;
    }

    public void delete(int id){
        if(head.next == null){
            System.out.println("链表为空,无法删除");
            return;
        }
        Emp empcur = head;
        boolean flag = false;
        while (true){
            if(empcur.next == null){
                break;
            }
            if(empcur.next.id == id){
                flag = true;
                break;
            }
            empcur = empcur.next;
        }
        if(flag){
            empcur.next = empcur.next.next;
        }else{
            System.out.println("没有找到要删除的元素");
        }
//        while (true){
//            System.out.printf(" => id=%d name=%s\t", empcur.id, empcur.name);
//            if(empcur.next == null){
//                break;
//            }
//            empcur= empcur.next;
//        }
//        System.out.println();
    }

    public void list(int no){
        if(head.next == null){
            System.out.println("第 "+(no)+" 链表为空");
            return;
        }
        System.out.print("第 "+(no)+" 链表的信息为");
        Emp empcur = head.next;
        while (true){
            System.out.printf(" => id=%d name=%s\t", empcur.id, empcur.name);
            if(empcur.next == null){
                break;
            }
            empcur= empcur.next;
        }
        System.out.println();
    }

    public Emp findEmpById(int id){
        if(head.next == null){
            System.out.println("链表为空");
            return null;
        }
        Emp empcur = head.next;
        while (true){
            if(empcur.id == id){
                break;
            }
            if(empcur.next == null){
                empcur = null;
                break;
            }
            empcur = empcur.next;
        }
        return empcur;
    }
}