package com.xiongben.demo1;


import com.xiongben.obj.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSort {

   public void sortArr(){
       int[] arr1 = {5,3,88,90,23,42,76,34,79,12,13,21,22,63,81,27};
       int t = 0;
       for (int i=0;i<arr1.length-1;i++){
           for (int j=0;j<arr1.length-1-i;j++){
               if(arr1[j] < arr1[j+1]){
                   t = arr1[j];
                   arr1[j] = arr1[j+1];
                   arr1[j+1] = t;
               }
           }
       }
       System.out.println(Arrays.toString(arr1));
   }

   public void sortArr2(){
       List<Person> list1 = new ArrayList<Person>();
       list1.add(new Person("xiaoming",34));
       list1.add(new Person("xiaohong",62));
       list1.add(new Person("xiaoxiong",87));
       list1.add(new Person("xiaoliu",44));
       list1.add(new Person("xiaoxia",94));

       Person t;
       for (int i=0;i<list1.size()-1;i++){
           for (int j=0;j<list1.size()-1-i;j++){
               if(list1.get(j).getScore() < list1.get(j+1).getScore()){
                   t = list1.get(j);
                   list1.set(j,list1.get(j+1));
                   list1.set(j+1,t);
               }
           }
       }
       for (Person person: list1){
           System.out.println(person);
       }

   }
}
