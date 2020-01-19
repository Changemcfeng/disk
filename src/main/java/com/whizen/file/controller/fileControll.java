package com.whizen.file.controller;

import com.whizen.file.configure.CommonFileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class fileControll {
    private final static Logger logger = LoggerFactory.getLogger(fileControll.class);

    @Autowired
    private CommonFileUtil fileUtil;
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/fileup")
    public String uoloadFileToFast(@RequestParam("file") MultipartFile file) throws IOException {

        if(file.isEmpty()){
            System.out.println("文件不存在");
        }
        String path = fileUtil.uploadFile(file);
        System.out.println(path);
        return "success";
    }
}
