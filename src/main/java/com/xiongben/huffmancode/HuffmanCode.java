package com.xiongben.huffmancode;

import java.util.*;

public class HuffmanCode {
    public static void main(String[] args) {

    }

    //生成霍夫曼树对应的霍夫曼编码
    static Map<Byte, String> huffmanCodes = new HashMap<Byte, String>();
    static StringBuilder stringBuilder = new StringBuilder();

    /**
     *
     * @param node 传入结点
     * @param code  路径 ，左子节点是0，右子节点是1
     * @param stringBuilder 用于字符串拼接
     */
    private static void getCodes(Node node,String code,StringBuilder stringBuilder){
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        if(node != null){
            if(node.data == null){
                getCodes(node.left,"0",stringBuilder2);
                getCodes(node.right,"1",stringBuilder2);
            }else {
                huffmanCodes.put(node.data,stringBuilder2.toString());
            }
        }

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
        return nodes;
    }

    private static Node createHuffmanTree(List<Node> nodes){
        while (nodes.size()>1){
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(null,leftNode.weight+rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        return nodes.get(0);
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