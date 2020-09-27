package com.vinci.service;

import com.vinci.bean.Billtype;

import java.util.List;

/**
 * @Author:Vinci_Ma
 * @Oescription:
 * @Date Created in 2020-09-22-14:48
 * @Modified By:
 */
public interface BillTypesService {
    //查询所有类型
    public List<Billtype> getTypes();
}
