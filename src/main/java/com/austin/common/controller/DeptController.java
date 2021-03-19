package com.austin.common.controller;


import com.austin.common.core.bean.Result;
import com.austin.common.entity.Article;
import com.austin.common.entity.Dept;
import com.austin.common.service.IDeptService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 科室 前端控制器
 * </p>
 *
 * @author AustinGJ
 * @since 2021-03-18
 */
@RestController
@RequestMapping("/dept")
@Api("部门前端控制器")
public class DeptController {


    @Autowired
    private IDeptService service;

    //分页查询
    @GetMapping("/page")
    private Result getDeptByPage(Page<Dept> page, String keyword){

        if(StringUtils.isNotBlank(keyword)){
            QueryWrapper<Dept> ew = new QueryWrapper();
            ew.and( wrapper -> wrapper.like("dept_name",keyword).or().like("description",keyword));
            page = service.page(page,ew);
        }else{
            page = service.page(page);
        }
        return Result.success(page);
    }

}

