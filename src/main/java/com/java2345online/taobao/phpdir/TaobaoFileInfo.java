package com.java2345online.taobao.phpdir;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.CharSet;
import org.apache.commons.lang3.CharUtils;

import java.io.File;
import java.io.IOException;

/**
 * <功能介绍> 放置公用的taobao HTML跳转文件及生成HTML方法
 *
 * @author LISIR
 * @date 2020/5/5
 */
@Slf4j
public class TaobaoFileInfo {
    //    跳转页面内容
    public String htmlData = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <script>\n" +
            "        var _hmt = _hmt || [];\n" +
            "        (function() {\n" +
            "            var hm = document.createElement(\"script\");\n" +
            "            hm.src = \"https://hm.baidu.com/hm.js?$baidu\";\n" +
            "            var s = document.getElementsByTagName(\"script\")[0];\n" +
            "            s.parentNode.insertBefore(hm, s);\n" +
            "        })();\n" +
            "    </script>\n" +
            "    <script type=\"text/javascript\">\n" +
            "\twindow.location=\"$tbUrl\";\n" +
            "\t</script>\n" +
            "</head>\n" +
            "<body>\n" +
            "\t<script type=\"text/javascript\">\n" +
            "\t\tvar cnzz_protocol = ((\"https:\" == document.location.protocol) ? \" https://\" : \" http://\");document.write(unescape(\"%3Cspan id='cnzz_stat_icon_$cnzz'%3E%3C/span%3E%3Cscript src='\" + cnzz_protocol + \"s22.cnzz.com/z_stat.php%3Fid%3D$cnzz%26show%3Dpic1' type='text/javascript'%3E%3C/script%3E\"));document.getElementById(\"cnzz_stat_icon_$cnzz\").style.display = \"none\";\n" +
            "\t</script>\n" +
            "</body>\n" +
            "</html>";

    // 百度统计识别码
    String badu2345online = "6bed679037b4f0e9f1af737bec095dc0";

    // cnzz统计识别码
    String cnzz2345online = "1278594721";

    // 20200505处理链接
    private String tbLinkInfo
            = "http://tbone.2345online.com/cps/ppn\thttps://s.click.taobao.com/BVpdEjv\n" +
            "http://tbone.2345online.com/cps/ppw\thttps://s.click.taobao.com/IWldEjv\n" +
            "http://tbone.2345online.com/cps/ppe\thttps://s.click.taobao.com/vlgdEjv\n" +
            "http://tbone.2345online.com/cps/ppo\thttps://s.click.taobao.com/fvTdEjv\n" +
            "http://tbone.2345online.com/cps/ppi\thttps://s.click.taobao.com/vmTdEjv";

    public void createHtmlFile() {
        String htmlData1 = htmlData.replaceAll("\\$baidu", badu2345online);
        String htmlData2 = htmlData1.replaceAll("\\$cnzz", cnzz2345online);
        String[] split = tbLinkInfo.split("\\s");
        System.out.println(JSON.toJSONString(split));
        for (int i = 0; i < split.length; i++) {
            if (i % 2 == 1) {
                continue;
            }
            String tbstr = split[i];
            String tblink = split[i + 1];
            String[] split1 = tbstr.split("/");
            String str1 = split1[split1.length - 1];
            String replaceAll = htmlData2.replace("$tbUrl", tblink);
            String pathname = "E:/phpStudy/WWW/cps/2345online/tbone/cps/" + str1 + "/index.html";
            File file = new File(pathname);
            String data = replaceAll;
            String encoding = "UTF-8";
            writeStrToFile(file, data, encoding);
        }
    }

    /**
     * 写入文件内容
     *
     * @param file     文件全路径
     * @param data     文件内容
     * @param encoding 编码
     */
    public void writeStrToFile(File file, String data, String encoding) {
        try {
            FileUtils.writeStringToFile(file, data, encoding);
            log.info("SUCESS 成功写入文件！");
        } catch (IOException e) {
            log.error("ERROR 写入文件出错！");
        }
    }
}
