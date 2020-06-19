package com.github.wendao76.testing.controller;


import com.github.wendao76.testing.entity.common.Result;
import com.github.wendao76.testing.entity.po.Department;
import com.github.wendao76.testing.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author wendao76
 * @since 2020-06-19
 */
@Api(value = "部门相关操作", tags = "部门相关操作")
@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
	@Autowired
	DepartmentService departmentService;

	@ApiOperation("新增部门")
	@PostMapping("/")
	public Result<String> create(@ApiParam("部门对象") @RequestBody Department department) {
		departmentService.save(department);
		return Result.of("ok");
	}

	@ApiOperation("更新部门")
	@PutMapping("/")
	public Result<String> modify(@ApiParam("部门对象") @RequestBody Department department) {
		departmentService.updateById(department);
		return Result.of("ok");
	}

	@ApiOperation("删除部门")
	@DeleteMapping("/{departmentId}")
	public Result<String> delete(@ApiParam("部门ID") @PathVariable String departmentId) {
		departmentService.removeById(departmentId);
		return Result.of("ok");
	}
}

