package com.ghw.test;

public class Hero {

    private String name; //姓名

    private float hp; //血量

    private float armor; //护甲

    private int moveSpeed; //移动速度

    public Hero() {

    }

    public Hero(String name, float hp) {
        this.name = name;
        this.hp = hp;
    }

    public static void main(String[] args) {
        String s1 = "ghw";
        String s2 = new String("ghw");
        String s3 = new String("ghw");
        System.out.println("s1==s2" + s1 == s2);
        System.out.println("s2==s3" + s2 == s3);
        System.out.println("s1==s3:" + s1 == s3);

    }

    //复活
    public void revive(Hero h) {
        h = new Hero("提莫", 383);
    }

}