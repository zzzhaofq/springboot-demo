package com.zfq.rbac.mapper;

import com.zfq.rbac.model.Access;

import java.util.List;

public interface AccessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Access record);

    int insertSelective(Access record);

    Access selectByPrimaryKey(Integer id);

    List<Access> selectByUsername(String username);

    int updateByPrimaryKeySelective(Access record);

    int updateByPrimaryKey(Access record);
}