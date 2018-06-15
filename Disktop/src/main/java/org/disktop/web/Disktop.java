package org.disktop.web;

import io.swagger.annotations.ApiParam;
import org.disktop.environ.FileExplorer;
import org.disktop.notebook.FileRepository;
import org.disktop.utils.StringUtil;
import org.disktop.workers.FileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by flysLi on 2017/8/25.
 */
@SuppressWarnings("All")
@RestController
public class Disktop {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private FileManager fileManager;

    @Autowired
    private FileRepository fileRepository;

    /**
     * index
     *
     * @return
     */
    @RequestMapping(value = "/path", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public FileExplorer path(HttpServletRequest request) {
        String path = request.getParameter("path");
        FileExplorer fileExplorer = null;
        //判断文件是否存在
        if (StringUtil.isNull(path)) {
            return new FileExplorer(path);
        }
        File file = new File(path);
        if (file.isDirectory() || file.isFile()) {
            fileExplorer = new FileExplorer(path);
        } else {
            fileExplorer = this.search(path);
        }
        return fileExplorer;
    }

    /**
     * 搜索应用
     *
     * @param fileName
     * @return
     */
    @RequestMapping(value = "search", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public FileExplorer search(@ApiParam(name = "路径", value = "例:D:") @RequestParam(required = false) String fileName) {
        FileExplorer fileExplorer = new FileExplorer("");
        Object[] objs = redisTemplate.opsForHash().keys(fileName).toArray();
        FileExplorer fileExplorer1 = new FileExplorer();
        List<FileExplorer> list = new ArrayList<FileExplorer>();
        for (Object obj : objs) {
            list.add(new FileExplorer(obj.toString()));
        }
        fileExplorer1.setSons(list);
        return fileExplorer1;
    }

    /**
     * 初始化硬盘
     *
     * @return
     */
    @RequestMapping(value = "init", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Object init(@ApiParam(name = "路径", value = "例:D:") @RequestParam(required = false) String path) {
        if (StringUtil.isNull(path)) {
            path = "D:\\";
        }
        long start = System.currentTimeMillis();
        this.getDirectory(new java.io.File(path));
        long end = System.currentTimeMillis();
        return (end - start) / 1000;
    }

    public static void main(String[] args) {
        //盘里某个路径下的所有文件和目录
        Disktop disktop = new Disktop();
        long start = System.currentTimeMillis();
        disktop.getDirectory(new java.io.File("D:\\APP"));
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000);
    }

    // 递归遍历
    private void getDirectory(java.io.File file) {

        java.io.File flist[] = file.listFiles();
        if (flist == null || flist.length == 0) {
            return;
        }
        for (java.io.File f : flist) {
            if (f.isDirectory()) {
                getDirectory(f);
            } else {
                //这里将列出所有的文件
                redisTemplate.opsForHash().put(f.getName(), f.getPath(), f.getParent());
            }
        }
    }

    public void genetateExplorer(java.io.File file) {
        java.io.File[] files = file.listFiles();
        if (files == null || files.length == 0) {
            return;
        }
        List<FileExplorer> sons = new ArrayList<FileExplorer>();
        for (java.io.File f : files) {
            if (f.isDirectory()) {
                //sons.add(new FileExplorer(f.getPath()));
                getDirectory(f);
            } else {
                sons.add(new FileExplorer(f.getPath()));
            }
        }
    }


}
