package cn.net.zjw.mapper.sys;

import cn.net.zjw.entity.sys.RoleMenuConditionEntity;
import cn.net.zjw.entity.sys.RoleMenuEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色菜单关联关系 mapper
 *
 * @author ZhangJw
 * @date 2025-12-08 19:18:42
 */
public interface RoleMenuMapper {
	/**
     * 查询角色菜单关联关系信息
     *
     * @param id 角色菜单关联关系ID
     * @return 角色菜单关联关系信息
     */
	RoleMenuEntity findById(Long id);

	/**
	 * 批量查询角色菜单关联关系信息
	 *
	 * @param ids ID集合
	 * @return 部门信息
	 */
	List<RoleMenuEntity> findByIds(List<Long> ids);

	/**
	 * 根据条件查询角色菜单关联关系信息列表
	 *
	 * @param roleMenuConditionEntity 条件
	 * @return 角色菜单关联关系信息列表
	 */
	List<RoleMenuEntity> searchByCondition(RoleMenuConditionEntity roleMenuConditionEntity);

	/**
	 * 根据条件查询角色菜单关联关系信息数量
	 *
	 * @param roleMenuConditionEntity 条件
	 * @return 角色菜单关联关系信息数量
	 */
	int searchCount(RoleMenuConditionEntity roleMenuConditionEntity);

	/**
     * 添加角色菜单关联关系
     *
     * @param roleMenuEntity 角色菜单关联关系信息
     * @return 结果
     */
	int insert(RoleMenuEntity roleMenuEntity);

	/**
     * 修改角色菜单关联关系
     *
     * @param roleMenuEntity 角色菜单关联关系信息
     * @return 结果
     */
	int update(RoleMenuEntity roleMenuEntity);

	/**
     * 批量删除角色菜单关联关系
     *
     * @param ids id集合
     * @param entity 角色菜单关联关系实体
     * @return 结果
     */
	int deleteByIds(@Param("ids") List<Long> ids, @Param("entity") RoleMenuEntity entity);
}
