package com.xiongben.obj;

public class Person {
    private String name;
    private int score;

    public int getScore() {
        return score;
    }

    public Person(String name, int score){
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return this.name + ":" + this.score;
    }
}
