package com.java2345online.controller.impl;

import com.alibaba.fastjson.JSON;
import com.java2345online.controller.AppController;
import com.java2345online.vo.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

/**
 * <功能介绍>
 *
 * @author LISIR
 * @date 2020/5/4
 */
@Controller
@Slf4j
public class AppControllerImpl implements AppController {
    @Override
    public String getCallTest() {
        log.debug("msg");
        return "test String";
    }

    @Override
    public Student getMapTest() {
        Student student = new Student();
        student.setName("孙悟空");
        return student;
    }
}
