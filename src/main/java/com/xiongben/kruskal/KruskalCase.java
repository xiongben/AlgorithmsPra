package com.xiongben.kruskal;

public class KruskalCase {

    private int edgeNum; //边个数
    private char[] vertexs; //定点数组
    private int[][] matrix; //邻接矩阵
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //克鲁斯卡尔算法的邻接矩阵
        int matrix[][] = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {   0,  12, INF, INF, INF,  16,  14},
                /*B*/ {  12,   0,  10, INF, INF,   7, INF},
                /*C*/ { INF,  10,   0,   3,   5,   6, INF},
                /*D*/ { INF, INF,   3,   0,   4, INF, INF},
                /*E*/ { INF, INF,   5,   4,   0,   2,   8},
                /*F*/ {  16,   7,   6, INF,   2,   0,   9},
                /*G*/ {  14, INF, INF, INF,   8,   9,   0}};

    }

    public KruskalCase(char[] vertexs,int[][] matrix){
        int vlen = vertexs.length;
        this.vertexs = new char[vlen];
        this.vertexs = vertexs;
        this.matrix = matrix;
        //统计边的个数
        for (int i=0;i<vlen;i++){
            for (int j=i+1;j<vlen;j++){
                if(this.matrix[i][j] != INF){
                    this.edgeNum++;
                }
            }
        }
    }

    public void kruskal() {

    }

    public void print(){
        System.out.println("邻接矩阵为：\n");
        for (int i=0;i<vertexs.length;i++){
            for (int j=0;j<vertexs.length;j++){
                System.out.printf("%12d",matrix[i][j]);
            }
            System.out.println();
        }
    }

    //对边进行冒泡排序
    public void sortEdges(EData[] edges){
        for (int i=0;i<edges.length-1;i++){
            for (int j=0;j<edges.length-i-1;j++){
                if(edges[j].weight > edges[j+1].weight){
                    EData tmp = edges[j];
                    edges[j] = edges[j+1];
                    edges[j+1] = tmp;
                }
            }
        }
    }

    //获取顶点对应的下标
    private int getPosition(char ch) {
        for (int i=0;i<vertexs.length;i++){
            if(vertexs[i] == ch){
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取图中边的数组
     * @return
     */
    private EData[] getEdges() {
        int index = 0;
        EData[] edges = new EData[edgeNum];
        for (int i=0;i<vertexs.length;i++){
            for (int j=i+1;j<vertexs.length;j++){
                if(matrix[i][j] != INF){
                    edges[index++] = new EData(vertexs[i],vertexs[j],matrix[i][j]);
                }
            }
        }
        return edges;
    }

    /**
     * 获取下标为i的顶点的终点，用于判断两个顶点的终点是否相同，即是否构成环路
     * @param ends 各个顶点的终点数组
     * @param i 对应顶点的下标
     * @return
     */
    private int getEnd(int[] ends,int i){
        while (ends[i] != 0){
            i = ends[i];
        }
        return i;
    }
}


class EData {
    char start;
    char end;
    int weight;

    public EData(char start,char end,int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EData{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}