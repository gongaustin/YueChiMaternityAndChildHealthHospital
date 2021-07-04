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
 * 模块管理
 * </p>
 *
 * @author AustinGJ
 * @since 2021-06-02
 */
@TableName("busi_module")
@ApiModel(value="Module对象", description="模块管理")
public class Module implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "UUID")
      @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty(value = "模块名")
    @TableField("module_name")
    private String moduleName;

    @ApiModelProperty(value = "展示优先级")
    @TableField("priority")
    private Integer priority;

    @ApiModelProperty(value = "等级")
    @TableField("level")
    private Integer level;

    @ApiModelProperty(value = "描述")
    @TableField("description")
    private String description;

    @ApiModelProperty(value = "父ID")
    @TableField("parent_id")
    private String parentId;

    @ApiModelProperty(value = "是否允许child")
    @TableField("allow_children")
    private String allowChildren;

    @ApiModelProperty(value = "预留字段")
    @TableField("backup")
    private String backup;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getAllowChildren() {
        return allowChildren;
    }

    public void setAllowChildren(String allowChildren) {
        this.allowChildren = allowChildren;
    }

    public String getBackup() {
        return backup;
    }

    public void setBackup(String backup) {
        this.backup = backup;
    }

    @Override
    public String toString() {
        return "Module{" +
        "id=" + id +
        ", moduleName=" + moduleName +
        ", priority=" + priority +
        ", level=" + level +
        ", description=" + description +
        ", parentId=" + parentId +
        ", allowChildren=" + allowChildren +
        ", backup=" + backup +
        "}";
    }
}
