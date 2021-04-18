package com.java2345online.controller;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <功能介绍>
 *
 * @author LISIR
 * @date 2020/6/18
 */
@RequestMapping("")
@ResponseBody()
public interface DemoController {
    @RequestMapping("/uploadFile")
    void uploadFile(MultipartFile[] file) throws IOException;

    /**
     * 下载文件
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/downExcel")
    void downExcel( HttpServletRequest request,HttpServletResponse response) throws IOException;
}
