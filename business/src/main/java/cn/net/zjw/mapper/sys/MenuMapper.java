package cn.net.zjw.mapper.sys;

import cn.net.zjw.entity.sys.MenuConditionEntity;
import cn.net.zjw.entity.sys.MenuEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单 mapper
 *
 * @author ZhangJw 该项目是知识星球：java突击队 的内部项目
 * @date 2025-12-08 19:18:42
 */
public interface MenuMapper {
	/**
     * 查询菜单信息
     *
     * @param id 菜单ID
     * @return 菜单信息
     */
	MenuEntity findById(Long id);

	/**
	 * 批量查询菜单信息
	 *
	 * @param ids ID集合
	 * @return 菜单信息
	 */
	List<MenuEntity> findByIds(List<Long> ids);

	/**
	 * 根据条件查询菜单列表
	 *
	 * @param menuConditionEntity 条件
	 * @return 菜单列表
	 */
	List<MenuEntity> searchByCondition(MenuConditionEntity menuConditionEntity);

	/**
	 * 根据条件查询菜单数量
	 *
	 * @param menuConditionEntity 条件
	 * @return 菜单数量
	 */
	int searchCount(MenuConditionEntity menuConditionEntity);

	/**
     * 添加菜单
     *
     * @param menuEntity 菜单信息
     * @return 结果
     */
	int insert(MenuEntity menuEntity);

	/**
     * 修改菜单
     *
     * @param menuEntity 菜单信息
     * @return 结果
     */
	int update(MenuEntity menuEntity);

	/**
     * 批量删除菜单
     *
     * @param ids id集合
     * @param entity 菜单实体
     * @return 结果
     */
	int deleteByIds(@Param("ids") List<Long> ids, @Param("entity") MenuEntity entity);
}
