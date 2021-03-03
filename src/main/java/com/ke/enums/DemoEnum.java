package com.ke.enums;

import lombok.Getter;

/**
 * @author zxg_QAQ
 * @date 2021/3/4上午12:32
 */
@Getter
public enum DemoEnum {

    A(1,"A"),B(2,"B"),C(3,"C"),D(4,"D"),E(5,"E"),F(6,"F");

    DemoEnum(Integer code,String name) {
        this.code = code;
        this.name = name;
    }

    private Integer code;
    private String name;

    public static DemoEnum getDemoEnum(int index) {
        DemoEnum[] demoEnums = DemoEnum.values();
        for (DemoEnum demoEnum:demoEnums) {
            if (demoEnum.code == index) {
                return demoEnum;
            }
        }
        return null;
    }
}
