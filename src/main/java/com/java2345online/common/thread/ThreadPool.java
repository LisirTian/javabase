package com.java2345online.common.thread;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.*;

/**
 * <功能介绍>
 *
 * @author LISIR
 * @date 2020/7/18
 */
public interface ThreadPool {
    BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>(500);

    ThreadFactory threadFactory = new BasicThreadFactory.Builder().
            namingPattern("demo-%d").build();

    RejectedExecutionHandler handler = (r, handle) -> {
        handle.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
    };
}
