package com.github.wendao76.testing;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
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
