package cn.net.zjw.service;

import cn.net.zjw.entity.ResponsePageEntity;
import cn.net.zjw.entity.RoleDeptConditionEntity;
import cn.net.zjw.entity.RoleDeptEntity;
import cn.net.zjw.mapper.BaseMapper;
import cn.net.zjw.mapper.RoleDeptMapper;
import cn.net.zjw.util.AssertUtil;
import cn.net.zjw.util.FillUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 角色部门关联关系 服务层
 *
 * @author ZhangJw 该项目是知识星球：java突击队 的内部项目
 * @date 2025-12-08 19:18:42
 */
@Service
public class RoleDeptService extends BaseService< RoleDeptEntity,  RoleDeptConditionEntity> {

	@Autowired
	private RoleDeptMapper roleDeptMapper;

	/**
     * 查询角色部门关联关系信息
     *
     * @param id 角色部门关联关系ID
     * @return 角色部门关联关系信息
     */
	public RoleDeptEntity findById(Long id) {
	    return roleDeptMapper.findById(id);
	}

	/**
     * 根据条件分页查询角色部门关联关系列表
     *
     * @param roleDeptConditionEntity 角色部门关联关系信息
     * @return 角色部门关联关系集合
     */
	public ResponsePageEntity<RoleDeptEntity> searchByPage(RoleDeptConditionEntity roleDeptConditionEntity) {
		int count = roleDeptMapper.searchCount(roleDeptConditionEntity);
		if (count == 0) {
			return ResponsePageEntity.buildEmpty(roleDeptConditionEntity);
		}
		List<RoleDeptEntity> dataList = roleDeptMapper.searchByCondition(roleDeptConditionEntity);
		return ResponsePageEntity.build(roleDeptConditionEntity, count, dataList);
	}

    /**
     * 新增角色部门关联关系
     *
     * @param roleDeptEntity 角色部门关联关系信息
     * @return 结果
     */
	public int insert(RoleDeptEntity roleDeptEntity) {
	    return roleDeptMapper.insert(roleDeptEntity);
	}

	/**
     * 修改角色部门关联关系
     *
     * @param roleDeptEntity 角色部门关联关系信息
     * @return 结果
     */
	public int update(RoleDeptEntity roleDeptEntity) {
	    return roleDeptMapper.update(roleDeptEntity);
	}

	/**
     * 批量删除角色部门关联关系对象
     *
     * @param ids 系统ID集合
     * @return 结果
     */
	public int deleteByIds(List<Long> ids) {
		List<RoleDeptEntity> entities = roleDeptMapper.findByIds(ids);
		AssertUtil.notEmpty(entities, "角色部门关联关系已被删除");

		RoleDeptEntity entity = new RoleDeptEntity();
		FillUserUtil.fillUpdateUserInfo(entity);
		return roleDeptMapper.deleteByIds(ids, entity);
	}

	@Override
	protected BaseMapper getBaseMapper() {
		return roleDeptMapper;
	}

}
