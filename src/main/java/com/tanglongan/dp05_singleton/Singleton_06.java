package com.tanglongan.dp05_singleton;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Java 并发库提供了很多原子类支持并发访问的数据安全性，如：AtomicInteger、AtomicBoolean、AtomicLong 和 AtomicReference。
 * AtomicReference<V> 可以封装引用一个V实例，上面支持并发访问的单例模式就是利用了这种特性。
 * 使用CAS的好处是不需要使用传统的加锁方式，而是依赖CAS的忙等算法、底层硬件的实现保证线程安全。
 * 相对于其他锁的实现，没有线程的切换和阻塞也就没有了额外的开销，并且可以支持较大的并发。当然，CAS也有一个缺点就是忙等，如果一直没有获取到，会陷于死循环。
 */
public class Singleton_06 {

    private static final AtomicReference<Singleton_06> INSTANCE = new AtomicReference<>();

    private static Singleton_06 instance;

    private Singleton_06() {
    }

    public static Singleton_06 getInstance() {
        while (true) {
            Singleton_06 instance = INSTANCE.get();
            if (null != instance) return instance;
            INSTANCE.compareAndSet(null, new Singleton_06());
            return INSTANCE.get();
        }
    }

    public static void main(String[] args) {
        System.out.println(Singleton_06.getInstance());
        System.out.println(Singleton_06.getInstance());
    }

}
