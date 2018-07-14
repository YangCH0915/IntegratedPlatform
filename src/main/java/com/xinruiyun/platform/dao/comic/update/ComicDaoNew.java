package com.xinruiyun.platform.dao.comic.update;

import com.xinruiyun.platform.entity.comic.Comic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ComicDaoNew {

    List<Comic> findAll();

    int insertComic(@Param("c") Comic comic);

    Comic findComicById(int id);
}
