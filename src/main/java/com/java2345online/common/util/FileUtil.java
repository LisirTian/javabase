package com.java2345online.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * <功能介绍>
 *
 * @author LISIR
 * @date 2020/6/21
 */
@Slf4j
public class FileUtil {
    /**
     * 判断非法路径
     *
     * @param path 文件路径
     * @return 是否是非法路径
     */
    public static boolean isIllegalPath(String path) {
        String tmpPath = path;
        if (StringUtils.isEmpty(tmpPath)) {
            return false;
        }
        String separator = File.separator;
        tmpPath = RegExUtils.replaceAll(tmpPath, "/", separator);
        tmpPath = RegExUtils.replaceAll(tmpPath, "\\", separator);
        if (StringUtils.startsWith(tmpPath, ".." + separator)) {
            return true;
        }
        return false;
    }

    /**
     * 判断文件是否是图片文件
     *
     * @param uploadFile 上传的接收的文件
     * @return 是否为图片
     */
    public static boolean isImageFile(MultipartFile uploadFile) {
        String fileName = uploadFile.getOriginalFilename();
        if (StringUtils.isEmpty(fileName)) {
            return false;
        }
        if (!fileName.matches("^.+\\.(jpg|png|gif)$")) {
            return false;
        }
        try (InputStream inputStream = uploadFile.getInputStream()) {
            BufferedImage bufferedImage = ImageIO.read(inputStream);
            int height = bufferedImage.getHeight();
            int width = bufferedImage.getWidth();
            //如果有一项为0 表示不是图片
            if (height == 0 || width == 0) {
                return false;
            }
        } catch (IOException e) {
            log.info("imageFile Check occurs An error");
        }
        return true;
    }
}
