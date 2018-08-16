package com.ghw.test;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("ms")
public class Man implements People {

    @Override

    public void say() {
        System.out.println("我是男人");
    }


}
