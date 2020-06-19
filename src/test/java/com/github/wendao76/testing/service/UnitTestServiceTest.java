package com.github.wendao76.testing.service;

import com.github.houbb.junitperf.core.annotation.JunitPerfConfig;
import com.github.houbb.junitperf.core.report.impl.ConsoleReporter;
import com.github.houbb.junitperf.core.report.impl.HtmlReporter;
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

	@JunitPerfConfig(duration = 10000, threads = 50, reporter = {HtmlReporter.class, ConsoleReporter.class})
	@Test
	public void testGetTestStr() throws InterruptedException {
		String expertStr = "abc->Testing";
		String resultStr = unitTestService.sayHello("abc");
		Assert.assertEquals(expertStr, resultStr);
	}
}
