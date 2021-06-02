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
 * 网站维护人员表
 * </p>
 *
 * @author AustinGJ
 * @since 2021-06-02
 */
@TableName("upms_user")
@ApiModel(value="User对象", description="网站维护人员表")
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "编号")
      @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty(value = "帐号")
    @TableField("username")
    private String username;

    @ApiModelProperty(value = "密码MD5")
    @TableField("password")
    private String password;

    @ApiModelProperty(value = "姓名")
    @TableField("realname")
    private String realname;

    @ApiModelProperty(value = "头像")
    @TableField("avatar_url")
    private String avatarUrl;

    @ApiModelProperty(value = "手机")
    @TableField("cellphone")
    private String cellphone;

    @ApiModelProperty(value = "邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty(value = "性别")
    @TableField("sex")
    private String sex;

    @ApiModelProperty(value = "创建时间")
    @TableField("ctime")
    @JsonFormat(timezone = TimeConstant.TIME_ZONE, pattern = TimeConstant.DATETIME_FORMAT)
    @DateTimeFormat(pattern = TimeConstant.DATETIME_FORMAT)
    private LocalDateTime ctime;

    @ApiModelProperty(value = "人员介绍")
    @TableField("introduction")
    private String introduction;

    @ApiModelProperty(value = "科室ID")
    @TableField("dept_id")
    private String deptId;

    @ApiModelProperty(value = "职务")
    @TableField("position")
    private String position;

    @ApiModelProperty(value = "办公室电话")
    @TableField("office_phone")
    private String officePhone;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDateTime getCtime() {
        return ctime;
    }

    public void setCtime(LocalDateTime ctime) {
        this.ctime = ctime;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
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
        return "User{" +
        "id=" + id +
        ", username=" + username +
        ", password=" + password +
        ", realname=" + realname +
        ", avatarUrl=" + avatarUrl +
        ", cellphone=" + cellphone +
        ", email=" + email +
        ", sex=" + sex +
        ", ctime=" + ctime +
        ", introduction=" + introduction +
        ", deptId=" + deptId +
        ", position=" + position +
        ", officePhone=" + officePhone +
        ", isDelete=" + isDelete +
        ", backup=" + backup +
        "}";
    }
}
