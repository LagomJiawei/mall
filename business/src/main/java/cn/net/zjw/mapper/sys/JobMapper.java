package cn.net.zjw.mapper.sys;

import cn.net.zjw.entity.sys.JobConditionEntity;
import cn.net.zjw.entity.sys.JobEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 岗位 mapper
 *
 * @author ZhangJw
 * @date 2025-12-08 19:18:42
 */
public interface JobMapper {
	/**
     * 查询岗位信息
     *
     * @param id 岗位ID
     * @return 岗位信息
     */
	JobEntity findById(Long id);

	/**
	 * 批量查询岗位信息
	 *
	 * @param ids ID集合
	 * @return 岗位信息
	 */
	List<JobEntity> findByIds(List<Long> ids);

	/**
	 * 根据条件查询岗位列表
	 *
	 * @param jobConditionEntity 条件
	 * @return 岗位列表
	 */
	List<JobEntity> searchByCondition(JobConditionEntity jobConditionEntity);

	/**
	 * 根据条件查询岗位数量
	 *
	 * @param jobConditionEntity 条件
	 * @return 岗位数量
	 */
	int searchCount(JobConditionEntity jobConditionEntity);

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
}
