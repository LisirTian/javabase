package com.java2345online.controller.impl;

import com.java2345online.controller.DemoController;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * <功能介绍>
 *
 * @author LISIR
 * @date 2020/6/18
 */
@Slf4j
@Controller
public class DemoControllerImpl implements DemoController {
    @Override
    public void uploadFile(MultipartFile[] file) throws IOException {
        for (int i = 0; i < file.length; i++) {
            saveFile(file[i]);
        }
    }

    public void saveFile(MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        // 判断文件夹是否存在
        String pathName = "E:/JavaWorkspace/filePathTest/upload";
        File fileDir = new File(pathName);
        // 表示文件夹不存在
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        File uploadfilePath = new File(pathName + "/" + filename);
        // 内存图片写入磁盘中
        file.transferTo(uploadfilePath);
    }

    @Override
    public void downExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String filePath = "E:/JavaWorkspace/filePathTest/upload/MMIC产品手册.pdf";
        String fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
//        String filePath = "E:/JavaWorkspace/upload/test1.xlsx";
        try (RandomAccessFile reader = new RandomAccessFile(filePath, "r");
             FileChannel channel = reader.getChannel();
             ServletOutputStream out = response.getOutputStream()) {
            response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            int bufferSize = 8192;
            ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
            while (channel.read(buffer) != -1) {
                out.write(buffer.array(), 0, buffer.position());
                buffer.clear();
            }
        }
        log.info("文件下载完成： {}", fileName);
    }
}
