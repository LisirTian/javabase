package com.java2345online.controller.impl;

import com.alibaba.fastjson.JSON;
import com.java2345online.controller.App;
import com.java2345online.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <功能介绍>
 *
 * @author LISIR
 * @date 2020/5/4
 */
@Controller
//@ResponseBody
public class AppImpl implements App {
    @Override
    public String getCallTest() {

        return "test String";
    }

    @Override
    public Student getMapTest() {
        Student student = new Student();
        student.setName("孙悟空");
        return student;
    }
}
