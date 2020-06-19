package com.github.wendao76.testing.service;

import com.github.wendao76.testing.mapper.UnitTestMapper;
import com.github.wendao76.testing.service.impl.UnitTestServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

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
public class UnitTestServiceMockTest {
	@InjectMocks
	UnitTestService unitTestService = new UnitTestServiceImpl();

	@Mock
	UnitTestMapper unitTestMapper;

	@Before
	public void beforeEvery() {
		when(unitTestMapper.getLastStr("a")).thenReturn("first");
		when(unitTestMapper.getFirstStr("b")).thenReturn("last");
	}

	@Test
	public void testGetTestStr() {
		String expertStrA = "Testing->first";
		String expertStrB = "last->Testing";
		String resultA = unitTestService.sayHello("a");
		String resultB = unitTestService.sayHello("b");
		System.out.println(resultA);
		System.out.println(resultB);
		Assert.assertEquals(expertStrA, resultA);
		Assert.assertEquals(expertStrB, resultB);
	}

	@Test
	public void testMock() {

	}
}
