package com.ghw.test;

/**
 * java core中提到类中的方法可以访问所属类的私有特性(属性或方法)
 */
public class ReturnValueTest {
    public static void main(String[] args) {
        User user1 = new User();
        user1.hello();
    }
}

class User {

    public void hello() {
        helloa();
    }

    private void helloa() {
        System.out.println("helloa");
    }
}