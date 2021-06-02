package com.austin.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 操作日志表
 * </p>
 *
 * @author AustinGJ
 * @since 2021-06-02
 */
@TableName("upms_log")
@ApiModel(value="Log对象", description="操作日志表")
public class Log implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "编号")
      @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty(value = "操作描述")
    @TableField("description")
    private String description;

    @ApiModelProperty(value = "操作用户")
    @TableField("username")
    private String username;

    @ApiModelProperty(value = "操作时间")
    @TableField("start_time")
    private Long startTime;

    @ApiModelProperty(value = "消耗时间")
    @TableField("spend_time")
    private Integer spendTime;

    @ApiModelProperty(value = "根路径")
    @TableField("base_path")
    private String basePath;

    @ApiModelProperty(value = "URI")
    @TableField("uri")
    private String uri;

    @ApiModelProperty(value = "URL")
    @TableField("url")
    private String url;

    @ApiModelProperty(value = "请求类型")
    @TableField("method")
    private String method;

    @TableField("parameter")
    private String parameter;

    @ApiModelProperty(value = "用户标识")
    @TableField("user_agent")
    private String userAgent;

    @ApiModelProperty(value = "IP地址")
    @TableField("ip")
    private String ip;

    @TableField("result")
    private String result;

    @ApiModelProperty(value = "权限值")
    @TableField("permissions")
    private String permissions;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Integer getSpendTime() {
        return spendTime;
    }

    public void setSpendTime(Integer spendTime) {
        this.spendTime = spendTime;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Log{" +
        "id=" + id +
        ", description=" + description +
        ", username=" + username +
        ", startTime=" + startTime +
        ", spendTime=" + spendTime +
        ", basePath=" + basePath +
        ", uri=" + uri +
        ", url=" + url +
        ", method=" + method +
        ", parameter=" + parameter +
        ", userAgent=" + userAgent +
        ", ip=" + ip +
        ", result=" + result +
        ", permissions=" + permissions +
        "}";
    }
}
