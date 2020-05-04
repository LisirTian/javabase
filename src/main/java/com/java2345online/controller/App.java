package com.java2345online.controller;

import com.java2345online.vo.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <功能介绍>
 *
 * @author LISIR
 * @date 2020/5/4
 */
@RequestMapping("")
@ResponseBody()
public interface App {
    @GetMapping("/getString")
    String getCallTest();

    @GetMapping("/getMap")
    Student getMapTest();
}
