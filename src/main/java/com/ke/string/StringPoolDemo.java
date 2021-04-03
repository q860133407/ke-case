package com.ke.string;

/**
 * @author zxg_QAQ
 * @date 2021/4/3下午4:41
 */
public class StringPoolDemo {

    public static void main(String[] args) {
        String str1 = new StringBuilder("test01").append("test02").toString();
        System.out.println(str1);
        System.out.println(str1.intern());
        String str2 = new StringBuilder("ja").append("va").toString();
        String str3 = new String("java");
        System.out.println(str2);
        System.out.println(str2.intern());
        System.out.println(str2 == str3);
        System.out.println(str2.intern() == str3.intern());
    }
}
