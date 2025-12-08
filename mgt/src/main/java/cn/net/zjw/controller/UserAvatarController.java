package cn.net.zjw.controller;

import cn.net.zjw.entity.ResponsePageEntity;
import cn.net.zjw.entity.UserAvatarConditionEntity;
import cn.net.zjw.entity.UserAvatarEntity;
import cn.net.zjw.service.UserAvatarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 用户头像 接口层
 *
 * @author ZhangJw 该项目是知识星球：java突击队 的内部项目
 * @date 2025-12-08 19:18:42
 */
@Api(tags = "用户头像操作", description = "用户头像接口")
@RestController
@RequestMapping("/v1/userAvatar")
public class UserAvatarController {

	@Autowired
	private UserAvatarService userAvatarService;

	/**
	 * 通过id查询用户头像信息
	 *
	 * @param id 系统ID
	 * @return 用户头像信息
	 */
	@ApiOperation(notes = "通过id查询用户头像信息", value = "通过id查询用户头像信息")
	@GetMapping("/findById")
	public UserAvatarEntity findById(Long id) {
		return userAvatarService.findById(id);
	}

	/**
    * 根据条件查询用户头像列表
    *
    * @param userAvatarConditionEntity 条件
    * @return 用户头像列表
    */
	@ApiOperation(notes = "根据条件查询用户头像列表", value = "根据条件查询用户头像列表")
	@PostMapping("/searchByPage")
	public ResponsePageEntity<UserAvatarEntity> searchByPage(@RequestBody UserAvatarConditionEntity userAvatarConditionEntity) {
		return userAvatarService.searchByPage(userAvatarConditionEntity);
	}


	/**
     * 添加用户头像
     *
     * @param userAvatarEntity 用户头像实体
     * @return 影响行数
     */
	@ApiOperation(notes = "添加用户头像", value = "添加用户头像")
	@PostMapping("/insert")
	public int insert(@RequestBody UserAvatarEntity userAvatarEntity) {
		return userAvatarService.insert(userAvatarEntity);
	}

	/**
     * 修改用户头像
     *
     * @param userAvatarEntity 用户头像实体
     * @return 影响行数
     */
	@ApiOperation(notes = "修改用户头像", value = "修改用户头像")
	@PostMapping("/update")
	public int update(@RequestBody UserAvatarEntity userAvatarEntity) {
		return userAvatarService.update(userAvatarEntity);
	}

	/**
     * 批量删除用户头像
     *
     * @param ids 用户头像ID集合
     * @return 影响行数
     */
	@ApiOperation(notes = "批量删除用户头像", value = "批量删除用户头像")
	@PostMapping("/deleteByIds")
	public int deleteByIds(@RequestBody @NotNull List<Long> ids) {
		return userAvatarService.deleteByIds(ids);
	}
}
