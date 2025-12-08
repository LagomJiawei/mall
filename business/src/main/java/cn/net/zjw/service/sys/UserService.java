package cn.net.zjw.service.sys;

import cn.net.zjw.entity.ResponsePageEntity;
import cn.net.zjw.entity.sys.UserConditionEntity;
import cn.net.zjw.entity.sys.UserEntity;
import cn.net.zjw.mapper.sys.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 用户 服务层
 *
 * @author ZhangJw
 * @date 2025-12-08 19:18:42
 */
@Service
public class UserService {

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
	 * 批量查询用户信息
	 *
	 * @param ids ID集合
	 * @return 用户信息
	 */
	public List<UserEntity> findByIds(List<Long> ids) {
		return userMapper.findByIds(ids);
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

		UserEntity entity = new UserEntity();
		return userMapper.deleteByIds(ids, entity);
	}

}
