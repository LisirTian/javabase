package com.java2345online.taobao.phpdir;

import lombok.extern.slf4j.Slf4j;

/**
 * <功能介绍>创建淘宝链接文件
 *
 * @author LISIR
 * @date 2020/5/5
 */
@Slf4j
public class CreateTaobaoLinkFile {
    public static void main(String[] args) {
        TaobaoFileInfo taobaoFileInfo = new TaobaoFileInfo();
        taobaoFileInfo.createHtmlFile();
    }
}
