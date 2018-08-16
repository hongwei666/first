package com.ghw.test;

import java.util.Date;

public class StringUtilsTest {
    public static void main(String[] args) {


        long starTime = new Date().getTime();
        String string = new String();
        StringBuilder stringb = new StringBuilder();
        for (int i = 0; i < 5000; i++) {
            stringb = stringb.append(i);
        }
        string = string + stringb;
        long endTime = new Date().getTime();
        System.out.println("StringBuilder花费时间:" + (endTime - starTime));   //StringBuilder花费时间:7


        long starTime2 = new Date().getTime();
        String string2 = new String();
        StringBuffer stringb2 = new StringBuffer();
        for (int i = 0; i < 5000; i++) {
            stringb2 = stringb2.append(i);
        }
        string2 = string2 + stringb2;
        long endTime2 = new Date().getTime();
        System.out.println("StringBuffer花费时间:" + (endTime2 - starTime2));  //StringBuffer花费时间:61


        long starTime3 = new Date().getTime();
        String string3 = new String();

        for (int i = 0; i < 5000; i++) {
            string3 = "0";
            string3 = string3 + i;
        }

        /*
                for (int i = 0; i < 10000; i++) {
                    String str = "";
                    str = str + i;
                    */


        long endTime3 = new Date().getTime();
        System.out.println("“+=”号花费时间:" + (endTime3 - starTime3));  //“+=”号花费时间:16822
    }


//        String s1 = StringUtils.remove("helloworld", "o");//移除字符或字符串，不管出现几次全部移除
//        String s2 = StringUtils.removeStart("hellohello", "he");
//        String s3 = StringUtils.removeStartIgnoreCase("HELLOhelloHELLO", "he");
//        String s4 = StringUtils.removeEnd("hellohello", "lo");
////        StringUtils.
//        System.out.println(s4);

//        Calendar calendar = new GregorianCalendar();
//        System.out.println(calendar.getTime());

//        int[] a = {25, 37, 14, 8, 94, 27};
//        Arrays.sort(a);
//        System.out.println(Arrays.toString(a));
//
//        for (int i : a) {
//            System.out.print(i + " ");
//        }


//        String s1 = StringUtils.reverse("hello world");
//        String s2 = StringUtils.reverseDelimited( )
//        System.out.println(s1);
//        System.out.println(s2);
//        System.out.println(s3);
//        System.out.println(s4);
//        System.out.println(s5);
//        System.out.println(s6);
//        System.out.println(s7);
//        System.out.println(s8);
//        boolean s1 = StringUtils.isBlank("\"");
//        System.out.println(s1);
//        int i = 0;
//        while(true){
//            System.out.println("hello"+i++);
//        }


}