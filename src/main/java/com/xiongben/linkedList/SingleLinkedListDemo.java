package com.xiongben.linkedList;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //加入元素
//        singleLinkedList.addNode(hero1);
//        singleLinkedList.addNode(hero3);
//        singleLinkedList.addNode(hero2);
//        singleLinkedList.addNode(hero4);

        singleLinkedList.addNodeByOrder(hero1);
        singleLinkedList.addNodeByOrder(hero4);
        singleLinkedList.addNodeByOrder(hero2);
        singleLinkedList.addNodeByOrder(hero3);

        HeroNode newnode = new HeroNode(1,"卡凯西","拷贝忍者");
        singleLinkedList.updateNode(newnode);

        singleLinkedList.showLinked();
        System.out.println("=========开始进行反转========");
        reverseLinked(singleLinkedList);
        singleLinkedList.showLinked();
    }


    //将单链表反转
    public  static  void reverseLinked(SingleLinkedList linkedlist){
        if(linkedlist.getHead().next == null || linkedlist.getHead().next.next == null){
            return;
        }
        HeroNode temp = linkedlist.getHead().next;
        HeroNode nextNode = null;
        HeroNode newlinkHead = new HeroNode(0,"","");
        while (temp != null){
            nextNode = temp.next;
            temp.next = newlinkHead.next;
            newlinkHead.next = temp;
            temp = nextNode;
        }
        linkedlist.getHead().next = newlinkHead.next;
    }

}



class SingleLinkedList {
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead(){
        return head;
    }

    public void addNode(HeroNode node){
       HeroNode temp = head;
       while (true){
           if(temp.next == null){
               break;
           }
           temp = temp.next;
       }
       temp.next = node;
    }

    public void addNodeByOrder(HeroNode node){
        HeroNode temp = head;
        Boolean flag = false;
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
            node.next = temp.next;
            temp.next = node;
        }
    }

    public void deleteNode(int num){
        HeroNode temp = head;
        Boolean flag = false;
        while (true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no == num){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next = temp.next.next;
        }else{
            System.out.println("没有找到可以删除的对象");
        }
    }

    public void updateNode(HeroNode node){
        HeroNode temp = head.next;
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
        HeroNode temp = head.next;
        while (true){
            if (temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    HeroNode(int no,String name,String nickname){
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