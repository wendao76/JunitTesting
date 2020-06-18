package com.github.wendao76.springboottesting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author wendao76
 * @version 1.0
 * @description 类描述信息
 * @className IndexControllerTest
 * @date 2020-6-18 15:20
 */
public abstract class BaseMockTest {
	@Autowired
	private WebApplicationContext wc;

	protected MockMvc mockMvc;

	@Before
	public void beforeSetUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wc).build();
	}
}
