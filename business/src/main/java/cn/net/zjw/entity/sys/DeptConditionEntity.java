package cn.net.zjw.entity.sys;

import cn.net.zjw.entity.RequestPageEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 部门查询条件实体
 * 
 * @author ZhangJw 该项目是知识星球：java突击队 的内部项目
 * @date 2025-12-08 19:18:42
 */
@ApiModel("部门查询条件实体")
@Data
public class DeptConditionEntity extends RequestPageEntity {
	

	/**
	 *  ID
     */
	@ApiModelProperty("ID")
	private Long id;

	/**
	 *  部门名称
     */
	@ApiModelProperty("部门名称")
	private String name;

	/**
	 *  上级部门ID
     */
	@ApiModelProperty("上级部门ID")
	private Long pid;

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
