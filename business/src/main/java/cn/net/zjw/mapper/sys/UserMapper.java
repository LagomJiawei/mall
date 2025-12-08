package cn.net.zjw.mapper.sys;

import cn.net.zjw.entity.sys.UserEntity;
import cn.net.zjw.entity.sys.UserConditionEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户 mapper
 *
 * @author ZhangJw
 * @date 2025-12-08 19:18:42
 */
public interface UserMapper {
	/**
     * 查询用户信息
     *
     * @param id 用户ID
     * @return 用户信息
     */
	UserEntity findById(Long id);

	/**
	 * 批量查询用户信息
	 *
	 * @param ids ID集合
	 * @return 用户信息
	 */
	List<UserEntity> findByIds(List<Long> ids);

	/**
	 * 根据条件查询用户信息列表
	 *
	 * @param userConditionEntity 条件
	 * @return 用户信息列表
	 */
	List<UserEntity> searchByCondition(UserConditionEntity userConditionEntity);

	/**
	 * 根据条件查询用户信息数量
	 *
	 * @param userConditionEntity 条件
	 * @return 用户信息数量
	 */
	int searchCount(UserConditionEntity userConditionEntity);

	/**
     * 添加用户
     *
     * @param userEntity 用户信息
     * @return 结果
     */
	int insert(UserEntity userEntity);

	/**
     * 修改用户
     *
     * @param userEntity 用户信息
     * @return 结果
     */
	int update(UserEntity userEntity);

	/**
     * 批量删除用户
     *
     * @param ids id集合
     * @param entity 用户实体
     * @return 结果
     */
	int deleteByIds(@Param("ids") List<Long> ids, @Param("entity") UserEntity entity);
}
