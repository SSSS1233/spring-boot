package com.example.mapping;

import com.example.po.User;

import java.util.List;

public interface UserMapping {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    List<User> selectAll();
    String selectName(User user);
    String selectpass(User user);
}