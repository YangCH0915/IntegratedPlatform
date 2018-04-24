package com.xinruiyun.platform.dao;

import com.xinruiyun.platform.entity.QCellCore;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface QCellCoreDao {

	@Select("SELECT * FROM phone_ascription where sectionNo=#{sectionNo}")
	QCellCore getQCellCoreBysectionNo(String sectionNo);
}











