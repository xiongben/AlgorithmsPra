package com.xiongben.huffmancode;

import java.util.*;

public class HuffmanCode {
    public static void main(String[] args) {

    }

    //前序遍历
    private static void preOrder(Node root){
        if(root != null){
            root.preOrder();
        }else {
            System.out.println("空树，无法遍历");
        }
    }

    private static List<Node> getNodes(byte[] bytes){
        ArrayList<Node> nodes = new ArrayList<Node>();
        Map<Byte,Integer> counts = new HashMap<Byte, Integer>();
        for (byte b : bytes){
            Integer count = counts.get(b);
            if(count == null){
                counts.put(b,1);
            }else {
                counts.put(b,count+1);
            }
        }
        for (Map.Entry<Byte,Integer> entry:counts.entrySet()){
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
    }

}

class Node implements Comparable<Node> {
    Byte data;
    int weight; //结点权值
    Node left;
    Node right;

    public void preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }

    }

    public Node(Byte data,int weight){
        this.weight = weight;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight; //从小到大排列
    }
}