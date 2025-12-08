package cn.net.zjw.service;

import cn.net.zjw.entity.DeptConditionEntity;
import cn.net.zjw.entity.DeptEntity;
import cn.net.zjw.entity.ResponsePageEntity;
import cn.net.zjw.mapper.BaseMapper;
import cn.net.zjw.mapper.DeptMapper;
import cn.net.zjw.util.AssertUtil;
import cn.net.zjw.util.FillUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 部门 服务层
 *
 * @author ZhangJw 该项目是知识星球：java突击队 的内部项目
 * @date 2025-12-08 19:18:42
 */
@Service
public class DeptService extends BaseService< DeptEntity,  DeptConditionEntity> {

	@Autowired
	private DeptMapper deptMapper;

	/**
     * 查询部门信息
     *
     * @param id 部门ID
     * @return 部门信息
     */
	public DeptEntity findById(Long id) {
	    return deptMapper.findById(id);
	}

	/**
     * 根据条件分页查询部门列表
     *
     * @param deptConditionEntity 部门信息
     * @return 部门集合
     */
	public ResponsePageEntity<DeptEntity> searchByPage(DeptConditionEntity deptConditionEntity) {
		int count = deptMapper.searchCount(deptConditionEntity);
		if (count == 0) {
			return ResponsePageEntity.buildEmpty(deptConditionEntity);
		}
		List<DeptEntity> dataList = deptMapper.searchByCondition(deptConditionEntity);
		return ResponsePageEntity.build(deptConditionEntity, count, dataList);
	}

    /**
     * 新增部门
     *
     * @param deptEntity 部门信息
     * @return 结果
     */
	public int insert(DeptEntity deptEntity) {
	    return deptMapper.insert(deptEntity);
	}

	/**
     * 修改部门
     *
     * @param deptEntity 部门信息
     * @return 结果
     */
	public int update(DeptEntity deptEntity) {
	    return deptMapper.update(deptEntity);
	}

	/**
     * 批量删除部门对象
     *
     * @param ids 系统ID集合
     * @return 结果
     */
	public int deleteByIds(List<Long> ids) {
		List<DeptEntity> entities = deptMapper.findByIds(ids);
		AssertUtil.notEmpty(entities, "部门已被删除");

		DeptEntity entity = new DeptEntity();
		FillUserUtil.fillUpdateUserInfo(entity);
		return deptMapper.deleteByIds(ids, entity);
	}

	@Override
	protected BaseMapper getBaseMapper() {
		return deptMapper;
	}

}
