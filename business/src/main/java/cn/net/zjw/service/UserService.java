package cn.net.zjw.service;

import cn.net.zjw.entity.ResponsePageEntity;
import cn.net.zjw.entity.UserConditionEntity;
import cn.net.zjw.entity.UserEntity;
import cn.net.zjw.mapper.BaseMapper;
import cn.net.zjw.mapper.UserMapper;
import cn.net.zjw.util.AssertUtil;
import cn.net.zjw.util.FillUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 用户 服务层
 *
 * @author ZhangJw 该项目是知识星球：java突击队 的内部项目
 * @date 2025-12-08 19:18:42
 */
@Service
public class UserService extends BaseService< UserEntity,  UserConditionEntity> {

	@Autowired
	private UserMapper userMapper;

	/**
     * 查询用户信息
     *
     * @param id 用户ID
     * @return 用户信息
     */
	public UserEntity findById(Long id) {
	    return userMapper.findById(id);
	}

	/**
     * 根据条件分页查询用户列表
     *
     * @param userConditionEntity 用户信息
     * @return 用户集合
     */
	public ResponsePageEntity<UserEntity> searchByPage(UserConditionEntity userConditionEntity) {
		int count = userMapper.searchCount(userConditionEntity);
		if (count == 0) {
			return ResponsePageEntity.buildEmpty(userConditionEntity);
		}
		List<UserEntity> dataList = userMapper.searchByCondition(userConditionEntity);
		return ResponsePageEntity.build(userConditionEntity, count, dataList);
	}

    /**
     * 新增用户
     *
     * @param userEntity 用户信息
     * @return 结果
     */
	public int insert(UserEntity userEntity) {
	    return userMapper.insert(userEntity);
	}

	/**
     * 修改用户
     *
     * @param userEntity 用户信息
     * @return 结果
     */
	public int update(UserEntity userEntity) {
	    return userMapper.update(userEntity);
	}

	/**
     * 批量删除用户对象
     *
     * @param ids 系统ID集合
     * @return 结果
     */
	public int deleteByIds(List<Long> ids) {
		List<UserEntity> entities = userMapper.findByIds(ids);
		AssertUtil.notEmpty(entities, "用户已被删除");

		UserEntity entity = new UserEntity();
		FillUserUtil.fillUpdateUserInfo(entity);
		return userMapper.deleteByIds(ids, entity);
	}

	@Override
	protected BaseMapper getBaseMapper() {
		return userMapper;
	}

}
