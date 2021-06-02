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
 * 
 * </p>
 *
 * @author AustinGJ
 * @since 2021-06-02
 */
@TableName("busi_doctor")
@ApiModel(value="Doctor对象", description="")
public class Doctor implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "UUID")
      @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty(value = "医生姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "医生性别")
    @TableField("sex")
    private String sex;

    @ApiModelProperty(value = "医生照片")
    @TableField("avatar_url")
    private String avatarUrl;

    @ApiModelProperty(value = "科室ID")
    @TableField("dept_id")
    private String deptId;

    @ApiModelProperty(value = "职称")
    @TableField("competent")
    private String competent;

    @ApiModelProperty(value = "职务")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "专长")
    @TableField("special_talent")
    private String specialTalent;

    @ApiModelProperty(value = "出诊时间")
    @TableField("visit_time")
    private String visitTime;

    @ApiModelProperty(value = "联系方式(手机、办公室电话)")
    @TableField("contact")
    private String contact;

    @ApiModelProperty(value = "简介")
    @TableField("description")
    private String description;

    @ApiModelProperty(value = "是否为专家（0：不是、1：是）")
    @TableField("is_specialist")
    private Integer isSpecialist;

    @ApiModelProperty(value = "创建时间")
    @TableField("ctime")
    @JsonFormat(timezone = TimeConstant.TIME_ZONE, pattern = TimeConstant.DATETIME_FORMAT)
    @DateTimeFormat(pattern = TimeConstant.DATETIME_FORMAT)
    private LocalDateTime ctime;

    @ApiModelProperty(value = "逻辑删除标识符（）")
    @TableField("is_delete")
    private Integer isDelete;


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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getCompetent() {
        return competent;
    }

    public void setCompetent(String competent) {
        this.competent = competent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSpecialTalent() {
        return specialTalent;
    }

    public void setSpecialTalent(String specialTalent) {
        this.specialTalent = specialTalent;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIsSpecialist() {
        return isSpecialist;
    }

    public void setIsSpecialist(Integer isSpecialist) {
        this.isSpecialist = isSpecialist;
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
        return "Doctor{" +
        "id=" + id +
        ", name=" + name +
        ", sex=" + sex +
        ", avatarUrl=" + avatarUrl +
        ", deptId=" + deptId +
        ", competent=" + competent +
        ", title=" + title +
        ", specialTalent=" + specialTalent +
        ", visitTime=" + visitTime +
        ", contact=" + contact +
        ", description=" + description +
        ", isSpecialist=" + isSpecialist +
        ", ctime=" + ctime +
        ", isDelete=" + isDelete +
        "}";
    }
}
