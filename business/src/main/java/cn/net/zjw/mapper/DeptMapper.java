package cn.net.zjw.mapper;

import cn.net.zjw.entity.DeptConditionEntity;
import cn.net.zjw.entity.DeptEntity;
import cn.net.zjw.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 部门 mapper
 *
 * @author ZhangJw 该项目是知识星球：java突击队 的内部项目
 * @date 2025-12-08 19:18:42
 */
public interface DeptMapper extends BaseMapper<DeptEntity, DeptConditionEntity> {
	/**
     * 查询部门信息
     *
     * @param id 部门ID
     * @return 部门信息
     */
	DeptEntity findById(Long id);

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

	/**
     * 批量查询部门信息
     *
     * @param ids ID集合
     * @return 部门信息
    */
	List<DeptEntity> findByIds(List<Long> ids);
}
