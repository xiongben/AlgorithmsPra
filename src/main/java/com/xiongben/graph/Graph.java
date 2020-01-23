package com.xiongben.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {

    private ArrayList<String> vertexList; //顶点集合
    private  int[][] edges; //邻接矩阵
    private int numOfEdges; //边的个数
    private boolean[] isVisited;  //记录某个节点是否被访问

    public static void main(String[] args) {
        int n = 8;
//        String vertexs[] = {"A", "B", "C", "D", "E"};
        String vertexs[] = {"1","2","3","4","5","6","7","8"};
        Graph graph = new Graph(n);
        for(String vertex:vertexs){
            graph.insertVertex(vertex);
        }



        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);

        graph.showGraph();
        System.out.println("深度遍历");
        graph.dfs(); // A->B->C->D->E [1->2->4->8->5->3->6->7]

        System.out.println("广度优先!");
        graph.bfs();

    }

    public Graph(int n){
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
    }

    public int getFirstNeighbor(int index){
        for (int j=0;j<vertexList.size();j++){
            if(edges[index][j] > 0){
                return j;
            }
        }
        return -1;
    }

    public int getNextNeighbor(int v1,int v2){
        for (int j=v2+1;j<vertexList.size();j++){
            if(edges[v1][j] > 0){
                return j;
            }
        }
        return -1;
    }

    public void dfs(boolean[] isVisited,int i){
        System.out.print(getValueByIndex(i)+"->");
        isVisited[i] = true;
        int w = getFirstNeighbor(i);
        while (w != -1){
            if(!isVisited[w]){
                dfs(isVisited,w);
            }
            w = getNextNeighbor(i,w);
        }
    }

    public void dfs(){
        isVisited = new boolean[vertexList.size()];
        for (int i=0;i<getNumOfVertex();i++){
            if(!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }

    //广度优先
    private void bfs(boolean[] isVisited,int i){
        int u;
        int w;
        LinkedList queue = new LinkedList();
        System.out.print(getValueByIndex(i)+"->");
        isVisited[i] = true;
        queue.addLast(i);
        while (!queue.isEmpty()){
            u = (Integer)queue.removeFirst();
            w = getFirstNeighbor(i);
            while (w != -1){
                if(!isVisited[w]) {
                    System.out.print(getValueByIndex(w)+"->");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                w = getNextNeighbor(u,w);
            }
        }
    }

    public void bfs(){
        isVisited = new boolean[vertexList.size()];
        for (int i=0;i<getNumOfVertex();i++){
            if(!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }

    //图中常用的方法
    public int getNumOfVertex(){
        return vertexList.size();
    }

    public void showGraph(){
        for (int[] link : edges){
            System.out.println(Arrays.toString(link));
        }
    }

    public int getNumofEdges(){
        return numOfEdges;
    }

    public String getValueByIndex(int i){
        return vertexList.get(i);
    }

    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }

    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
