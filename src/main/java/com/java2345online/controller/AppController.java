package com.java2345online.controller;

import com.java2345online.vo.Student;
import org.springframework.http.MediaType;
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
public interface AppController {
    @RequestMapping(path = "/getString",
            produces = MediaType.APPLICATION_JSON_VALUE)
    String getCallTest();

    @RequestMapping(path = "/getMap",
            produces = MediaType.APPLICATION_JSON_VALUE)
    Student getMapTest();
}
