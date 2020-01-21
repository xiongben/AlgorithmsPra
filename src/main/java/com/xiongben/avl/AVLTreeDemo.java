package com.xiongben.avl;

public class AVLTreeDemo {
    public static void main(String[] args) {
        //int[] arr = {4,3,6,5,7,8};
//        int[] arr = { 10, 12, 8, 9, 7, 6 };
        int[] arr = { 10, 11, 7, 6, 8, 9 };
        //创建一个 AVLTree对象
        AVLTree avlTree = new AVLTree();
        //添加结点
        for(int i=0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }

        //遍历
        System.out.println("中序遍历");
        avlTree.infixOrder();

        System.out.println("在平衡处理~~");
        System.out.println("树的高度=" + avlTree.getRoot().height()); //3
        System.out.println("树的左子树高度=" + avlTree.getRoot().leftHeight()); // 2
        System.out.println("树的右子树高度=" + avlTree.getRoot().rightHeight()); // 2
        System.out.println("当前的根结点=" + avlTree.getRoot());//8
    }
}

class AVLTree {
    private Node root;

    public   Node getRoot(){
        return root;
    }



    public   Node search(int value){
        if(root == null){
            return null;
        }else {
            return root.search(value);
        }
    }

    public   Node searchParent(int value){
        if(root == null){
            return null;
        }else {
            return root.searchParent(value);
        }
    }

    public void add(  Node node){
        if (root == null){
            root = node;
        }else {
            root.add(node);
        }
    }

    /**
     * 删除右子树上最小的结点，用于和目标结点进行交换（也可以用于左子树上最大的结点）
     * @param node
     * @return
     */
    public int delRightTreeMin(  Node node){
          Node target = node;
        while (target.left != null){
            target = target.left;
        }
        delNode(target.value);
        return target.value;
    }

    /**
     * 删除某个结点。关键的地方
     * @param value
     */
    public void delNode(int value){
        if(root == null){
            return;
        }else {
              Node targetNode = search(value);
            if(targetNode == null){
                return;
            }
            if(root.left == null && root.right == null){
                root = null;
                return;
            }
              Node parentNode = searchParent(value);
            if(targetNode.left == null && targetNode.right == null){
                if(parentNode.left != null && parentNode.left.value == value){
                    parentNode.left = null;
                }else {
                    parentNode.right = null;
                }
            }else if(targetNode.left != null && targetNode.right != null){
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;
            }else {
                if(targetNode.left != null){
                    if(parentNode != null){
                        if(parentNode.left.value == value){
                            parentNode.left = targetNode.left;
                        }else {
                            parentNode.right = targetNode.left;
                        }
                    }else {
                        root = targetNode.left;
                    }
                }else {
                    if(parentNode != null){
                        if(parentNode.left.value == value){
                            parentNode.left = targetNode.right;
                        }else {
                            parentNode.right = targetNode.right;
                        }
                    }else {
                        root = targetNode.right;
                    }
                }
            }
        }
    }

    public void infixOrder(){
        if(root == null){
            System.out.println("树为空，无法排序");
        }else {
            root.infixOrder();
        }
    }
}


class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    /**
     * 返回左子树的高度
     * @return
     */
    public int leftHeight(){
        if(left == null){
            return 0;
        }
        return left.height();
    }

    /**
     * 返回右子树的高度
     * @return
     */
    public int rightHeight(){
        if(right == null){
            return 0;
        }
        return right.height();
    }

    /**
     * 返回以该节点为根节点的树的高度
     * @return
     */
    public int height(){
        return Math.max(left == null?0:left.height(),right == null?0:right.height())+1;
    }

    /**
     * 左旋转方法
     */
    public void leftRotate(){
        Node newNode = new Node(value);
        newNode.left = left;
        newNode.right = right.left;
        value = right.value;
        right = right.right;
        left = newNode;

    }

    public void rightRotate(){
        Node newNode = new Node(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;
    }

    /**
     * 查找要删除的结点
     *
     * @param value
     * @return
     */
    public Node search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    /**
     * 查找要删除结点的父节点
     *
     * @param value
     * @return
     */
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)){
            return this;
        }else{
            if(value < this.value && this.left != null){
                return this.left.searchParent(value);
            }else if(value >= this.value && this.right != null){
                return  this.right.searchParent(value);
            }else {
                return null;
            }
        }

    }

    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
        //添加完节点后，根据高度差进行旋转
        if(rightHeight() - leftHeight() > 1){
            if(right !=null && right.leftHeight() > right.rightHeight()){
                right.rightRotate();
                leftRotate();
            }else {
                leftRotate();
            }
            return;
        }
        if(leftHeight() - rightHeight() > 1){
            if(left != null && left.rightHeight() > left.leftHeight()){
                left.leftRotate();
                rightRotate();
            }else {
                rightRotate();
            }
        }
    }

    /**
     * 中序排序
     */
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}