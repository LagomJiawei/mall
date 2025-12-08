package cn.net.zjw.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 部门实体 该项目是知识星球：java突击队 的内部项目
 * 
 * @author ZhangJw
 * @date 2025-12-08 19:18:42
 */
@ApiModel("部门实体")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeptEntity extends BaseEntity {
	

	/**
	 * 部门名称
	 */
	@ApiModelProperty("部门名称")
	private String name;

	/**
	 * 上级部门ID
	 */
	@ApiModelProperty("上级部门ID")
	private Long pid;

	/**
	 * 有效状态 1:有效 0:无效
	 */
	@ApiModelProperty("有效状态 1:有效 0:无效")
	private Integer validStatus;
}
