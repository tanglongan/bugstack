package com.tanglongan.dp05_singleton;

/**
 * 饿汉模式：线程安全
 * 这种方式在类加载的初始化节点就已经完成了实例创建，因为类加载的过程可以保证只创建一次对象，因此是线程安全的
 */
public class Singleton_03 {

    private static final Singleton_03 instance = new Singleton_03();

    private Singleton_03() {
    }

    public Singleton_03 getInstance() {
        return instance;
    }

}
