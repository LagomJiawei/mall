package cn.net.zjw.mapper;

import cn.net.zjw.entity.UserConditionEntity;
import cn.net.zjw.entity.UserEntity;
import cn.net.zjw.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户 mapper
 *
 * @author ZhangJw 该项目是知识星球：java突击队 的内部项目
 * @date 2025-12-08 19:18:42
 */
public interface UserMapper extends BaseMapper<UserEntity, UserConditionEntity> {
	/**
     * 查询用户信息
     *
     * @param id 用户ID
     * @return 用户信息
     */
	UserEntity findById(Long id);

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

	/**
     * 批量查询用户信息
     *
     * @param ids ID集合
     * @return 部门信息
    */
	List<UserEntity> findByIds(List<Long> ids);
}
