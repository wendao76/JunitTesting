package com.github.wendao76.testing.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.github.wendao76.testing.entity.mybatis.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author wendao76
 * @since 2020-06-19
 */
@ApiModel("部门对象")
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Department extends BaseModel<Department> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "ID", type = IdType.AUTO)
    @ApiModelProperty("ID")
    private Integer id;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("编码")
    private String no;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
