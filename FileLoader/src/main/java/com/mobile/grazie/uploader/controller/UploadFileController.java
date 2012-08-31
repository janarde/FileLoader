package com.mobile.grazie.uploader.controller;

import com.mobile.grazie.uploader.model.UploadItem;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import java.io.FileOutputStream;

import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping(value = "/uploadFile")
public class UploadFileController {

		
	@RequestMapping(method = RequestMethod.GET)
	public String getUploadForm(Model model) {
		model.addAttribute(new UploadItem());
		return "/uploadFile";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String create(UploadItem uploadItem, BindingResult result,
			             HttpServletResponse response, HttpServletRequest request,
			             HttpSession session) {
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.err.println("Error = " + error.getCode() + " - " + error.getDefaultMessage());
			}
			return "/uploadFile";
		}
		
		
		try {
				MultipartFile file = uploadItem.getFileData();
				String fileName = null;
				
				InputStream inputStream = null;
				OutputStream outputStream = null;
				
				if (file.getSize() > 0) {
					inputStream = file.getInputStream();
					if (file.getSize() > 1000000) {
						System.out.println("File Size = " + file.getSize());
						return "redirect:/forms/uploadfileindex";
					}
					
					System.out.println("File Size = " + file.getSize());
					//fileName = request.getSession().getServletContext().getRealPath("") + "/images/" + file.getOriginalFilename();
					fileName = "C:\\working\\Mongo\\" + file.getOriginalFilename();
					outputStream = new FileOutputStream(fileName);
					
					System.out.println("fileName = " + file.getOriginalFilename());
					
					int readBytes = 0;
					byte[] buffer = new byte[10000];
					
					while ((readBytes = inputStream.read(buffer, 0, 10000)) != -1) {
						outputStream.write(buffer, 0, readBytes);
					}
					
					outputStream.close();
					inputStream.close();
				}
				
				session.setAttribute("uploadFile", file.getOriginalFilename());
				
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	 
	    return "redirect:/forms/uploadfileindex";
	}
	
}
