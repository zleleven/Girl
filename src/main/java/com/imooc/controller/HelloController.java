package com.imooc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.properties.GirlProperties;

@RestController
public class HelloController {

	@Autowired
	GirlProperties girl;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String say() {
		return girl.getCupSize();
	}
		
}
