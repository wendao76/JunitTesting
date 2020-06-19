package com.github.wendao76.testing.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.wendao76.testing.dao.DepartmentMapper;
import com.github.wendao76.testing.entity.po.Department;
import com.github.wendao76.testing.service.DepartmentService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author wendao76
 * @since 2020-06-19
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

}
