package com.ta.framework.controller;

import com.ta.framework.dao.PictureDao;
import com.ta.framework.entity.Dto.Result;
import com.ta.framework.entity.Picture;
import com.ta.framework.util.QiniuCloudUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@Controller
public class PictureController {

    @Autowired
    private PictureDao pictureDao;

    @ResponseBody
    @RequestMapping(value="/uploadImg", method=RequestMethod.POST)
    public Result<Picture> uploadImg(@RequestParam MultipartFile image, HttpServletRequest request) {
        Result<Picture> result = new Result<>();
        Picture P =new Picture();
        if (image.isEmpty()) {
            result.setMsg("文件为空，请重新上传");
            return result;
        }
        try {
            byte[] bytes = image.getBytes();
            String imageName = UUID.randomUUID().toString();
            QiniuCloudUtil qiniuUtil = new QiniuCloudUtil();
            try {
                //使用base64方式上传到七牛云
                String url = qiniuUtil.put64image(bytes, imageName);
                result.setMsg("文件上传成功");
                result.setData(new Picture(url));
                //路径存入数据库
                P.setPictureWay(url);
                pictureDao.insert(P);
            } catch (Exception e) {
                e.printStackTrace();
            }
            result.setData(P);
            return result;
        } catch (IOException e) {
            result.setMsg("文件上传发生异常！");
            return result;
        }
    }

}
