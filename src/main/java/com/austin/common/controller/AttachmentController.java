package com.austin.common.controller;


import com.austin.common.entity.Attachment;
import com.austin.common.service.IAttachmentService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * <p>
 * 附件表 前端控制器
 * </p>
 *
 * @author AustinGJ
 * @since 2021-03-18
 */
@RestController
@RequestMapping("/attachment")
@Api("附件前端控制器")
public class AttachmentController {

    @Autowired
    private IAttachmentService service;


    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Value("${prop.upload-folder}")
    private String FILE_PATH;








    private Attachment writeFile(MultipartFile file){
        Attachment at = new Attachment();
        byte[] bytes;
        Path result = null;
        try {
            bytes = file.getBytes();
            String fileName = file.getOriginalFilename(); at.setFileName(fileName);
            String fileSuffix = fileName.substring(fileName.lastIndexOf(".")+1); at.setExt(fileSuffix);
            String nowTimes = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
            String nowDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
            String newFileName = fileName.substring(0,fileName.lastIndexOf("."))+"-"+nowTimes+"."+fileSuffix;
            Path path = Paths.get(FILE_PATH+"/"+nowDate);
            if(!Files.isWritable(path)) Files.createDirectories(path);
            at.setCtime(LocalDateTime.now());
            at.setExt(fileSuffix);
            at.setUrl("http://new.sevencai.com/ucenter/upload/file"+"/"+nowDate+"/"+newFileName);
            this.service.save(at);
            result = Files.write(Paths.get(FILE_PATH+"/"+nowDate+"/"+newFileName),bytes);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        System.out.println(result.getFileName());
        return at;
    }



}

