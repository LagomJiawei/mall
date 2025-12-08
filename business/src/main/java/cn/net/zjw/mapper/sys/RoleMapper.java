package cn.net.zjw.mapper.sys;

import cn.net.zjw.entity.sys.RoleConditionEntity;
import cn.net.zjw.entity.sys.RoleEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色 mapper
 *
 * @author ZhangJw 该项目是知识星球：java突击队 的内部项目
 * @date 2025-12-08 19:18:42
 */
public interface RoleMapper {
	/**
     * 查询角色信息
     *
     * @param id 角色ID
     * @return 角色信息
     */
	RoleEntity findById(Long id);

	/**
	 * 批量查询角色信息
	 *
	 * @param ids ID集合
	 * @return 部门信息
	 */
	List<RoleEntity> findByIds(List<Long> ids);

	/**
	 * 根据条件查询角色列表
	 *
	 * @param roleConditionEntity 条件
	 * @return 角色列表
	 */
	List<RoleEntity> searchByCondition(RoleConditionEntity roleConditionEntity);

	/**
	 * 根据条件查询角色数量
	 *
	 * @param roleConditionEntity 条件
	 * @return 角色数量
	 */
	int searchCount(RoleConditionEntity roleConditionEntity);

	/**
     * 添加角色
     *
     * @param roleEntity 角色信息
     * @return 结果
     */
	int insert(RoleEntity roleEntity);

	/**
     * 修改角色
     *
     * @param roleEntity 角色信息
     * @return 结果
     */
	int update(RoleEntity roleEntity);

	/**
     * 批量删除角色
     *
     * @param ids id集合
     * @param entity 角色实体
     * @return 结果
     */
	int deleteByIds(@Param("ids") List<Long> ids, @Param("entity") RoleEntity entity);
}
