package cn.net.zjw.service;

import cn.net.zjw.entity.ResponsePageEntity;
import cn.net.zjw.entity.RoleConditionEntity;
import cn.net.zjw.entity.RoleEntity;
import cn.net.zjw.mapper.BaseMapper;
import cn.net.zjw.mapper.RoleMapper;
import cn.net.zjw.util.AssertUtil;
import cn.net.zjw.util.FillUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 角色 服务层
 *
 * @author ZhangJw 该项目是知识星球：java突击队 的内部项目
 * @date 2025-12-08 19:18:42
 */
@Service
public class RoleService extends BaseService< RoleEntity,  RoleConditionEntity> {

	@Autowired
	private RoleMapper roleMapper;

	/**
     * 查询角色信息
     *
     * @param id 角色ID
     * @return 角色信息
     */
	public RoleEntity findById(Long id) {
	    return roleMapper.findById(id);
	}

	/**
     * 根据条件分页查询角色列表
     *
     * @param roleConditionEntity 角色信息
     * @return 角色集合
     */
	public ResponsePageEntity<RoleEntity> searchByPage(RoleConditionEntity roleConditionEntity) {
		int count = roleMapper.searchCount(roleConditionEntity);
		if (count == 0) {
			return ResponsePageEntity.buildEmpty(roleConditionEntity);
		}
		List<RoleEntity> dataList = roleMapper.searchByCondition(roleConditionEntity);
		return ResponsePageEntity.build(roleConditionEntity, count, dataList);
	}

    /**
     * 新增角色
     *
     * @param roleEntity 角色信息
     * @return 结果
     */
	public int insert(RoleEntity roleEntity) {
	    return roleMapper.insert(roleEntity);
	}

	/**
     * 修改角色
     *
     * @param roleEntity 角色信息
     * @return 结果
     */
	public int update(RoleEntity roleEntity) {
	    return roleMapper.update(roleEntity);
	}

	/**
     * 批量删除角色对象
     *
     * @param ids 系统ID集合
     * @return 结果
     */
	public int deleteByIds(List<Long> ids) {
		List<RoleEntity> entities = roleMapper.findByIds(ids);
		AssertUtil.notEmpty(entities, "角色已被删除");

		RoleEntity entity = new RoleEntity();
		FillUserUtil.fillUpdateUserInfo(entity);
		return roleMapper.deleteByIds(ids, entity);
	}

	@Override
	protected BaseMapper getBaseMapper() {
		return roleMapper;
	}

}
