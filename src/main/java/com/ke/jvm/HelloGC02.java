package com.ke.jvm;

/**
 * @author zxg_QAQ
 * @date 2021/3/17下午10:33
 */
public class HelloGC02 {

    public static void main(String[] args) {
        long totalMemory = Runtime.getRuntime().totalMemory(); // 返回 Java 虚拟机中的内存总量
        long maxMemory = Runtime.getRuntime().maxMemory(); // 返回 Java 虚拟机试图使用的最大内存量
        System.out.println("TOTAL_MEMORY(-Xms)="+totalMemory+"(字节)"+(totalMemory/(double)1024/1024)+"MB");
        System.out.println("MAX_MEMORY(-Xmx)="+maxMemory+"(字节)"+(maxMemory/(double)1024/1024)+"MB");
    }
}
