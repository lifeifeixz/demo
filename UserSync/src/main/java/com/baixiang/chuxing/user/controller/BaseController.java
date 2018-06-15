package com.baixiang.chuxing.user.controller;

import com.baixiang.chuxing.core.exception.BizException;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.UUID;

public class BaseController {

	@Resource
    GridFsTemplate gridFsTemplate;
	private static final Logger logger = LoggerFactory.getLogger(BaseController.class);
	
    public String upload(MultipartFile file)throws Exception {
    	if(file==null){
    		return "";
    	}
        if (file.isEmpty()) {
            throw new BizException("文件为空");
        }
         // 获取文件名
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);    
        // 获取文件的后缀名
       // String suffixName = fileName.substring(fileName.lastIndexOf("."));
       // logger.info("上传的后缀名为：" + suffixName);    
        // 文件上传路径
        // 解决中文问题，liunx下中文路径，图片显示问题
        fileName = UUID.randomUUID()+"";  
//        File dest = new File(filePath, fileName);
//
//        // 检测是否存在目录
//        if (!dest.getParentFile().exists()) {
//            dest.getParentFile().mkdirs();
//        }
    
        try {
//            file.transferTo(dest);
//            InputStream input = new FileInputStream(dest);
			InputStream input = file.getInputStream();
            gridFsTemplate.store(input,fileName);
			IOUtils.closeQuietly(input);
        }catch(Exception e){
        	throw new BizException(e);
        }
        
        return fileName;
   }
    
}
