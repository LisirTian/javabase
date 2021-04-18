package com.java2345online;

import com.java2345online.common.thread.ThreadPoolUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <功能介绍>
 *
 * @author LISIR
 * @date 2020/5/4
 */
@Slf4j
public class Test {
    Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        thread();
//        ConcurrentHashMap
    }

    static void thread() {
        for (int i = 0; i < 10; i++) {
            String str = "test";
            int finali = i + 1;
            ThreadPoolUtil.threadPoolExecutor
                    .submit(() ->
                            log.info("{}: {} : {}", Thread.currentThread().getName(), str, finali)
                    );
        }
    }

    static void test1() {
        //        File file = new File("D:\\Program Files (x86)\\Tencent\\WeChat Files\\l936108248\\FileStorage\\File\\2020-05\\BP4U1+_UNIT2.S5P");
        File file = new File("/usr/local");
        if (file.exists()) {
            System.out.println("---aaa");
//            file.mkdirs();
        }
//        try {
//            List<String> list = FileUtils.readLines(file);
//            Iterator iterator = list.iterator();
//            while (iterator.hasNext()) {
//                Object next = iterator.next();
//                if (next instanceof String) {
//                    String str = (String) next;
//                    System.out.println(str);
//                }
//
//            }
//        } catch (IOException e) {
//            log.info(e.getMessage());
//        }
    }
}
