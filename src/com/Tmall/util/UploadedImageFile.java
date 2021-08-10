package com.Tmall.util;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author jingyi
 * @Classname UploadedImageFile
 * @description 图片上传工具类
 * @date 2021/8/3 9:42
 */
public class UploadedImageFile {
    MultipartFile image;

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
