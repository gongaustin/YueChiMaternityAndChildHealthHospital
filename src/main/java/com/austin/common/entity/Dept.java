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
 * 科室
 * </p>
 *
 * @author AustinGJ
 * @since 2021-06-02
 */
@TableName("upms_dept")
@ApiModel(value="Dept对象", description="科室")
public class Dept implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "UUID")
      @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty(value = "科室编号")
    @TableField("dept_no")
    private String deptNo;

    @ApiModelProperty(value = "科室名称")
    @TableField("dept_name")
    private String deptName;

    @ApiModelProperty(value = "科室负责人ID")
    @TableField("leader_doctor_id")
    private String leaderDoctorId;

    @ApiModelProperty(value = "科室描述")
    @TableField("description")
    private String description;

    @ApiModelProperty(value = "科室简介")
    @TableField("summary")
    private String summary;


    @ApiModelProperty(value = "联系电话")
    @TableField("contact")
    private String contact;

    @ApiModelProperty(value = "科室位置")
    @TableField("addr")
    private String addr;

    @ApiModelProperty(value = "创建时间")
    @TableField("ctime")
    @JsonFormat(timezone = TimeConstant.TIME_ZONE, pattern = TimeConstant.DATETIME_FORMAT)
    @DateTimeFormat(pattern = TimeConstant.DATETIME_FORMAT)
    private LocalDateTime ctime;

    @ApiModelProperty(value = "科室照片")
    @TableField("photo_url")
    private String photoUrl;

    @ApiModelProperty(value = "科室类型（临床/五大中心/医技科etc）")
    @TableField("type")
    private String type;

    @ApiModelProperty(value = "是否重点科室（0：不是；1：是）")
    @TableField("is_important")
    private Integer isImportant;

    @ApiModelProperty(value = "逻辑删除标识符")
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

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getLeaderDoctorId() {
        return leaderDoctorId;
    }

    public void setLeaderDoctorId(String leaderDoctorId) {
        this.leaderDoctorId = leaderDoctorId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public LocalDateTime getCtime() {
        return ctime;
    }

    public void setCtime(LocalDateTime ctime) {
        this.ctime = ctime;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getIsImportant() {
        return isImportant;
    }

    public void setIsImportant(Integer isImportant) {
        this.isImportant = isImportant;
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
        return "Dept{" +
        "id=" + id +
        ", deptNo=" + deptNo +
        ", deptName=" + deptName +
        ", leaderDoctorId=" + leaderDoctorId +
        ", description=" + description +
        ", summary=" + summary +
        ", contact=" + contact +
        ", addr=" + addr +
        ", ctime=" + ctime +
        ", photoUrl=" + photoUrl +
        ", type=" + type +
        ", isImportant=" + isImportant +
        ", isDelete=" + isDelete +
        ", backup=" + backup +
        "}";
    }
}
