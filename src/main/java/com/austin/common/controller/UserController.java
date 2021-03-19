package com.austin.common.controller;


import com.austin.common.core.bean.Result;
import com.austin.common.entity.User;
import com.austin.common.service.IUserService;
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
 * 网站维护人员表 前端控制器
 * </p>
 *
 * @author AustinGJ
 * @since 2021-03-18
 */
@RestController
@RequestMapping("/user")
@Api("用户前端控制器")
public class UserController {

    @Autowired
    private IUserService service;

    //分页查询
    @GetMapping("/selectByPage")
    private Result getDeptByPage(Page<User> page, String keyword){

        if(StringUtils.isNotBlank(keyword)){
            QueryWrapper<User> ew = new QueryWrapper();
            ew.and( wrapper -> wrapper.like("username",keyword).or().like("realname",keyword));
            page = service.page(page,ew);
        }else{
            page = service.page(page);
        }
        return Result.success(page);
    }

}

