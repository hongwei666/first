package com.ghw.test;

import org.springframework.stereotype.Component;

@Component

public class Woman implements People {
    @Override
    public void say() {
        System.out.println("我是woman");
    }


}
