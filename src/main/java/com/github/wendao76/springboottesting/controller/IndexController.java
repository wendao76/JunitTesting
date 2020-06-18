package com.github.wendao76.springboottesting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wendao76
 * @version 1.0
 * @description 类描述信息
 * @className IndexController
 * @date 2020-6-18 15:05
 */
@RestController
@RequestMapping("/index")
public class IndexController {
	@GetMapping
	public String home(){
		return "Hello World!";
	}
}
