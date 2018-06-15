package org.disktop.environ;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * 文件资源管理器
 *
 * @author flysLi
 */
public class FileExplorer {
    /**
     * 文件或文件夹名称
     */
    private String fileName;

    /**
     * 文件大小(k)
     */
    private int size;

    /**
     * 是否是目录 true：目录 false：文件
     */
    private boolean isDirectory;

    /**
     * 文件后缀名
     */
    private String suffix;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 子文件或子目录
     */
    private List<FileExplorer> sons;

    /**
     * 父目录
     */
    private String parentPath;

    public String getParentPath() {
        return parentPath;
    }

    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    /**
     * 文件绝对地址
     */
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean getIsDirectory() {
        return isDirectory;
    }

    public void setIsDirectory(boolean isDirectory) {
        this.isDirectory = isDirectory;
    }

    public List<FileExplorer> getSons() {
        return sons;
    }

    public void setSons(List<FileExplorer> sons) {
        this.sons = sons;
    }

    public void setDirectory(boolean isDirectory) {
        this.isDirectory = isDirectory;
    }

    /**
     * 获取文件后缀名
     *
     * @param file
     * @return
     */
    public static String getSuffix(File file) {
        if (file.isDirectory()) {
            return null;
        }
        String filename = file.getName();
        int startIndex = filename.lastIndexOf(".");
        if (startIndex == -1) {
            return "noType";
        }
        return filename.substring(startIndex + 1);
    }

    public FileExplorer(String obj) {
        /**
         * 如果构造的父目录是空的，则默认选择 当前项目的文件资源根目录
         */
        List<FileExplorer> fes = new ArrayList<FileExplorer>();
        if (obj == null || obj.trim().length() == 0) {
            File[] roots = File.listRoots();
            for (int i = 0; i < roots.length; i++) {
                FileExplorer fe = new FileExplorer();
                fe.setPath(roots[i].getPath());
                fe.setFileName(roots[i].toString());
                fe.setIsDirectory(roots[i].isDirectory());
                fe.setCreateDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(roots[i].lastModified())));
                fes.add(fe);
            }
            this.setSons(fes);
        } else {
            // 获取子目录或文件
            File file = new File(obj);
            this.setCreateDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(file.lastModified())));
            this.setFileName(file.getName());
            this.setPath(obj);
            this.setParentPath(file.getParent());

            //如果是目录,则获取子信息
            if (file.isDirectory()) {
                this.setIsDirectory(file.isDirectory());
                File[] files = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    FileExplorer fe = new FileExplorer();
                    fe.setPath(files[i].getPath());
                    fe.setFileName(files[i].getName());
                    fe.setIsDirectory(files[i].isDirectory());
                    fe.setCreateDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(files[i].lastModified())));
                    fes.add(fe);
                }
                this.setSons(fes);
            } else {
                this.setIsDirectory(false);
            }
        }


    }

    public FileExplorer() {

    }

    public static void main(String[] args) {
        String str = "C:\\Users\\flysLi\\Desktop\\temp\\官网\\images\\tb04.png";
//		FileExplorer fe = new FileExplorer(str);
//		List<FileExplorer> fes = fe.getSons();
//		for (FileExplorer fileExplorer : fes) {
//			System.out.println(fileExplorer.getFileName());
//		}

//        File file = new File(str);
//        System.out.println(FileExplorer.getSuffix(file));

        // 获取子目录
        FileExplorer fileExplorer = new FileExplorer("D:\\");
        List<FileExplorer> fileExplorers = fileExplorer.getSons();
        for (FileExplorer fileExplorer1 : fileExplorers) {
            System.out.println(fileExplorer1.getFileName());
        }

        //获取根目录
//        File[] roots = File.listRoots();
//        for (int i = 0; i < roots.length; i++) {
//            System.out.println(roots[i]);
//        }

    }
}
