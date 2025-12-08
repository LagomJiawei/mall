package cn.net.zjw.mapper;

import cn.net.zjw.entity.RoleMenuConditionEntity;
import cn.net.zjw.entity.RoleMenuEntity;
import cn.net.zjw.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色菜单关联关系 mapper
 *
 * @author ZhangJw 该项目是知识星球：java突击队 的内部项目
 * @date 2025-12-08 19:18:42
 */
public interface RoleMenuMapper extends BaseMapper<RoleMenuEntity, RoleMenuConditionEntity> {
	/**
     * 查询角色菜单关联关系信息
     *
     * @param id 角色菜单关联关系ID
     * @return 角色菜单关联关系信息
     */
	RoleMenuEntity findById(Long id);

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

	/**
     * 批量查询角色菜单关联关系信息
     *
     * @param ids ID集合
     * @return 部门信息
    */
	List<RoleMenuEntity> findByIds(List<Long> ids);
}
