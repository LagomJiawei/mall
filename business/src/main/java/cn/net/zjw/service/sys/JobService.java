package cn.net.zjw.service.sys;

import cn.net.zjw.entity.sys.JobConditionEntity;
import cn.net.zjw.entity.sys.JobEntity;
import cn.net.zjw.entity.ResponsePageEntity;
import cn.net.zjw.mapper.sys.JobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 岗位 服务层
 *
 * @author ZhangJw
 * @date 2025-12-08 19:18:42
 */
@Service
public class JobService {

	@Autowired
	private JobMapper jobMapper;

	/**
     * 查询岗位信息
     *
     * @param id 岗位ID
     * @return 岗位信息
     */
	public JobEntity findById(Long id) {
	    return jobMapper.findById(id);
	}

	/**
	 * 批量查询岗位信息
	 *
	 * @param ids ID集合
	 * @return 岗位信息
	 */
	public List<JobEntity> findByIds(List<Long> ids) {
		return jobMapper.findByIds(ids);
	}

	/**
     * 根据条件分页查询岗位列表
     *
     * @param jobConditionEntity 岗位信息
     * @return 岗位集合
     */
	public ResponsePageEntity<JobEntity> searchByPage(JobConditionEntity jobConditionEntity) {
		int count = jobMapper.searchCount(jobConditionEntity);
		if (count == 0) {
			return ResponsePageEntity.buildEmpty(jobConditionEntity);
		}
		List<JobEntity> dataList = jobMapper.searchByCondition(jobConditionEntity);
		return ResponsePageEntity.build(jobConditionEntity, count, dataList);
	}

    /**
     * 新增岗位
     *
     * @param jobEntity 岗位信息
     * @return 结果
     */
	public int insert(JobEntity jobEntity) {
	    return jobMapper.insert(jobEntity);
	}

	/**
     * 修改岗位
     *
     * @param jobEntity 岗位信息
     * @return 结果
     */
	public int update(JobEntity jobEntity) {
	    return jobMapper.update(jobEntity);
	}

	/**
     * 批量删除岗位对象
     *
     * @param ids 系统ID集合
     * @return 结果
     */
	public int deleteByIds(List<Long> ids) {
		List<JobEntity> entities = jobMapper.findByIds(ids);

		JobEntity entity = new JobEntity();
		return jobMapper.deleteByIds(ids, entity);
	}

}
