package cn.net.zjw.controller;

import cn.net.zjw.entity.ResponsePageEntity;
import cn.net.zjw.entity.RoleDeptConditionEntity;
import cn.net.zjw.entity.RoleDeptEntity;
import cn.net.zjw.service.RoleDeptService;
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
 * 角色部门关联关系 接口层
 *
 * @author ZhangJw 该项目是知识星球：java突击队 的内部项目
 * @date 2025-12-08 19:18:42
 */
@Api(tags = "角色部门关联关系操作", description = "角色部门关联关系接口")
@RestController
@RequestMapping("/v1/roleDept")
public class RoleDeptController {

	@Autowired
	private RoleDeptService roleDeptService;

	/**
	 * 通过id查询角色部门关联关系信息
	 *
	 * @param id 系统ID
	 * @return 角色部门关联关系信息
	 */
	@ApiOperation(notes = "通过id查询角色部门关联关系信息", value = "通过id查询角色部门关联关系信息")
	@GetMapping("/findById")
	public RoleDeptEntity findById(Long id) {
		return roleDeptService.findById(id);
	}

	/**
    * 根据条件查询角色部门关联关系列表
    *
    * @param roleDeptConditionEntity 条件
    * @return 角色部门关联关系列表
    */
	@ApiOperation(notes = "根据条件查询角色部门关联关系列表", value = "根据条件查询角色部门关联关系列表")
	@PostMapping("/searchByPage")
	public ResponsePageEntity<RoleDeptEntity> searchByPage(@RequestBody RoleDeptConditionEntity roleDeptConditionEntity) {
		return roleDeptService.searchByPage(roleDeptConditionEntity);
	}


	/**
     * 添加角色部门关联关系
     *
     * @param roleDeptEntity 角色部门关联关系实体
     * @return 影响行数
     */
	@ApiOperation(notes = "添加角色部门关联关系", value = "添加角色部门关联关系")
	@PostMapping("/insert")
	public int insert(@RequestBody RoleDeptEntity roleDeptEntity) {
		return roleDeptService.insert(roleDeptEntity);
	}

	/**
     * 修改角色部门关联关系
     *
     * @param roleDeptEntity 角色部门关联关系实体
     * @return 影响行数
     */
	@ApiOperation(notes = "修改角色部门关联关系", value = "修改角色部门关联关系")
	@PostMapping("/update")
	public int update(@RequestBody RoleDeptEntity roleDeptEntity) {
		return roleDeptService.update(roleDeptEntity);
	}

	/**
     * 批量删除角色部门关联关系
     *
     * @param ids 角色部门关联关系ID集合
     * @return 影响行数
     */
	@ApiOperation(notes = "批量删除角色部门关联关系", value = "批量删除角色部门关联关系")
	@PostMapping("/deleteByIds")
	public int deleteByIds(@RequestBody @NotNull List<Long> ids) {
		return roleDeptService.deleteByIds(ids);
	}
}
