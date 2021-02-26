package com.ke.cas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicReference;

@Data
@AllArgsConstructor
@NoArgsConstructor
class User{
    String userName;
    int age;
}

/**
 * @author zxg_QAQ
 * @date 2021/2/25下午11:13
 */
public class ABADemo {

    public static void main(String[] args) {
        // 实现原子引用
        User user01 = new User("z3",12);
        User user02 = new User("li4",13);

        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(user01);

        System.out.println(atomicReference.compareAndSet(user01, user02)+"\t"+atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(user01, user02)+"\t"+atomicReference.get().toString());
    }
}
