package com.szhrnet.taoqiapp.utils;


import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @version 1.0.0
 */
public class ThreadPoolManageUtils {
    private static final String TAG = ThreadPoolManageUtils.class.getSimpleName();
    // 单例模式
    private static final ThreadPoolManageUtils instance;
    // 全局的线程池
    private final Executor executor;


    static {
        instance = new ThreadPoolManageUtils();
    }

    private ThreadPoolManageUtils() {
        // 新建一个5个线程的线程池
        executor = Executors.newFixedThreadPool(5);
    }


    /**
     * 异步运行的方法
     *
     * @param runnable Runnable
     */
    public static void runOnAsync(Runnable runnable) {
        // 拿到单例，拿到线程池，然后异步执行
        instance.executor.execute(runnable);
    }

}
