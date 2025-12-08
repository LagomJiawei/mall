package cn.net.zjw.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 角色实体 该项目是知识星球：java突击队 的内部项目
 * 
 * @author ZhangJw
 * @date 2025-12-08 19:18:42
 */
@ApiModel("角色实体")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoleEntity extends BaseEntity {
	

	/**
	 * 角色名称
	 */
	@ApiModelProperty("角色名称")
	private String name;

	/**
	 * 备注
	 */
	@ApiModelProperty("备注")
	private String remark;

	/**
	 * 数据权限
	 */
	@ApiModelProperty("数据权限")
	private String dataScope;

	/**
	 * 角色级别
	 */
	@ApiModelProperty("角色级别")
	private Integer level;

	/**
	 * 功能权限
	 */
	@ApiModelProperty("功能权限")
	private String permission;
}
