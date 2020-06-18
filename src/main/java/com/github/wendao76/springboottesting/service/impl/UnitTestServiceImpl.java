package com.github.wendao76.springboottesting.service.impl;

import com.github.wendao76.springboottesting.service.UnitTestService;
import org.springframework.stereotype.Service;

/**
 * @author wendao76
 * @version 1.0
 * @description 类描述信息
 * @className UnitTestServiceImpl
 * @date 2020-6-18 15:32
 */
@Service
public class UnitTestServiceImpl implements UnitTestService {
	@Override
	public String sayHello(String inStr) {
		return inStr + "->Testing";
	}
}
