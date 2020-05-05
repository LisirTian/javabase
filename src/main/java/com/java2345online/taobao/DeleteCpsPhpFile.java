package com.java2345online.taobao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <功能介绍> 对本地PHP文件夹下文件处理
 *
 * @author LISIR
 * @date 2020/5/4
 */
public class DeleteCpsPhpFile {
    /**
     * 将taobao重定向文件里面的PHP文件去掉并换成index.html文件
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
//        String rootUrl = "E:/phpStudy/WWW/cps/jixieclub/cps";
//        String rootUrl = "E:/phpStudy/WWW/cps/jingletechan/cps";
//        String rootUrl = "E:/phpStudy/WWW/cps/haiererer/cps";
        String rootUrl = "E:/phpStudy/WWW/cps/jingletechan/m/cps";
        File cpsDir = new File(rootUrl);
        File[] cpsDirs = cpsDir.listFiles();
        List<File> tbDirs = new ArrayList();
        File publicDir = null;
        for (File dirTmp : cpsDirs){
            if (dirTmp.isDirectory()) {
                if(dirTmp.getName().equals("public")) {
                    publicDir = dirTmp;
                } else {
                    tbDirs.add(dirTmp);
                }
            }
        }
        StringBuilder headerStringBuilder = getTbDirHtmlStr(publicDir,"header.html");
        StringBuilder footerStringBuilder = getTbDirHtmlStr(publicDir,"footer.html");
        StringBuilder sectionStringBuilder = new StringBuilder();
        for (File tbDir : tbDirs){
            sectionStringBuilder = getTbDirHtmlStr(tbDir,"section.html");
            String tbDirPath = tbDir.getAbsolutePath();
            String tbDirIndexFilePath = tbDirPath + "/index.html";
            File outFile = new File(tbDirIndexFilePath);
            writeStringToFile(outFile, headerStringBuilder.append(sectionStringBuilder).append(footerStringBuilder).toString());
            File phpFile = new File(tbDirPath + "/index.php");
            File sectionFile = new File(tbDirPath + "/section.html");
            // 删除index.php文件
            if (phpFile.exists()){
                phpFile.delete();
            }
            // 删除 section.html文件
            if (sectionFile.exists()){
                sectionFile.delete();
            }
        }
//        System.out.println(headerStringBuilder);
//        System.out.println(sectionStringBuilder);
//        System.out.println(footerStringBuilder);
    }

    /**
     * 写入文件内容
     *
     * @param outFile
     * @param string
     * @throws IOException
     */
    public static void writeStringToFile(File outFile, String string) throws IOException {
        if (!outFile.exists()){
            outFile.createNewFile();
        }
        OutputStream out = new FileOutputStream(outFile);
        byte[] bytes = string.getBytes();
        out.write(bytes);
        out.close();
    }
    /**
     * 文件夹下文件名为fileName的string内容；例如tbone里面section.html文件
     * @param dir
     * @param fileName
     * @return
     */
    public static StringBuilder getTbDirHtmlStr(File dir, String fileName){
        StringBuilder stringBuilder = new StringBuilder();
        File[] files = dir.listFiles();
        for(File file : files){
            if (file.isFile() && file.getName().equals(fileName)){
                try {
                    stringBuilder = getStrFromFile(file);
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return stringBuilder;
    }

    /**
     * 读取文件内容为string
     */
    public static StringBuilder getStrFromFile(File file) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        InputStream in = new FileInputStream(file);
        byte[] tempbytes = new byte[1024];
        int byteread;
        while ((byteread = in.read(tempbytes)) != -1) {
            String str = new String(tempbytes, 0, byteread);
            stringBuilder.append(str);
        }
        in.close();
        return stringBuilder;
    }
}
