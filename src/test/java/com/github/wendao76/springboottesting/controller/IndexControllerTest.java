package com.github.wendao76.springboottesting.controller;

import com.github.wendao76.springboottesting.BaseMockTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 接口测试用例
 *
 * @author wendao76
 * @version 1.0
 * @description 接口测试用例
 * @className IndexControllerTest
 * @date 2020-6-18 15:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IndexControllerTest extends BaseMockTest {
	@Test
	public void testHome() throws Exception {
		String msg = "Hello World!";
		MvcResult result = mockMvc.perform(get("/index"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo(msg))).andReturn();
		//断言 是否和预期相等
		Assert.assertEquals(msg, result.getResponse().getContentAsString());
	}
}
