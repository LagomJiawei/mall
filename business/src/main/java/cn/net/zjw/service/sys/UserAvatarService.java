package cn.net.zjw.service.sys;

import cn.net.zjw.entity.ResponsePageEntity;
import cn.net.zjw.entity.sys.UserAvatarConditionEntity;
import cn.net.zjw.entity.sys.UserAvatarEntity;
import cn.net.zjw.mapper.sys.UserAvatarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 用户头像 服务层
 *
 * @author ZhangJw
 * @date 2025-12-08 19:18:42
 */
@Service
public class UserAvatarService {

	@Autowired
	private UserAvatarMapper userAvatarMapper;

	/**
     * 查询用户头像信息
     *
     * @param id 用户头像ID
     * @return 用户头像信息
     */
	public UserAvatarEntity findById(Long id) {
	    return userAvatarMapper.findById(id);
	}

	/**
	 * 批量查询用户头像信息
	 *
	 * @param ids ID集合
	 * @return 用户头像信息
	 */
	public List<UserAvatarEntity> findByIds(List<Long> ids) {
		return userAvatarMapper.findByIds(ids);
	}

	/**
     * 根据条件分页查询用户头像列表
     *
     * @param userAvatarConditionEntity 用户头像信息
     * @return 用户头像集合
     */
	public ResponsePageEntity<UserAvatarEntity> searchByPage(UserAvatarConditionEntity userAvatarConditionEntity) {
		int count = userAvatarMapper.searchCount(userAvatarConditionEntity);
		if (count == 0) {
			return ResponsePageEntity.buildEmpty(userAvatarConditionEntity);
		}
		List<UserAvatarEntity> dataList = userAvatarMapper.searchByCondition(userAvatarConditionEntity);
		return ResponsePageEntity.build(userAvatarConditionEntity, count, dataList);
	}

    /**
     * 新增用户头像
     *
     * @param userAvatarEntity 用户头像信息
     * @return 结果
     */
	public int insert(UserAvatarEntity userAvatarEntity) {
	    return userAvatarMapper.insert(userAvatarEntity);
	}

	/**
     * 修改用户头像
     *
     * @param userAvatarEntity 用户头像信息
     * @return 结果
     */
	public int update(UserAvatarEntity userAvatarEntity) {
	    return userAvatarMapper.update(userAvatarEntity);
	}

	/**
     * 批量删除用户头像对象
     *
     * @param ids 系统ID集合
     * @return 结果
     */
	public int deleteByIds(List<Long> ids) {
		List<UserAvatarEntity> entities = userAvatarMapper.findByIds(ids);

		UserAvatarEntity entity = new UserAvatarEntity();
		return userAvatarMapper.deleteByIds(ids, entity);
	}

}
