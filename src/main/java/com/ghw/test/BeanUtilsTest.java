package com.ghw.test;

import com.ghw.pojo.UserOld;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;


public class BeanUtilsTest {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        //1.生成对象
        UserOld u1 = new UserOld();
        UserOld u2 = new UserOld();
        Map map = new HashMap();
        map.put("id", 2);
        map.put("name", "hello");
        map.put("sex", "boy");
        map.put("address", "xian");

        //2.通过set方法赋值
        u1.setId(1);
        u1.setName("hello");
        u1.setSex("nan");
        u1.setAddress("addd");

        //需求：把u1中的属性拷贝到u2中，注意参数的顺序
//        BeanUtils.copyProperties(u2, u1);
//        System.out.println(u1);//User{id=1, name='hello', sex=nan, address='addd'}

        BeanUtils.copyProperties(u2, map);
        System.out.println(map);//{address=xian, sex=boy, name=hello, id=2}
        System.out.println(u2);//User{id=2, name='hello', sex=boy, address='xian'}
    }
}

