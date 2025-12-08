package cn.net.zjw.service.sys;

import cn.net.zjw.entity.ResponsePageEntity;
import cn.net.zjw.entity.sys.UserRoleConditionEntity;
import cn.net.zjw.entity.sys.UserRoleEntity;
import cn.net.zjw.mapper.sys.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 用户角色关联关系 服务层
 *
 * @author ZhangJw
 * @date 2025-12-08 19:18:42
 */
@Service
public class UserRoleService {

	@Autowired
	private UserRoleMapper userRoleMapper;

	/**
     * 查询用户角色关联关系信息
     *
     * @param id 用户角色关联关系ID
     * @return 用户角色关联关系信息
     */
	public UserRoleEntity findById(Long id) {
	    return userRoleMapper.findById(id);
	}

	/**
	 * 批量查询用户角色关联关系信息
	 *
	 * @param ids ID集合
	 * @return 用户角色关联关系信息
	 */
	public List<UserRoleEntity> findByIds(List<Long> ids) {
		return userRoleMapper.findByIds(ids);
	}

	/**
     * 根据条件分页查询用户角色关联关系列表
     *
     * @param userRoleConditionEntity 用户角色关联关系信息
     * @return 用户角色关联关系集合
     */
	public ResponsePageEntity<UserRoleEntity> searchByPage(UserRoleConditionEntity userRoleConditionEntity) {
		int count = userRoleMapper.searchCount(userRoleConditionEntity);
		if (count == 0) {
			return ResponsePageEntity.buildEmpty(userRoleConditionEntity);
		}
		List<UserRoleEntity> dataList = userRoleMapper.searchByCondition(userRoleConditionEntity);
		return ResponsePageEntity.build(userRoleConditionEntity, count, dataList);
	}

    /**
     * 新增用户角色关联关系
     *
     * @param userRoleEntity 用户角色关联关系信息
     * @return 结果
     */
	public int insert(UserRoleEntity userRoleEntity) {
	    return userRoleMapper.insert(userRoleEntity);
	}

	/**
     * 修改用户角色关联关系
     *
     * @param userRoleEntity 用户角色关联关系信息
     * @return 结果
     */
	public int update(UserRoleEntity userRoleEntity) {
	    return userRoleMapper.update(userRoleEntity);
	}

	/**
     * 批量删除用户角色关联关系对象
     *
     * @param ids 系统ID集合
     * @return 结果
     */
	public int deleteByIds(List<Long> ids) {
		List<UserRoleEntity> entities = userRoleMapper.findByIds(ids);

		UserRoleEntity entity = new UserRoleEntity();
		return userRoleMapper.deleteByIds(ids, entity);
	}

}
