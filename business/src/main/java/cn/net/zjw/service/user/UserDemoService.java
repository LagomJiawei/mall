package cn.net.zjw.service.user;

import cn.net.zjw.entity.ResponsePageEntity;
import cn.net.zjw.entity.user.UserConditionEntity;
import cn.net.zjw.entity.user.UserEntity;
import cn.net.zjw.mapper.user.UserDemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZhangJw
 * @date 2025年12月06日 16:18
 * 用户服务
 */
@Service
public class UserDemoService {
    @Autowired
    private UserDemoMapper userDemoMapper;

    /**
     * 通过id查询用户信息
     *
     * @param id 系统ID
     * @return 用户信息
     */
    public UserEntity findById(Long id) {
        return userDemoMapper.findById(id);
    }

    /**
     * 根据条件查询用户列表
     *
     * @param userConditionEntity 条件
     * @return 用户列表
     */
    public ResponsePageEntity<UserEntity> searchByPage(UserConditionEntity userConditionEntity) {
        int count = userDemoMapper.searchCount(userConditionEntity);
        if (count == 0) {
            return ResponsePageEntity.buildEmpty(userConditionEntity);
        }
        List<UserEntity> userEntities = userDemoMapper.searchByCondition(userConditionEntity);
        return ResponsePageEntity.build(userConditionEntity, count, userEntities);
    }


    /**
     * 添加用户
     *
     * @param userEntity 用户实体
     * @return 影响行数
     */
    public int insert(UserEntity userEntity) {
        return userDemoMapper.insert(userEntity);
    }

    /**
     * 修改用户
     *
     * @param userEntity 用户实体
     * @return 影响行数
     */
    public int update(UserEntity userEntity) {
        return userDemoMapper.update(userEntity);
    }

    /**
     * 删除用户
     *
     * @param id 用户ID
     * @return 影响行数
     */
    public int deleteById(Long id) {
        return userDemoMapper.deleteById(id);
    }
}