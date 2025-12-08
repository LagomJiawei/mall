package cn.net.zjw.entity.sys;

import cn.net.zjw.entity.RequestPageEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 用户查询条件实体
 * 
 * @author ZhangJw 该项目是知识星球：java突击队 的内部项目
 * @date 2025-12-08 19:18:42
 */
@ApiModel("用户查询条件实体")
@Data
public class UserConditionEntity extends RequestPageEntity {
	

	/**
	 *  ID
     */
	@ApiModelProperty("ID")
	private Long id;

	/**
	 *  用户头像ID
     */
	@ApiModelProperty("用户头像ID")
	private Long avatarId;

	/**
	 *  用户名
     */
	@ApiModelProperty("用户名")
	private String userName;

	/**
	 *  密码
     */
	@ApiModelProperty("密码")
	private String password;

	/**
	 *  手机号
     */
	@ApiModelProperty("手机号")
	private String phone;

	/**
	 *  邮箱
     */
	@ApiModelProperty("邮箱")
	private String email;

	/**
	 *  部门ID
     */
	@ApiModelProperty("部门ID")
	private Long deptId;

	/**
	 *  岗位ID
     */
	@ApiModelProperty("岗位ID")
	private Long jobId;

	/**
	 *  最后修改密码的时间
     */
	@ApiModelProperty("最后修改密码的时间")
	private Date lastChangePasswordTime;

	/**
	 *  别名
     */
	@ApiModelProperty("别名")
	private String nickName;

	/**
	 *  性别 1:男 2:女
     */
	@ApiModelProperty("性别 1:男 2:女")
	private Integer sex;

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
