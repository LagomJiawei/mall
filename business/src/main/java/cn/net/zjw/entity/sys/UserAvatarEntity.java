package cn.net.zjw.entity.sys;

import cn.net.zjw.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户头像实体 该项目是知识星球：java突击队 的内部项目
 * 
 * @author ZhangJw
 * @date 2025-12-08 19:18:42
 */
@ApiModel("用户头像实体")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserAvatarEntity extends BaseEntity {
	

	/**
	 * 文件名
	 */
	@ApiModelProperty("文件名")
	private String fileName;

	/**
	 * 文件路径
	 */
	@ApiModelProperty("文件路径")
	private String path;

	/**
	 * 文件大小
	 */
	@ApiModelProperty("文件大小")
	private String fileSize;
}
