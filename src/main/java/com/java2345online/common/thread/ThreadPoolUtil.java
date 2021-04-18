package com.java2345online.common.thread;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <功能介绍>
 *
 * @author LISIR
 * @date 2020/7/18
 */
public class ThreadPoolUtil implements ThreadPool {
    public static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            500, 500, 5,
            TimeUnit.SECONDS, workQueue, threadFactory, handler);

    static {
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }
}
