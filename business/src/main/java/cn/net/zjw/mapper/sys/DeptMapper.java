package cn.net.zjw.mapper.sys;

import cn.net.zjw.entity.sys.DeptConditionEntity;
import cn.net.zjw.entity.sys.DeptEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 部门 mapper
 *
 * @author ZhangJw
 * @date 2025-12-08 19:18:42
 */
public interface DeptMapper {
	/**
     * 查询部门信息
     *
     * @param id 部门ID
     * @return 部门信息
     */
	DeptEntity findById(Long id);

	/**
	 * 批量查询部门信息
	 *
	 * @param ids ID集合
	 * @return 部门信息
	 */
	List<DeptEntity> findByIds(List<Long> ids);

	/**
	 * 根据条件查询部门列表
	 *
	 * @param deptConditionEntity 条件
	 * @return 部门列表
	 */
	List<DeptEntity> searchByCondition(DeptConditionEntity deptConditionEntity);

	/**
	 * 根据条件查询部门数量
	 *
	 * @param deptConditionEntity 条件
	 * @return 部门数量
	 */
	int searchCount(DeptConditionEntity deptConditionEntity);

	/**
     * 添加部门
     *
     * @param deptEntity 部门信息
     * @return 结果
     */
	int insert(DeptEntity deptEntity);

	/**
     * 修改部门
     *
     * @param deptEntity 部门信息
     * @return 结果
     */
	int update(DeptEntity deptEntity);

	/**
     * 批量删除部门
     *
     * @param ids id集合
     * @param entity 部门实体
     * @return 结果
     */
	int deleteByIds(@Param("ids") List<Long> ids, @Param("entity") DeptEntity entity);
}
