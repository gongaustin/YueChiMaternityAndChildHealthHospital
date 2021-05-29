package com.austin.common.entity.vo;

import com.austin.common.entity.Module;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: GongJun
 * @Date: Created in 15:54 2021/5/14
 */
public class ModuleVo extends Module {
    List<Module> children = new ArrayList<>();

    public List<Module> getChildren() {
        return children;
    }

    public void setChildren(List<Module> children) {
        this.children = children;
    }
}
