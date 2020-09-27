package com.vinci.service;

import com.github.pagehelper.PageInfo;
import com.vinci.bean.Bills;

import java.util.List;

/**
 * @Author:Vinci_Ma
 * @Oescription:
 * @Date Created in 2020-09-22-14:47
 * @Modified By:
 */
public interface BillsService {
    //查询所有账单
    public PageInfo<Bills> getBills(int typeid, String begin, String end, int index, int size);
    int insert(Bills record);
    //主键查询
    Bills selectByPrimaryKey(Integer id);
    //更新
    int updateByPrimaryKey(Bills record);
    //主键删除
    int deleteByPrimaryKey(Integer id);
}
