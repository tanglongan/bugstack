package com.tanglongan.dp05_singleton;

/**
 * 懒汉模式：线程不安全
 * 单例模式有一个特点就是不允许外部直接创建，也就是new，因此这里将默认的构造方法私有化，即加上private
 * 但是如下的方式，在多个线程或多个访问者同时获取对象的时候，可能造成实例化了多个对象，没有达到单例的要求
 */
public class Singleton_01 {

    private static Singleton_01 instance;

    private Singleton_01() {
    }

    public static Singleton_01 getInstance() {
        if (instance != null) {
            return instance;
        }
        instance = new Singleton_01();
        return instance;
    }

}
