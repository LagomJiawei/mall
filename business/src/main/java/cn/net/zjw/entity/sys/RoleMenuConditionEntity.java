package cn.net.zjw.entity.sys;

import cn.net.zjw.entity.RequestPageEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 角色菜单关联关系查询条件实体
 * 
 * @author ZhangJw 该项目是知识星球：java突击队 的内部项目
 * @date 2025-12-08 19:18:42
 */
@ApiModel("角色菜单关联关系查询条件实体")
@Data
public class RoleMenuConditionEntity extends RequestPageEntity {
	

	/**
	 *  ID
     */
	@ApiModelProperty("ID")
	private Long id;

	/**
	 *  角色ID
     */
	@ApiModelProperty("角色ID")
	private Long roleId;

	/**
	 *  菜单ID
     */
	@ApiModelProperty("菜单ID")
	private Long menuId;
}
