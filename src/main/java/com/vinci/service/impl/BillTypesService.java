package com.vinci.service.impl;

import com.vinci.bean.Billtype;
import com.vinci.dao.BilltypeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:Vinci_Ma
 * @Oescription:
 * @Date Created in 2020-09-22-14:51
 * @Modified By:
 */
@Service
public class BillTypesService implements com.vinci.service.BillTypesService {
    @Resource
    private BilltypeMapper billtypeMapper;
    @Override
    public List<Billtype> getTypes() {
        return billtypeMapper.getTypes();
    }
}
