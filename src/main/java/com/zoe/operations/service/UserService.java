package com.zoe.operations.service;

import com.zoe.operations.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    /**
     * 分页查询
     * @param paramMap
     * @return
     */
    List<User> getUserByPage(Map<String,Object> paramMap);

    User getUserById(String id);

    /**
     * 需要分页查询数据的总数
     * @return
     */
    int getUserByTotal();

    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 更新用户
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int deleteUser(String id);
}
