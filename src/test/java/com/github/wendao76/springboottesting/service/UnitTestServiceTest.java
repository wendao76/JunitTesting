package com.github.wendao76.springboottesting.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 单元测试服务
 *
 * @author wendao76
 * @version 1.0
 * @description 单元测试服务
 * @className UnitTestServiceTest
 * @date 2020-6-18 15:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitTestServiceTest {
	@Autowired
	UnitTestService unitTestService;

	@Test
	public void testGetTestStr() {
		String expertStr = "abc->Testing";
		String resultStr = unitTestService.sayHello("abc");
		Assert.assertEquals(expertStr, resultStr);
	}

	@Test
	public void testMock() {

	}
}
