package com.xinruiyun.platform.dao.comic;

import com.xinruiyun.platform.BaseTest;
import com.xinruiyun.platform.dao.comic.update.ComicDaoNew;
import com.xinruiyun.platform.dao.comic.update.PageDaoNew;
import com.xinruiyun.platform.dao.comic.update.VolumeDaoNew;
import com.xinruiyun.platform.entity.comic.Comic;
import com.xinruiyun.platform.entity.comic.Page;
import com.xinruiyun.platform.entity.comic.Volume;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import java.util.List;

public class ComicDaoTest extends BaseTest {

    @Autowired
    private ComicDao comicDao;

    @Autowired
    private ComicDaoNew comicDaoNew;

    @Autowired
    private PageDao pageDao;

    @Test
    public void findAll() {
        List<Comic> all = comicDao.findAll();
        for (Comic c : all) {
            System.out.println(all);
        }
    }

    @Test
    public void insertComic() {
        Comic c = new Comic();
        c.setMasterComicId(10029);
        c.setCover("");
        c.setCreateTime(new Date());
        c.setInSearch(true);
        c.setIntero("adf");
        c.setIsend(false);
        c.setLastVolpubTime(new Date());
        c.setLevel(false);
        c.setOpen(false);
        c.setTitle("测试一下");
        c.setVolumeCount(5);
        c.setUpdateTime(new Date());
        c.setReadAddRateMin(5);
        c.setReadAddRateMax(10);

        int i = comicDao.insertComic(c);
        System.out.println(i);
    }

    @Test
    public void findComicById() {
        Comic comic = comicDao.findComicById(10029);
        System.out.println(comic);
    }

    private static final String PATH = "E:/漫画资源/更新/";

    @Autowired
    private VolumeDaoNew volumeDaoNew;

    @Autowired
    private PageDaoNew pageDaoNew;

    @Test
    public void checkComic() {
        List<Comic> newComic = comicDaoNew.findAll();
        for (Comic c : newComic) {
            Comic comic = comicDao.findComicById(c.getMasterComicId());
            if (comic != null) {
                checkVolume(c);
            } else {
                System.out.println("不存在：" + c);
                //获取标题
                String bookName = c.getTitle();
                //获取封面
                String bookCover = c.getCover();
                List<Volume> volumes = volumeDaoNew.findVolumeByComicId(c.getMasterComicId());
                //保存章节地址
                for (Volume v : volumes) {
                    downloadVolume(c, v);
                }
            }
        }
    }

    @Autowired
    private VolumeDao volumeDao;

    private void checkVolume(Comic comic) {
        List<Volume> volumes = volumeDaoNew.findVolumeByComicId(comic.getMasterComicId());
        for (Volume v : volumes) {
            Volume volume = volumeDao.findVolumeByVolumeId(comic.getMasterComicId(), v.getMasterVolumeId());
            if (volume == null) {
                downloadVolume(comic, v);
            }
        }
    }

    @Test
    public void downloadUpdate() {
        int comicId = 6349;
        List<Volume> volume = volumeDao.findVolumeByComicId(comicId);
        String savePath = "E:\\漫画资源\\更新0716\\邻家少女";
        for (Volume v : volume) {
            if (v.getId() > 113168) {
                List<Page> pages = pageDao.findPageByComicIdAndVolumeId(comicId, v.getId());
                for (Page p : pages) {
                    String pageUrl = p.getPageUrl();
                    writeStringToFile(pageUrl, savePath, v.getTitle() + ".txt");
                }
            }
        }
    }

    private void downloadVolume(Comic comic, Volume v) {
        String vNumber = v.getTitle();
        String vCover = v.getCover();
        String savePath = PATH + comic.getTitle();
        writeStringToFile(vCover, savePath, vNumber + ".txt");
        List<Page> pages = pageDaoNew.findPageByComicIdAndVolumeId(comic.getMasterComicId(), v.getId());
        for (Page p : pages) {
            String pageUrl = p.getPageUrl();
            writeStringToFile(pageUrl, savePath, vNumber + ".txt");
        }
    }

    @Test
    public void onlyVolume() {
        String savePath = PATH + "解禁";
        List<Page> pages = pageDaoNew.findPageByComicIdAndVolumeId(6356, 113176);
        for (Page p : pages) {
            String pageUrl = p.getPageUrl();
            writeStringToFile(pageUrl, savePath, "第22话.txt");
        }
    }

    public void writeStringToFile(String url, String filePath, String fileName) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.mkdirs();
            }
            FileWriter fw = new FileWriter(file.getPath() + "/" + fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.append(url);
            bw.write("\r\n ");// 往已有的文件上添加字符串
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件重命名
     */
    public static void renameFile() {
        String path = "E:/漫画资源/更新/Roommate/第49话";
        File file = new File(path);
        if (file.isDirectory()) {
            String[] list = file.list();
            for (String string : list) {
                if (string.endsWith("null")) {
                    String replace = string.replace("null", "jpg");
                    File f = new File(path, string);
                    f.renameTo(new File(path, replace));
                }
            }
        }
    }

    public static void main(String[] args) {
        renameFile();
    }
}
























