package cn.net.zjw.mapper.sys;

import cn.net.zjw.entity.sys.RoleDeptConditionEntity;
import cn.net.zjw.entity.sys.RoleDeptEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色部门关联关系 mapper
 *
 * @author ZhangJw 该项目是知识星球：java突击队 的内部项目
 * @date 2025-12-08 19:18:42
 */
public interface RoleDeptMapper {
	/**
     * 查询角色部门关联关系信息
     *
     * @param id 角色部门关联关系ID
     * @return 角色部门关联关系信息
     */
	RoleDeptEntity findById(Long id);

	/**
	 * 批量查询角色部门关联关系信息
	 *
	 * @param ids ID集合
	 * @return 角色部门关联关系信息
	 */
	List<RoleDeptEntity> findByIds(List<Long> ids);

	/**
	 * 根据条件查询角色部门关联关系信息列表
	 *
	 * @param roleDeptConditionEntity 条件
	 * @return 角色部门关联关系信息列表
	 */
	List<RoleDeptEntity> searchByCondition(RoleDeptConditionEntity roleDeptConditionEntity);

	/**
	 * 根据条件查询角色部门关联关系信息数量
	 *
	 * @param roleDeptConditionEntity 条件
	 * @return 角色部门关联关系信息数量
	 */
	int searchCount(RoleDeptConditionEntity roleDeptConditionEntity);

	/**
     * 添加角色部门关联关系
     *
     * @param roleDeptEntity 角色部门关联关系信息
     * @return 结果
     */
	int insert(RoleDeptEntity roleDeptEntity);

	/**
     * 修改角色部门关联关系
     *
     * @param roleDeptEntity 角色部门关联关系信息
     * @return 结果
     */
	int update(RoleDeptEntity roleDeptEntity);

	/**
     * 批量删除角色部门关联关系
     *
     * @param ids id集合
     * @param entity 角色部门关联关系实体
     * @return 结果
     */
	int deleteByIds(@Param("ids") List<Long> ids, @Param("entity") RoleDeptEntity entity);
}
