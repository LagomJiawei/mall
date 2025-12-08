package cn.net.zjw.mapper;

import cn.net.zjw.entity.RoleConditionEntity;
import cn.net.zjw.entity.RoleEntity;
import cn.net.zjw.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色 mapper
 *
 * @author ZhangJw 该项目是知识星球：java突击队 的内部项目
 * @date 2025-12-08 19:18:42
 */
public interface RoleMapper extends BaseMapper<RoleEntity, RoleConditionEntity> {
	/**
     * 查询角色信息
     *
     * @param id 角色ID
     * @return 角色信息
     */
	RoleEntity findById(Long id);

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

	/**
     * 批量查询角色信息
     *
     * @param ids ID集合
     * @return 部门信息
    */
	List<RoleEntity> findByIds(List<Long> ids);
}
