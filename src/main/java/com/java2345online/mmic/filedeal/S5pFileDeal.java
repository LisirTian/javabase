package com.java2345online.mmic.filedeal;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <功能介绍> 文件转换到Excel
 *
 * @author LISIR
 * @date 2020/5/17
 */
@Slf4j
public class S5pFileDeal {

    public static String outputExcelFile = "D:\\Program Files (x86)\\Tencent\\WeChat Files\\l936108248\\FileStorage\\File\\2020-05\\BP4U1+_UNIT2.xlsx";

    public static void main(String[] args) {
        File file = new File("D:\\Program Files (x86)\\Tencent\\WeChat Files\\l936108248\\FileStorage\\File\\2020-05\\BP4U1+_UNIT2.S5P");
        try {
            List<String> list = FileUtils.readLines(file);
            List<List<String>> excelList = new ArrayList<>();
            List<String> excelRowList = new ArrayList<>();
            boolean startFlag = false;
            for (int i = 0; i < list.size(); i++) {
                String str = list.get(i);
                if (!startFlag) {
                    if (str.startsWith("!FREQ")) {
                        startFlag = !startFlag;
                        //第一行处理
                        String[] split = str.split("\\s+");
                        int length = split.length;
                        for (int j = 0; j < length; j++) {
                            if (j==0){
                            excelRowList.add(split[j]);
                            }else {
                            excelRowList.add(split[j]);
                            excelRowList.add(StringUtils.EMPTY);
                            }
                        }
                        excelList.add(excelRowList);
                        continue;
                    } else {
                        continue;
                    }
                }
                if (StringUtils.isBlank(str)){
                    continue;
                }
//                表头数据处理
                if (str.startsWith("!")) {
                    String[] split = str.split("\\s+");
                    int length = split.length;
                    for (int j = 1; j < length; j++) {
                        excelList.get(excelList.size()-1).add(split[j]);
                        excelList.get(excelList.size()-1).add(StringUtils.EMPTY);
                    }
                    continue;
                }
                if (str.matches("\\d.*")) {
                    excelRowList=new ArrayList<>();
                    excelList.add(excelRowList);
                    String[] split = str.split("\\s+");
                    int length = split.length;
                    for (int j = 0; j < length; j++) {
                        excelList.get(excelList.size()-1).add(split[j]);
                    }
                } else {
                    String[] split = str.trim().split("\\s+");
                    int length = split.length;
                    for (int j = 0; j < length; j++) {
                        excelList.get(excelList.size()-1).add(split[j]);
                    }

                }
            }
            writeToExcel(excelList);
            System.out.println("SUCCESS");
        } catch (IOException e) {
            log.info(e.getMessage());
        }
    }

    @SneakyThrows
    public static void writeToExcel(List<List<String>> excelList) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(outputExcelFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        for (int i = 0; i < excelList.size(); i++) {
            List<String> excelColList = excelList.get(i);
            XSSFRow row = sheet.createRow(i);
            for (int j = 0; j < excelColList.size(); j++) {
                XSSFCell cell = row.createCell(j);
                cell.setCellValue(excelColList.get(j));
            }
        }
        workbook.write(fileOutputStream);
    }
}
