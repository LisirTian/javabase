package com.java2345online.common.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <功能介绍>
 *
 * @author LISIR
 * @date 2020/6/21
 */
@Accessors(chain = true)
@Setter
@Getter
public class ImageVo {
//    private Integer error = 0;

    //表示用户上传文件是是否有错
    private String url;    //图片的虚拟路径

    private Integer width;    //宽度

    private Integer height;    //高度
}
