package com.mobile.grazie.uploader.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/uploadfileindex")
public class UploadIndexController {

	// display on get request
	@RequestMapping(method = RequestMethod.GET)
	public String showRegistration(Map<String, String> model) {
		return "uploadFile";
	}
	
	//process the form
	@RequestMapping(method = RequestMethod.POST)
	public String processRegistration(BindingResult result) {
		return "uploadFile";
	}
	
}
