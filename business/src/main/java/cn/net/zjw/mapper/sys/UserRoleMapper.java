package cn.net.zjw.mapper.sys;

import cn.net.zjw.entity.sys.UserRoleConditionEntity;
import cn.net.zjw.entity.sys.UserRoleEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户角色关联关系 mapper
 *
 * @author ZhangJw
 * @date 2025-12-08 19:18:42
 */
public interface UserRoleMapper {
	/**
     * 查询用户角色关联关系信息
     *
     * @param id 用户角色关联关系ID
     * @return 用户角色关联关系信息
     */
	UserRoleEntity findById(Long id);

	/**
	 * 批量查询用户角色关联关系信息
	 *
	 * @param ids ID集合
	 * @return 用户角色关联关系信息
	 */
	List<UserRoleEntity> findByIds(List<Long> ids);

	/**
	 * 根据条件查询用户角色关联关系信息
	 *
	 * @param userRoleConditionEntity 条件
	 * @return 用户角色关联关系信息列表
	 */
	List<UserRoleEntity> searchByCondition(UserRoleConditionEntity userRoleConditionEntity);

	/**
	 * 根据条件查询用户角色关联关系信息
	 *
	 * @param userRoleConditionEntity 条件
	 * @return 用户角色关联关系信息数量
	 */
	int searchCount(UserRoleConditionEntity userRoleConditionEntity);

	/**
     * 添加用户角色关联关系
     *
     * @param userRoleEntity 用户角色关联关系信息
     * @return 结果
     */
	int insert(UserRoleEntity userRoleEntity);

	/**
     * 修改用户角色关联关系
     *
     * @param userRoleEntity 用户角色关联关系信息
     * @return 结果
     */
	int update(UserRoleEntity userRoleEntity);

	/**
     * 批量删除用户角色关联关系
     *
     * @param ids id集合
     * @param entity 用户角色关联关系实体
     * @return 结果
     */
	int deleteByIds(@Param("ids") List<Long> ids, @Param("entity") UserRoleEntity entity);
}
