package com.mobile.grazie.uploader.model;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class UploadItem {

	private String name;
	private CommonsMultipartFile fileData;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CommonsMultipartFile getFileData() {
		return fileData;
	}
	public void setFileData(CommonsMultipartFile file) {
		this.fileData = file;
	}
	
}
