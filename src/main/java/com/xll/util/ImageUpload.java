package com.xll.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;


/**
 *@author xialonglei
 *@since 2016/7/8 
 */
public class ImageUpload {
	/**
	 *上传图片到服务器,并且返回图片新地址
	 */
	public String upload(MultipartFile file , HttpServletRequest request , HttpSession session){
		String path = session.getServletContext().getRealPath("/");
		String fileName = file.getOriginalFilename();
		String newFileName = new Date().getTime() + fileName.substring(fileName.lastIndexOf("."));
		File serverFile = new File(path + Constants.IMAGE_UPLOAD_ROOT_PATH, newFileName);
		try {
			file.transferTo(serverFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Constants.IMAGE_UPLOAD_ROOT_PATH + newFileName;
	}

}
