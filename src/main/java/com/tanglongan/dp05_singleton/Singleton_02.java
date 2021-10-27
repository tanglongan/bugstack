package com.tanglongan.dp05_singleton;

/**
 * 懒汉模式：线程安全
 */
public class Singleton_02 {

    private static Singleton_02 instance;

    private Singleton_02() {

    }

    /**
     * 获取实例
     * 添加了synchronized关键字，这样可以保证线程安全，但是在多线程环境下，因为锁占用，导致资源访问性能不高
     */
    public static synchronized Singleton_02 getInstance() {
        if (instance != null) {
            return instance;
        }
        instance = new Singleton_02();
        return instance;
    }

}
