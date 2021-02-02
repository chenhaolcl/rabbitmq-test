package cn.ch.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Classname FileController
 * @Description
 * @create 2021/2/2
 * @Author random
 */
@RequestMapping("file")
@RestController
@Slf4j
public class FileController {

    public String uploadFile(@RequestParam("files") MultipartFile[] files) throws IOException {
        if (files.length <= 0){
            return "请上传文件";
        }
        for (MultipartFile file : files){
            //源文件名
            String originalFilename = file.getOriginalFilename();
            //文件格式
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            //新文件名
            String newFilename = UUID.randomUUID() + "." + suffix;
            //文件存储路径
            String filePath = "D:/uploadFile/";
            //文件全路径
            File targetFile = new File(filePath + newFilename);

            //如果目录不存在则创建目录
            if (!targetFile.getParentFile().exists()){
                targetFile.getParentFile().mkdir();
            }
            //保存文件
            file.transferTo(targetFile);

        }
        return "文件上传成功";
    }
}
