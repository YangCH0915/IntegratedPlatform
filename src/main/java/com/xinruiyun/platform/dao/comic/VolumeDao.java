package com.xinruiyun.platform.dao.comic;

import com.xinruiyun.platform.entity.comic.Volume;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VolumeDao {

     int insertVolume(@Param("v") Volume volume);

     List<Volume> findVolumeByComicId(int id);

     Volume findVolumeByVolumeId(@Param("comicId") int comicId,@Param("volumeId") int volumeId);
}
