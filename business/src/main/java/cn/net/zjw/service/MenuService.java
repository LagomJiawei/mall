package cn.net.zjw.service;

import cn.net.zjw.entity.MenuConditionEntity;
import cn.net.zjw.entity.MenuEntity;
import cn.net.zjw.entity.ResponsePageEntity;
import cn.net.zjw.mapper.BaseMapper;
import cn.net.zjw.mapper.MenuMapper;
import cn.net.zjw.util.AssertUtil;
import cn.net.zjw.util.FillUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 菜单 服务层
 *
 * @author ZhangJw 该项目是知识星球：java突击队 的内部项目
 * @date 2025-12-08 19:18:42
 */
@Service
public class MenuService extends BaseService< MenuEntity,  MenuConditionEntity> {

	@Autowired
	private MenuMapper menuMapper;

	/**
     * 查询菜单信息
     *
     * @param id 菜单ID
     * @return 菜单信息
     */
	public MenuEntity findById(Long id) {
	    return menuMapper.findById(id);
	}

	/**
     * 根据条件分页查询菜单列表
     *
     * @param menuConditionEntity 菜单信息
     * @return 菜单集合
     */
	public ResponsePageEntity<MenuEntity> searchByPage(MenuConditionEntity menuConditionEntity) {
		int count = menuMapper.searchCount(menuConditionEntity);
		if (count == 0) {
			return ResponsePageEntity.buildEmpty(menuConditionEntity);
		}
		List<MenuEntity> dataList = menuMapper.searchByCondition(menuConditionEntity);
		return ResponsePageEntity.build(menuConditionEntity, count, dataList);
	}

    /**
     * 新增菜单
     *
     * @param menuEntity 菜单信息
     * @return 结果
     */
	public int insert(MenuEntity menuEntity) {
	    return menuMapper.insert(menuEntity);
	}

	/**
     * 修改菜单
     *
     * @param menuEntity 菜单信息
     * @return 结果
     */
	public int update(MenuEntity menuEntity) {
	    return menuMapper.update(menuEntity);
	}

	/**
     * 批量删除菜单对象
     *
     * @param ids 系统ID集合
     * @return 结果
     */
	public int deleteByIds(List<Long> ids) {
		List<MenuEntity> entities = menuMapper.findByIds(ids);
		AssertUtil.notEmpty(entities, "菜单已被删除");

		MenuEntity entity = new MenuEntity();
		FillUserUtil.fillUpdateUserInfo(entity);
		return menuMapper.deleteByIds(ids, entity);
	}

	@Override
	protected BaseMapper getBaseMapper() {
		return menuMapper;
	}

}
