package com.austin.common.entity;

import com.austin.common.core.constant.TimeConstant;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 附件表
 * </p>
 *
 * @author AustinGJ
 * @since 2021-06-02
 */
@TableName("busi_attachment")
@ApiModel(value="Attachment对象", description="附件表")
public class Attachment implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "编号UUID")
      @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty(value = "附件名称")
    @TableField("file_name")
    private String fileName;

    @ApiModelProperty(value = "附件后缀名")
    @TableField("ext")
    private String ext;

    @ApiModelProperty(value = "附件地址")
    @TableField("url")
    private String url;

    @ApiModelProperty(value = "附件路径")
    @TableField("path")
    private String path;

    @ApiModelProperty(value = "创建时间")
    @TableField("ctime")
    @JsonFormat(timezone = TimeConstant.TIME_ZONE, pattern = TimeConstant.DATETIME_FORMAT)
    @DateTimeFormat(pattern = TimeConstant.DATETIME_FORMAT)
    private LocalDateTime ctime;

    @ApiModelProperty(value = "逻辑删除（1为删除状态，0为未删除状态）")
    @TableField("is_delete")
    private Integer isDelete;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public LocalDateTime getCtime() {
        return ctime;
    }

    public void setCtime(LocalDateTime ctime) {
        this.ctime = ctime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Attachment{" +
        "id=" + id +
        ", fileName=" + fileName +
        ", ext=" + ext +
        ", url=" + url +
        ", path=" + path +
        ", ctime=" + ctime +
        ", isDelete=" + isDelete +
        "}";
    }
}
