package com.xinruiyun.platform.dao.comic;

import com.xinruiyun.platform.BaseTest;
import com.xinruiyun.platform.entity.comic.Page;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PageDaoTest extends BaseTest {

    @Autowired
    private PageDao pageDao;

    @Test
    public void findPageByComicIdAndVolumeId() {
        List<Page> pageList = pageDao.findPageByComicIdAndVolumeId(6303, 111647);
        for(Page page:pageList){
            System.out.println(page);
        }
    }

    @Test
    public void insertPage() {
    }
}