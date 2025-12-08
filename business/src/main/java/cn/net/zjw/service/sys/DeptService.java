package cn.net.zjw.service.sys;

import cn.net.zjw.entity.sys.DeptConditionEntity;
import cn.net.zjw.entity.sys.DeptEntity;
import cn.net.zjw.entity.ResponsePageEntity;
import cn.net.zjw.mapper.sys.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 部门 服务层
 *
 * @author ZhangJw
 * @date 2025-12-08 19:18:42
 */
@Service
public class DeptService {

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
	 * 批量查询部门信息
	 *
	 * @param ids ID集合
	 * @return 部门信息
	 */
	public List<DeptEntity> findByIds(List<Long> ids) {
		return deptMapper.findByIds(ids);
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

		DeptEntity entity = new DeptEntity();
		return deptMapper.deleteByIds(ids, entity);
	}

}
