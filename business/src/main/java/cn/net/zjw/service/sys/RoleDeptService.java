package cn.net.zjw.service.sys;

import cn.net.zjw.entity.ResponsePageEntity;
import cn.net.zjw.entity.sys.RoleDeptConditionEntity;
import cn.net.zjw.entity.sys.RoleDeptEntity;
import cn.net.zjw.mapper.sys.RoleDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 角色部门关联关系 服务层
 *
 * @author ZhangJw
 * @date 2025-12-08 19:18:42
 */
@Service
public class RoleDeptService {

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
	 * 批量查询角色部门关联关系信息
	 *
	 * @param ids ID集合
	 * @return 角色部门关联关系信息
	 */
	public List<RoleDeptEntity> findByIds(List<Long> ids) {
		return roleDeptMapper.findByIds(ids);
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

		RoleDeptEntity entity = new RoleDeptEntity();
		return roleDeptMapper.deleteByIds(ids, entity);
	}

}
