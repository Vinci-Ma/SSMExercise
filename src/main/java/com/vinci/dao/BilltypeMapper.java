package com.vinci.dao;

import com.vinci.bean.Billtype;

import java.util.List;

public interface BilltypeMapper {
    //查询所有类型
    public List<Billtype> getTypes();

    int deleteByPrimaryKey(Integer id);

    int insert(Billtype record);

    int insertSelective(Billtype record);

    Billtype selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Billtype record);

    int updateByPrimaryKey(Billtype record);
}