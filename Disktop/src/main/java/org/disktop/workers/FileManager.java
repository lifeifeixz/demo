package org.disktop.workers;

import org.disktop.environ.FileExplorer;
import org.disktop.notebook.FileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

/**
 * Created by flysLi on 2017/8/26.
 * <p>
 * <a>文件管理员</a>
 * <p>他拥有诸多职责，但所赋予他最重要的任务将是从海量文件或目录中取出部分所需要的部分。
 * 在这里，我们将这些文件或者目录统称为书(book)。这个实例，我们称为图书馆(library)。
 * <p>
 * 设计之初：我们只记录book的名字和书的所在位置,最开始的时候选择了速度很快的redis,
 * 但是后来发现,在查询的时候需要给他提供更多的信息，但是我们仅仅知道书的名称，且还不是
 * 那么的确定，所以。我们将在后面适用mongo来对书籍信息进行记录。
 * <p>
 * 对于书籍统计，我们将记录在一个册子上(数据库)。对于用户来讲，我之需知道
 * 这本书的名称即可，甚至不需要记得那么清楚。
 * </p>
 *
 * @auther lifeifei
 */
@Component
public class FileManager {

    /**
     * 查询部分文件
     *
     * @param name
     * @return
     */
    public List<FileExplorer> find(String name) {

        return null;
    }

    /**
     * 统计数据:
     * 将硬盘中的数据统计至记录册中
     *
     * @param path
     */
    public void stat(String path) {

    }

    // 递归遍历
    private void getDirectory(File file) {
        File flist[] = file.listFiles();
        if (flist == null || flist.length == 0) {
            return;
        }
        for (File f : flist) {
            if (f.isDirectory()) {
                //这里将列出所有的文件夹
                getDirectory(f);
            } else {
                //这里将列出所有的文件
            }
        }
    }


}
