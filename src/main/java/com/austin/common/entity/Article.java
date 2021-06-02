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
 * 新闻资讯列表
 * </p>
 *
 * @author AustinGJ
 * @since 2021-06-02
 */
@TableName("busi_article")
@ApiModel(value="Article对象", description="新闻资讯列表")
public class Article implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "UUID")
      @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty(value = "标题")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "所属模块ID")
    @TableField("module_id")
    private String moduleId;

    @ApiModelProperty(value = "作者")
    @TableField("author")
    private String author;

    @ApiModelProperty(value = "内容")
    @TableField("content")
    private String content;

    @ApiModelProperty(value = "发表时间")
    @TableField("ctime")
    @JsonFormat(timezone = TimeConstant.TIME_ZONE, pattern = TimeConstant.DATETIME_FORMAT)
    @DateTimeFormat(pattern = TimeConstant.DATETIME_FORMAT)
    private LocalDateTime ctime;

    @ApiModelProperty(value = "附件UUID（只能上传一个附件，多个附件请打包）")
    @TableField("article_attachment_id")
    private String articleAttachmentId;

    @ApiModelProperty(value = "逻辑删除（1为删除状态，0为未删除状态）")
    @TableField("is_delete")
    private Integer isDelete;

    @ApiModelProperty(value = "备用字段")
    @TableField("backup")
    private String backup;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCtime() {
        return ctime;
    }

    public void setCtime(LocalDateTime ctime) {
        this.ctime = ctime;
    }

    public String getArticleAttachmentId() {
        return articleAttachmentId;
    }

    public void setArticleAttachmentId(String articleAttachmentId) {
        this.articleAttachmentId = articleAttachmentId;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getBackup() {
        return backup;
    }

    public void setBackup(String backup) {
        this.backup = backup;
    }

    @Override
    public String toString() {
        return "Article{" +
        "id=" + id +
        ", title=" + title +
        ", moduleId=" + moduleId +
        ", author=" + author +
        ", content=" + content +
        ", ctime=" + ctime +
        ", articleAttachmentId=" + articleAttachmentId +
        ", isDelete=" + isDelete +
        ", backup=" + backup +
        "}";
    }
}
