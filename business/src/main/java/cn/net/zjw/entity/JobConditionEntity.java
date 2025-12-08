package cn.net.zjw.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 岗位查询条件实体
 * 
 * @author ZhangJw 该项目是知识星球：java突击队 的内部项目
 * @date 2025-12-08 19:18:42
 */
@ApiModel("岗位查询条件实体")
@Data
public class JobConditionEntity extends RequestPageEntity {
	

	/**
	 *  ID
     */
	@ApiModelProperty("ID")
	private Long id;

	/**
	 *  岗位名称
     */
	@ApiModelProperty("岗位名称")
	private String name;

	/**
	 *  岗位排序
     */
	@ApiModelProperty("岗位排序")
	private Integer sort;

	/**
	 *  部门ID
     */
	@ApiModelProperty("部门ID")
	private Long deptId;

	/**
	 *  有效状态 1:有效 0:无效
     */
	@ApiModelProperty("有效状态 1:有效 0:无效")
	private Integer validStatus;

	/**
	 *  创建人ID
     */
	@ApiModelProperty("创建人ID")
	private Long createUserId;

	/**
	 *  创建人名称
     */
	@ApiModelProperty("创建人名称")
	private String createUserName;

	/**
	 *  创建时间
     */
	@ApiModelProperty("创建时间")
	private Date createTime;

	/**
	 *  修改人ID
     */
	@ApiModelProperty("修改人ID")
	private Long updateUserId;

	/**
	 *  修改人名称
     */
	@ApiModelProperty("修改人名称")
	private String updateUserName;

	/**
	 *  修改时间
     */
	@ApiModelProperty("修改时间")
	private Date updateTime;

	/**
	 *  是否删除 1:已删除 0:未删除
     */
	@ApiModelProperty("是否删除 1:已删除 0:未删除")
	private Integer isDel;
}
