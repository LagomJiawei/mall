package cn.net.zjw.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户实体 该项目是知识星球：java突击队 的内部项目
 * 
 * @author ZhangJw
 * @date 2025-12-08 19:18:42
 */
@ApiModel("用户实体")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEntity extends BaseEntity {
	

	/**
	 * 用户头像ID
	 */
	@ApiModelProperty("用户头像ID")
	private Long avatarId;

	/**
	 * 用户名
	 */
	@ApiModelProperty("用户名")
	private String userName;

	/**
	 * 密码
	 */
	@ApiModelProperty("密码")
	private String password;

	/**
	 * 手机号
	 */
	@ApiModelProperty("手机号")
	private String phone;

	/**
	 * 邮箱
	 */
	@ApiModelProperty("邮箱")
	private String email;

	/**
	 * 部门ID
	 */
	@ApiModelProperty("部门ID")
	private Long deptId;

	/**
	 * 岗位ID
	 */
	@ApiModelProperty("岗位ID")
	private Long jobId;

	/**
	 * 最后修改密码的时间
	 */
	@ApiModelProperty("最后修改密码的时间")
	private Date lastChangePasswordTime;

	/**
	 * 别名
	 */
	@ApiModelProperty("别名")
	private String nickName;

	/**
	 * 性别 1:男 2:女
	 */
	@ApiModelProperty("性别 1:男 2:女")
	private Integer sex;

	/**
	 * 有效状态 1:有效 0:无效
	 */
	@ApiModelProperty("有效状态 1:有效 0:无效")
	private Integer validStatus;
}
