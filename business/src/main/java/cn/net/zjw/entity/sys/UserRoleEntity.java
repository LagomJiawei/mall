package cn.net.zjw.entity.sys;

import cn.net.zjw.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户角色关联关系实体 该项目是知识星球：java突击队 的内部项目
 * 
 * @author ZhangJw
 * @date 2025-12-08 19:18:42
 */
@ApiModel("用户角色关联关系实体")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRoleEntity extends BaseEntity {
	

	/**
	 * 用户ID
	 */
	@ApiModelProperty("用户ID")
	private Long userId;

	/**
	 * 角色ID
	 */
	@ApiModelProperty("角色ID")
	private Long roleId;
}
