package com.xinruiyun.platform.dao.comic;

import com.xinruiyun.platform.BaseTest;
import com.xinruiyun.platform.entity.comic.Volume;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class VolumeDaoTest extends BaseTest {

    @Autowired
    private VolumeDao volumeDao;

    @Test
    public void insertVolume() {
        Volume v = new Volume();
        v.setComicId(10029);
        v.setCover("");
        v.setMasterVolumeId(1);
        v.setCreateTime(new Date());
        v.setFree(true);
        v.setGold(50);
        v.setOpen(true);
        v.setOrderIndex(1);
        v.setOrderNo(1);
        v.setPageCount(10);
        v.setTitle("第一话");
        v.setUpdateTime(new Date());
        volumeDao.insertVolume(v);
    }

    @Test
    public void findVolumeByComicId() {
        List<Volume> volumes = volumeDao.findVolumeByComicId(6332);
        System.out.println(volumes);
    }

    @Test
    public void findVolumeByVolumeId() {
        Volume volume = volumeDao.findVolumeByVolumeId(10029, 1);
        System.out.println(volume);
    }
}