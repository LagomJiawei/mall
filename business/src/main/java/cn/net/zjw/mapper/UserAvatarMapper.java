package cn.net.zjw.mapper;

import cn.net.zjw.entity.UserAvatarConditionEntity;
import cn.net.zjw.entity.UserAvatarEntity;
import cn.net.zjw.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户头像 mapper
 *
 * @author ZhangJw 该项目是知识星球：java突击队 的内部项目
 * @date 2025-12-08 19:18:42
 */
public interface UserAvatarMapper extends BaseMapper<UserAvatarEntity, UserAvatarConditionEntity> {
	/**
     * 查询用户头像信息
     *
     * @param id 用户头像ID
     * @return 用户头像信息
     */
	UserAvatarEntity findById(Long id);

	/**
     * 添加用户头像
     *
     * @param userAvatarEntity 用户头像信息
     * @return 结果
     */
	int insert(UserAvatarEntity userAvatarEntity);

	/**
     * 修改用户头像
     *
     * @param userAvatarEntity 用户头像信息
     * @return 结果
     */
	int update(UserAvatarEntity userAvatarEntity);

	/**
     * 批量删除用户头像
     *
     * @param ids id集合
     * @param entity 用户头像实体
     * @return 结果
     */
	int deleteByIds(@Param("ids") List<Long> ids, @Param("entity") UserAvatarEntity entity);

	/**
     * 批量查询用户头像信息
     *
     * @param ids ID集合
     * @return 部门信息
    */
	List<UserAvatarEntity> findByIds(List<Long> ids);
}
