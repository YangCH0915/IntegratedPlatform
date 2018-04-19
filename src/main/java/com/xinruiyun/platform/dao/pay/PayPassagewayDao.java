package com.xinruiyun.platform.dao.pay;

import com.xinruiyun.platform.entity.pay.PayPassageway;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PayPassagewayDao {

    int addPassageway(@Param("pp")PayPassageway payPassageway);

    int deletePassageway(int id);

    int updatePassageway(@Param("pp")PayPassageway payPassageway);

    PayPassageway queryPassagewayById(int id);

    PayPassageway queryPassagewayByPassagewayId(String passagewayId);

    List<PayPassageway> queryPassagewayListByPage(@Param("offset") int offset, @Param("limit") int limit);

    long queryPassagewayCount();
}
