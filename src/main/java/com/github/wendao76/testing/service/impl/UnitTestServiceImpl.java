package com.github.wendao76.testing.service.impl;

import com.github.wendao76.testing.mapper.UnitTestMapper;
import com.github.wendao76.testing.service.UnitTestService;
import org.springframework.beans.factory.annotation.Autowired;
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
	@Autowired(required = false)
	UnitTestMapper unitTestMapper;

	@Override
	public String sayHello(String inStr) {
		if (unitTestMapper != null) {
			if ("a".equals(inStr)) {
				return "Testing->" + unitTestMapper.getLastStr(inStr);
			} else {
				return unitTestMapper.getFirstStr(inStr) + "->Testing";
			}
		}
		return inStr + "->Testing";
	}
}
