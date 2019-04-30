package com.unimas.poi.entity;

import java.io.Serializable;

public class User implements Serializable {
     /**
      * 版本号
      */
     private static final long serialVersionUID = 1L;
     //定义的私有属性
     private int id;
     private String name;
     private int age;
     private double score;
     //无参数的构造器
     public User(){
         
     }
     //有参数的构造器

    public User(int id, String name, int age, double score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;


    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}