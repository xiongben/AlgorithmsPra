package com.xiongben.demo1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DeepSearch {
   public int e[][] = new int[6][6];
   public int book[] = new int[6];
   public int sum = 0;
   public int n,m;
   public int side[][] = {
           {0,1},{0,2},{0,4},{1,3},{2,4}
   };

   DeepSearch(){
      n = 5;
      m = 5;
      for (int i = 0; i < n; i++){
          for(int j = 0; j < n; j++){
              if(i == j){
                  e[i][j] = 0;
              }else{
                  e[i][j] = Integer.MAX_VALUE;
              }
          }
      }

      for (int i = 0; i<m;i++){
         int a = side[i][0];
         int b = side[i][1];
         e[a][b] = 1;
         e[b][a] = 1;
      }
       for (int i = 0; i < n; i++){
           System.out.println(Arrays.toString(e[i]));
       }

      book[0] = 1;
      dfs(0);
   }

   public void dfs(int cur){
       System.out.println("this is :" + cur);
       sum++;
       if (sum == n) return;
       for (int i=0;i<n;i++){
           if(e[cur][i] == 1 && book[i] == 0){
               book[i] = 1;
               dfs(i);
           }
       }
       return;
   }



}
