package com.xiongben.linkedList;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        doubleLinkedList.addNodeByOrder(hero1);
        doubleLinkedList.addNodeByOrder(hero3);
        doubleLinkedList.addNodeByOrder(hero4);
        doubleLinkedList.addNodeByOrder(hero2);

//        doubleLinkedList.addNode(hero1);
//        doubleLinkedList.addNode(hero3);
//        doubleLinkedList.addNode(hero4);
//        doubleLinkedList.addNode(hero2);

        doubleLinkedList.showLinked();

        System.out.println("=====进行删除测试=====");
        doubleLinkedList.deleteNode(3);
        doubleLinkedList.showLinked();
    }
}

class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0,"","");

    public HeroNode2 getHead(){
        return head;
    }

    public void addNode(HeroNode2 node){
        HeroNode2 temp = head;
        while (true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    public void addNodeByOrder(HeroNode2 node){
        HeroNode2 temp = head;
        Boolean flag = false;
        HeroNode2 elsenode;
        while (true){
            if(temp.next == null){
                break;
            }
            if(node.no < temp.next.no){
                break;
            }
            if(node.no == temp.next.no){
                flag = true;
                break;
            }
            temp = temp.next;

        }
        if(flag){
            System.out.println("这个编号的节点已经存在了,不能加入");
        }else {
            if(temp.next!=null){
                elsenode = temp.next;
                temp.next = node;
                node.pre = temp;
                node.next = elsenode;
                elsenode.pre = node;
            }else{
                temp.next = node;
                node.pre = temp;
            }

        }
    }

    public void deleteNode(int num){
        HeroNode2 temp = head.next;
        Boolean flag = false;
        while (true){
            if(temp == null){
                break;
            }
            if(temp.no == num){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
//            System.out.println(temp);
            temp.pre.next = temp.next;
            if(temp.next != null){
                temp.next.pre = temp.pre;
            }
        }else{
            System.out.println("没有找到可以删除的对象");
        }
    }

    public void updateNode(HeroNode2 node){
        HeroNode2 temp = head.next;
        Boolean flag = false;
        while (true){
            if(temp == null){
                break;
            }
            if(temp.no == node.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.name = node.name;
            temp.nickname = node.nickname;
        }else{
            System.out.println("没有找到可以修改的对象");
        }
    }

    public void showLinked(){
        HeroNode2 temp = head.next;
        while (true){
            if (temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}


class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    HeroNode2(int no,String name,String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}