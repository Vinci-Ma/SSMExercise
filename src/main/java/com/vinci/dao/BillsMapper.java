package com.vinci.dao;

import com.vinci.bean.Bills;

import java.util.List;
import java.util.Map;

public interface BillsMapper {
    //查询所有账单
    public List<Bills> getBills(Map map);

    //主键删除
    int deleteByPrimaryKey(Integer id);

    //动态新增
    int insert(Bills record);

    //动态新增
    int insertSelective(Bills record);

    //主键查询
    Bills selectByPrimaryKey(Integer id);

    //动态更新语句
    int updateByPrimaryKeySelective(Bills record);

    //更新
    int updateByPrimaryKey(Bills record);
}