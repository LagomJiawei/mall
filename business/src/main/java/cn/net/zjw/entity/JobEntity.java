package cn.net.zjw.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 岗位实体 该项目是知识星球：java突击队 的内部项目
 * 
 * @author ZhangJw
 * @date 2025-12-08 19:18:42
 */
@ApiModel("岗位实体")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobEntity extends BaseEntity {
	

	/**
	 * 岗位名称
	 */
	@ApiModelProperty("岗位名称")
	private String name;

	/**
	 * 岗位排序
	 */
	@ApiModelProperty("岗位排序")
	private Integer sort;

	/**
	 * 部门ID
	 */
	@ApiModelProperty("部门ID")
	private Long deptId;

	/**
	 * 有效状态 1:有效 0:无效
	 */
	@ApiModelProperty("有效状态 1:有效 0:无效")
	private Integer validStatus;
}
