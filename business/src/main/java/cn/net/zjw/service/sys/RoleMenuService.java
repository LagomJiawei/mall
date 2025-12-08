package cn.net.zjw.service.sys;

import cn.net.zjw.entity.ResponsePageEntity;
import cn.net.zjw.entity.sys.RoleMenuConditionEntity;
import cn.net.zjw.entity.sys.RoleMenuEntity;
import cn.net.zjw.mapper.sys.RoleMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 角色菜单关联关系 服务层
 *
 * @author ZhangJw
 * @date 2025-12-08 19:18:42
 */
@Service
public class RoleMenuService {

	@Autowired
	private RoleMenuMapper roleMenuMapper;

	/**
     * 查询角色菜单关联关系信息
     *
     * @param id 角色菜单关联关系ID
     * @return 角色菜单关联关系信息
     */
	public RoleMenuEntity findById(Long id) {
	    return roleMenuMapper.findById(id);
	}

	/**
	 * 批量查询角色菜单关联关系信息
	 *
	 * @param ids ID集合
	 * @return 部门信息
	 */
	public List<RoleMenuEntity> findByIds(List<Long> ids) {
		return roleMenuMapper.findByIds(ids);
	}

	/**
     * 根据条件分页查询角色菜单关联关系列表
     *
     * @param roleMenuConditionEntity 角色菜单关联关系信息
     * @return 角色菜单关联关系集合
     */
	public ResponsePageEntity<RoleMenuEntity> searchByPage(RoleMenuConditionEntity roleMenuConditionEntity) {
		int count = roleMenuMapper.searchCount(roleMenuConditionEntity);
		if (count == 0) {
			return ResponsePageEntity.buildEmpty(roleMenuConditionEntity);
		}
		List<RoleMenuEntity> dataList = roleMenuMapper.searchByCondition(roleMenuConditionEntity);
		return ResponsePageEntity.build(roleMenuConditionEntity, count, dataList);
	}

    /**
     * 新增角色菜单关联关系
     *
     * @param roleMenuEntity 角色菜单关联关系信息
     * @return 结果
     */
	public int insert(RoleMenuEntity roleMenuEntity) {
	    return roleMenuMapper.insert(roleMenuEntity);
	}

	/**
     * 修改角色菜单关联关系
     *
     * @param roleMenuEntity 角色菜单关联关系信息
     * @return 结果
     */
	public int update(RoleMenuEntity roleMenuEntity) {
	    return roleMenuMapper.update(roleMenuEntity);
	}

	/**
     * 批量删除角色菜单关联关系对象
     *
     * @param ids 系统ID集合
     * @return 结果
     */
	public int deleteByIds(List<Long> ids) {
		List<RoleMenuEntity> entities = roleMenuMapper.findByIds(ids);

		RoleMenuEntity entity = new RoleMenuEntity();
		return roleMenuMapper.deleteByIds(ids, entity);
	}

}
