package com.xinruiyun.platform.dao.comic.update;

import com.xinruiyun.platform.entity.comic.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PageDaoNew {

    List<Page> findPageByComicIdAndVolumeId(@Param("comicId") int comicId, @Param("volumeId") int volumeId);

    int insertPage(@Param("p") Page page);
}
