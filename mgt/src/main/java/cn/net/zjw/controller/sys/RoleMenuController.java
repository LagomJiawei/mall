package cn.net.zjw.controller.sys;

import cn.net.zjw.entity.ResponsePageEntity;
import cn.net.zjw.entity.sys.RoleMenuConditionEntity;
import cn.net.zjw.entity.sys.RoleMenuEntity;
import cn.net.zjw.service.sys.RoleMenuService;
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
 * 角色菜单关联关系 接口层
 *
 * @author ZhangJw
 * @date 2025-12-08 19:18:42
 */
@Api(tags = "角色菜单关联关系操作", description = "角色菜单关联关系接口")
@RestController
@RequestMapping("/v1/roleMenu")
public class RoleMenuController {

	@Autowired
	private RoleMenuService roleMenuService;

	/**
	 * 通过id查询角色菜单关联关系信息
	 *
	 * @param id 系统ID
	 * @return 角色菜单关联关系信息
	 */
	@ApiOperation(notes = "通过id查询角色菜单关联关系信息", value = "通过id查询角色菜单关联关系信息")
	@GetMapping("/findById")
	public RoleMenuEntity findById(Long id) {
		return roleMenuService.findById(id);
	}

	/**
	 * 批量查询角色菜单关联关系信息
	 *
	 * @param ids ID集合
	 * @return 角色菜单关联关系信息
	 */
	@ApiOperation(notes = "通过id集合批量查询角色菜单关联关系信息", value = "通过id集合批量查询角色菜单关联关系信息")
	@GetMapping("/findByIds")
	public List<RoleMenuEntity> findByIds(List<Long> ids) {
		return roleMenuService.findByIds(ids);
	}

	/**
    * 根据条件查询角色菜单关联关系列表
    *
    * @param roleMenuConditionEntity 条件
    * @return 角色菜单关联关系列表
    */
	@ApiOperation(notes = "根据条件查询角色菜单关联关系列表", value = "根据条件查询角色菜单关联关系列表")
	@PostMapping("/searchByPage")
	public ResponsePageEntity<RoleMenuEntity> searchByPage(@RequestBody RoleMenuConditionEntity roleMenuConditionEntity) {
		return roleMenuService.searchByPage(roleMenuConditionEntity);
	}


	/**
     * 添加角色菜单关联关系
     *
     * @param roleMenuEntity 角色菜单关联关系实体
     * @return 影响行数
     */
	@ApiOperation(notes = "添加角色菜单关联关系", value = "添加角色菜单关联关系")
	@PostMapping("/insert")
	public int insert(@RequestBody RoleMenuEntity roleMenuEntity) {
		return roleMenuService.insert(roleMenuEntity);
	}

	/**
     * 修改角色菜单关联关系
     *
     * @param roleMenuEntity 角色菜单关联关系实体
     * @return 影响行数
     */
	@ApiOperation(notes = "修改角色菜单关联关系", value = "修改角色菜单关联关系")
	@PostMapping("/update")
	public int update(@RequestBody RoleMenuEntity roleMenuEntity) {
		return roleMenuService.update(roleMenuEntity);
	}

	/**
     * 批量删除角色菜单关联关系
     *
     * @param ids 角色菜单关联关系ID集合
     * @return 影响行数
     */
	@ApiOperation(notes = "批量删除角色菜单关联关系", value = "批量删除角色菜单关联关系")
	@PostMapping("/deleteByIds")
	public int deleteByIds(@RequestBody @NotNull List<Long> ids) {
		return roleMenuService.deleteByIds(ids);
	}
}
