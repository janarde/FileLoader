package main.java.com.mobile.grazie.uploader.controller;

import main.java.com.mobile.grazie.uploader.model.UploaderModel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;


@Controller
@RequestMapping(value = "/upload")
public class UploadController {

	@RequestMapping(method = RequestMethod.GET)
	public String getUploadForm(Model model) {
		model.addAttribute(new UploaderModel());
		return "upload/uploadForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String create(UploaderModel model, BindingResult result) {
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.err.println("Error = " + error.getCode() + " - " + error.getDefaultMessage());
			}
			return "upload/uploadForm";
		}
		
	    // Some type of file processing...
	    System.err.println("-------------------------------------------");
	    System.err.println("Test upload: " + model.getName());
	    System.err.println("Test upload: " + model.getFileData().getOriginalFilename());
	    System.err.println("-------------------------------------------");
	 
	    return "redirect:/app/";
	}
	
}
