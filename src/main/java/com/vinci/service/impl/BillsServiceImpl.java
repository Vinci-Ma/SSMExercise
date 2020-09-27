package com.vinci.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vinci.bean.Bills;
import com.vinci.dao.BillsMapper;
import com.vinci.service.BillsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:Vinci_Ma
 * @Oescription:
 * @Date Created in 2020-09-22-14:50
 * @Modified By:
 */
@Service
public class BillsServiceImpl implements BillsService {
    @Resource
    private BillsMapper billsMapper;

    @Override
    public PageInfo<Bills> getBills(int typeid, String begin, String end, int index, int size) {
        Map params=new HashMap();
        params.put("tid",typeid);
        params.put("begin",begin);
        params.put("end",end);
        //1、指定分页数据
        PageHelper.startPage(index,size);
        //2、查询数据
        List<Bills> bills = billsMapper.getBills(params);
        //3、创建分页工具类
        PageInfo<Bills> info = new PageInfo<>(bills);
        return info;
    }

    @Override
    @Transactional
    public int insert(Bills record) {
        return billsMapper.insert(record);
    }

    @Override
    @Transactional
    public Bills selectByPrimaryKey(Integer id) {
        return billsMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int updateByPrimaryKey(Bills record) {
        return billsMapper.updateByPrimaryKey(record);
    }

    @Override
    @Transactional
    public int deleteByPrimaryKey(Integer id) {
        return billsMapper.deleteByPrimaryKey(id);
    }
}
