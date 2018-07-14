package com.xinruiyun.platform.dao.comic;

import com.xinruiyun.platform.entity.comic.Comic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ComicDao {

    List<Comic> findAll();

    int insertComic(@Param("c") Comic comic);

    Comic findComicById(int id);
}
