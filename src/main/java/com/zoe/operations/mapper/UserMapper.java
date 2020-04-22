package com.zoe.operations.mapper;

import com.zoe.operations.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    List<User> selectUserByPage(Map<String, Object> paramMap);

    User selectUserById(String id);

    int selectUserByTotal();

    int updateByPrimarySelective(User record);

    int deleteByPrimaryKey(String id);
}