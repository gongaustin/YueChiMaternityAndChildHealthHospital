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
 * 意见收集
 * </p>
 *
 * @author AustinGJ
 * @since 2021-06-02
 */
@TableName("busi_feedback")
@ApiModel(value="Feedback对象", description="意见收集")
public class Feedback implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "ID")
      @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty(value = "姓名/昵称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "联系方式")
    @TableField("contact")
    private String contact;

    @ApiModelProperty(value = "标题/扼要")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "内容")
    @TableField("content")
    private String content;

    @ApiModelProperty(value = "时间")
    @TableField("ctime")
    @JsonFormat(timezone = TimeConstant.TIME_ZONE, pattern = TimeConstant.DATETIME_FORMAT)
    @DateTimeFormat(pattern = TimeConstant.DATETIME_FORMAT)
    private LocalDateTime ctime;

    @ApiModelProperty(value = "处理结果记录")
    @TableField("result")
    private String result;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Feedback{" +
        "id=" + id +
        ", name=" + name +
        ", title=" + title +
        ", contact=" + contact +
        ", content=" + content +
        ", ctime=" + ctime +
        ", result=" + result +
        "}";
    }
}
