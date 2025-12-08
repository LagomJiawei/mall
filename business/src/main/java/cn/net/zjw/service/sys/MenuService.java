package cn.net.zjw.service.sys;

import cn.net.zjw.entity.sys.MenuConditionEntity;
import cn.net.zjw.entity.sys.MenuEntity;
import cn.net.zjw.entity.ResponsePageEntity;
import cn.net.zjw.mapper.sys.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 菜单 服务层
 *
 * @author ZhangJw
 * @date 2025-12-08 19:18:42
 */
@Service
public class MenuService {

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
	 * 批量查询菜单信息
	 *
	 * @param ids ID集合
	 * @return 菜单信息
	 */
	public List<MenuEntity> findByIds(List<Long> ids) {
		return menuMapper.findByIds(ids);
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

		MenuEntity entity = new MenuEntity();
		return menuMapper.deleteByIds(ids, entity);
	}

}
