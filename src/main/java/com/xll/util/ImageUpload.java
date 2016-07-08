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
	private static String IMAGE_UPLOAD_ROOT_PATH = "resources\\images\\";
	
	/**
	 *�ϴ�ͼƬ��������,���ҷ���ͼƬ�µ�ַ
	 */
	public String upload(MultipartFile file , HttpServletRequest request , HttpSession session){
		String path = session.getServletContext().getRealPath("/");
		String fileName = file.getOriginalFilename();
		String newFileName = new Date().getTime() + fileName.substring(fileName.lastIndexOf("."));
		String newFilePath = path + IMAGE_UPLOAD_ROOT_PATH + newFileName;
		File serverFile = new File(path + IMAGE_UPLOAD_ROOT_PATH, newFileName);
		try {
			file.transferTo(serverFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return newFilePath;
	}

}
