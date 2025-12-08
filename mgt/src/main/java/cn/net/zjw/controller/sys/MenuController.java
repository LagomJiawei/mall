package cn.net.zjw.controller.sys;

import cn.net.zjw.entity.sys.MenuConditionEntity;
import cn.net.zjw.entity.sys.MenuEntity;
import cn.net.zjw.entity.ResponsePageEntity;
import cn.net.zjw.service.sys.MenuService;
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
 * 菜单 接口层
 *
 * @author ZhangJw
 * @date 2025-12-08 19:18:42
 */
@Api(tags = "菜单操作", description = "菜单接口")
@RestController
@RequestMapping("/v1/menu")
public class MenuController {

	@Autowired
	private MenuService menuService;

	/**
	 * 通过id查询菜单信息
	 *
	 * @param id 系统ID
	 * @return 菜单信息
	 */
	@ApiOperation(notes = "通过id查询菜单信息", value = "通过id查询菜单信息")
	@GetMapping("/findById")
	public MenuEntity findById(Long id) {
		return menuService.findById(id);
	}

	/**
	 * 批量查询菜单信息
	 *
	 * @param ids ID集合
	 * @return 菜单信息
	 */
	@ApiOperation(notes = "通过id集合批量查询菜单信息", value = "通过id集合批量查询菜单信息")
	@GetMapping("/findByIds")
	public List<MenuEntity> findByIds(List<Long> ids) {
		return menuService.findByIds(ids);
	}

	/**
    * 根据条件查询菜单列表
    *
    * @param menuConditionEntity 条件
    * @return 菜单列表
    */
	@ApiOperation(notes = "根据条件查询菜单列表", value = "根据条件查询菜单列表")
	@PostMapping("/searchByPage")
	public ResponsePageEntity<MenuEntity> searchByPage(@RequestBody MenuConditionEntity menuConditionEntity) {
		return menuService.searchByPage(menuConditionEntity);
	}


	/**
     * 添加菜单
     *
     * @param menuEntity 菜单实体
     * @return 影响行数
     */
	@ApiOperation(notes = "添加菜单", value = "添加菜单")
	@PostMapping("/insert")
	public int insert(@RequestBody MenuEntity menuEntity) {
		return menuService.insert(menuEntity);
	}

	/**
     * 修改菜单
     *
     * @param menuEntity 菜单实体
     * @return 影响行数
     */
	@ApiOperation(notes = "修改菜单", value = "修改菜单")
	@PostMapping("/update")
	public int update(@RequestBody MenuEntity menuEntity) {
		return menuService.update(menuEntity);
	}

	/**
     * 批量删除菜单
     *
     * @param ids 菜单ID集合
     * @return 影响行数
     */
	@ApiOperation(notes = "批量删除菜单", value = "批量删除菜单")
	@PostMapping("/deleteByIds")
	public int deleteByIds(@RequestBody @NotNull List<Long> ids) {
		return menuService.deleteByIds(ids);
	}
}
