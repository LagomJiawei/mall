package cn.net.zjw.controller.sys;

import cn.net.zjw.entity.ResponsePageEntity;
import cn.net.zjw.entity.sys.UserRoleConditionEntity;
import cn.net.zjw.entity.sys.UserRoleEntity;
import cn.net.zjw.service.sys.UserRoleService;
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
 * 用户角色关联关系 接口层
 *
 * @author ZhangJw
 * @date 2025-12-08 19:18:42
 */
@Api(tags = "用户角色关联关系操作", description = "用户角色关联关系接口")
@RestController
@RequestMapping("/v1/userRole")
public class UserRoleController {

	@Autowired
	private UserRoleService userRoleService;

	/**
	 * 通过id查询用户角色关联关系信息
	 *
	 * @param id 系统ID
	 * @return 用户角色关联关系信息
	 */
	@ApiOperation(notes = "通过id查询用户角色关联关系信息", value = "通过id查询用户角色关联关系信息")
	@GetMapping("/findById")
	public UserRoleEntity findById(Long id) {
		return userRoleService.findById(id);
	}

	/**
	 * 批量查询用户角色关联关系信息
	 *
	 * @param ids ID集合
	 * @return 用户角色关联关系信息
	 */
	@ApiOperation(notes = "通过id集合批量查询用户角色关联关系信息", value = "通过id集合批量查询用户角色关联关系信息")
	@GetMapping("/findByIds")
	public List<UserRoleEntity> findByIds(List<Long> ids) {
		return userRoleService.findByIds(ids);
	}

	/**
    * 根据条件查询用户角色关联关系列表
    *
    * @param userRoleConditionEntity 条件
    * @return 用户角色关联关系列表
    */
	@ApiOperation(notes = "根据条件查询用户角色关联关系列表", value = "根据条件查询用户角色关联关系列表")
	@PostMapping("/searchByPage")
	public ResponsePageEntity<UserRoleEntity> searchByPage(@RequestBody UserRoleConditionEntity userRoleConditionEntity) {
		return userRoleService.searchByPage(userRoleConditionEntity);
	}


	/**
     * 添加用户角色关联关系
     *
     * @param userRoleEntity 用户角色关联关系实体
     * @return 影响行数
     */
	@ApiOperation(notes = "添加用户角色关联关系", value = "添加用户角色关联关系")
	@PostMapping("/insert")
	public int insert(@RequestBody UserRoleEntity userRoleEntity) {
		return userRoleService.insert(userRoleEntity);
	}

	/**
     * 修改用户角色关联关系
     *
     * @param userRoleEntity 用户角色关联关系实体
     * @return 影响行数
     */
	@ApiOperation(notes = "修改用户角色关联关系", value = "修改用户角色关联关系")
	@PostMapping("/update")
	public int update(@RequestBody UserRoleEntity userRoleEntity) {
		return userRoleService.update(userRoleEntity);
	}

	/**
     * 批量删除用户角色关联关系
     *
     * @param ids 用户角色关联关系ID集合
     * @return 影响行数
     */
	@ApiOperation(notes = "批量删除用户角色关联关系", value = "批量删除用户角色关联关系")
	@PostMapping("/deleteByIds")
	public int deleteByIds(@RequestBody @NotNull List<Long> ids) {
		return userRoleService.deleteByIds(ids);
	}
}
