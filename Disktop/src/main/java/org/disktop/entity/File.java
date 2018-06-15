package org.disktop.entity;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by flysLi on 2017/8/26.
 */
@Document(collection = "file")
public class File implements Serializable {

    @Id
    private Long id;

    @ApiModelProperty(value = "文件名称")
    private String name;

    @ApiModelProperty(value = "父目录")
    private String parentPath;

    @ApiModelProperty(value = "路径")
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentPath() {
        return parentPath;
    }

    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }
}
