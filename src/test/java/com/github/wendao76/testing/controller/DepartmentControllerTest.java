package com.github.wendao76.testing.controller;

import com.alibaba.fastjson.JSON;
import com.github.wendao76.testing.BaseMockTest;
import com.github.wendao76.testing.entity.common.Result;
import com.github.wendao76.testing.entity.po.Department;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 接口测试用例
 *
 * @author wendao76
 * @version 1.0
 * @description 接口测试用例
 * @className DepartmentControllerTest
 * @date 2020-6-18 15:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional//支持事务
@Rollback//自动回滚
public class DepartmentControllerTest extends BaseMockTest {
	private String url = "/api/v1/departments/";

	@Test
	public void testCreate() throws Exception {
		Department department = null;
		department = new Department();
		department.setName("部门-" + UUID.randomUUID());
		department.setNo("编号-" + UUID.randomUUID());
		String msg = "ok";
		MvcResult mvcResult =
				mockMvc
						.perform(post(url)
								.contentType(MediaType.APPLICATION_JSON)
								.content(JSON.toJSONString(department)))
						.andDo(print())
						.andExpect(status().isOk())
						.andReturn();

		Result result = JSON.parseObject(mvcResult.getResponse().getContentAsString(), Result.class);
		//断言 是否和预期相等
		Assert.assertTrue(result.isSuccess());
	}
}
