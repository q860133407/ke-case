package com.ke.jvm.oom;

import java.nio.ByteBuffer;

/**
 * @author zxg_QAQ
 * @date 2021/3/23上午12:13
 */
public class DirectBufferMemoryDemo {

    public static void main(String[] args) throws Exception {
        System.out.println("配置的 maxDirectMemory:"+(sun.misc.VM.maxDirectMemory()/(double)1024/1024)+"MB");
        Thread.sleep(3000);
        ByteBuffer bb = ByteBuffer.allocateDirect(60*1024*1024);
        //Thread.sleep();
    }
}
