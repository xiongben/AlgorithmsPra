package com.xiongben.demo1;

public class AdjacentList {
    int u[] = {0,1,4,1,2,1};
    int v[] = {0,4,3,2,4,3};
    int w[] = {0,9,8,5,6,7};
    int first[];
    int next[];
    int n = 4;
    int m = 5;

    AdjacentList(){
        for (int i=1;i<=n;i++){
            first[i] = -1;
        }
        for (int i=1;i<=n;i++){
            next[i] = first[u[i]];
            first[u[i]] = i;
        }
    }
}
