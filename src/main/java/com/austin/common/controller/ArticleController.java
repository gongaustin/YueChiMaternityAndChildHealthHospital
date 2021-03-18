package com.austin.common.controller;


import com.austin.common.core.bean.Result;
import com.austin.common.entity.Article;
import com.austin.common.service.IArticleService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
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
 * 新闻资讯列表 前端控制器
 * </p>
 *
 * @author AustinGJ
 * @since 2021-03-18
 */
@RestController
@RequestMapping("/article")
@Api("文章前端控制器")
public class ArticleController {

    @Autowired
    private IArticleService service;

    //分页查询
    @GetMapping("/page")
    private Result getArticleByPage(Page page,String keyword){

        if(StringUtils.isNotBlank(keyword)){
            QueryWrapper<Article> ew = new QueryWrapper();
            ew.and( wrapper -> wrapper.like("title",keyword).or().like("author",keyword));
            page = service.page(page,ew);
        }else{
            page = service.page(page);
        }
        return Result.success(page);
    }

}

