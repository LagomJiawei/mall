package cn.net.zjw.mapper;

import cn.net.zjw.entity.JobConditionEntity;
import cn.net.zjw.entity.JobEntity;
import cn.net.zjw.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 岗位 mapper
 *
 * @author ZhangJw 该项目是知识星球：java突击队 的内部项目
 * @date 2025-12-08 19:18:42
 */
public interface JobMapper extends BaseMapper<JobEntity, JobConditionEntity> {
	/**
     * 查询岗位信息
     *
     * @param id 岗位ID
     * @return 岗位信息
     */
	JobEntity findById(Long id);

	/**
     * 添加岗位
     *
     * @param jobEntity 岗位信息
     * @return 结果
     */
	int insert(JobEntity jobEntity);

	/**
     * 修改岗位
     *
     * @param jobEntity 岗位信息
     * @return 结果
     */
	int update(JobEntity jobEntity);

	/**
     * 批量删除岗位
     *
     * @param ids id集合
     * @param entity 岗位实体
     * @return 结果
     */
	int deleteByIds(@Param("ids") List<Long> ids, @Param("entity") JobEntity entity);

	/**
     * 批量查询岗位信息
     *
     * @param ids ID集合
     * @return 部门信息
    */
	List<JobEntity> findByIds(List<Long> ids);
}
