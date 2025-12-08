package cn.net.zjw.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 角色菜单关联关系实体 该项目是知识星球：java突击队 的内部项目
 * 
 * @author ZhangJw
 * @date 2025-12-08 19:18:42
 */
@ApiModel("角色菜单关联关系实体")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoleMenuEntity extends BaseEntity {
	

	/**
	 * 角色ID
	 */
	@ApiModelProperty("角色ID")
	private Long roleId;

	/**
	 * 菜单ID
	 */
	@ApiModelProperty("菜单ID")
	private Long menuId;
}
