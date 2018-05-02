package com.xinruiyun.platform.service.pay;

import com.xinruiyun.platform.dto.PagingQuery;
import com.xinruiyun.platform.entity.pay.PayPassageway;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PayPassagewayService {

    int addPassageway(PayPassageway payPassageway);

    int deletePassageway(int id);

    int updatePassageway(PayPassageway payPassageway);

    PayPassageway queryPassagewayById(int id);

    PayPassageway queryPassagewayByPassagewayId(String passagewayId);

    List<PayPassageway> queryPassagewayListByPage(PagingQuery pagingQuery);

    long queryPassagewayCount();
}
