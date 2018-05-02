package com.xinruiyun.platform.service.pay.impl;

import com.xinruiyun.platform.dao.pay.PayPassagewayDao;
import com.xinruiyun.platform.dto.PagingQuery;
import com.xinruiyun.platform.entity.pay.PayPassageway;
import com.xinruiyun.platform.service.pay.PayPassagewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayPassagewayServiceImpl implements PayPassagewayService {

    @Autowired
    private PayPassagewayDao passagewayDao;

    @Override
    public int addPassageway(PayPassageway payPassageway) {
        return passagewayDao.addPassageway(payPassageway);
    }

    @Override
    public int deletePassageway(int id) {
        return passagewayDao.deletePassageway(id);
    }

    @Override
    public int updatePassageway(PayPassageway payPassageway) {
        return passagewayDao.updatePassageway(payPassageway);
    }

    @Override
    public PayPassageway queryPassagewayById(int id) {
        return passagewayDao.queryPassagewayById(id);
    }

    @Override
    public PayPassageway queryPassagewayByPassagewayId(String passagewayId) {
        return passagewayDao.queryPassagewayByPassagewayId(passagewayId);
    }

    @Override
    public List<PayPassageway> queryPassagewayListByPage(PagingQuery pagingQuery) {
        int offset = (int) (pagingQuery.getTotalRecords() - (pagingQuery.getPageSize()*pagingQuery.getPageIndex()));
        if(offset<0){
            pagingQuery.setPageSize(pagingQuery.getPageSize()+offset);
            offset = 0;
            pagingQuery.setPageIndex(offset);
        }else{
            pagingQuery.setPageIndex(offset);
        }
        return passagewayDao.queryPassagewayListByPage(pagingQuery);
    }

    @Override
    public long queryPassagewayCount() {
        return passagewayDao.queryPassagewayCount();
    }
}
