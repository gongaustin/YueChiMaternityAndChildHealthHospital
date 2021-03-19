package com.austin.common.controller;


import com.austin.common.core.bean.Result;
import com.austin.common.entity.Article;
import com.austin.common.service.IArticleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @ApiOperation(value = "分页查询文章", notes = "分页查询文章")
    /**
     * paramType = "query"必须加上，否则前端调试无法传参
     * */
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "current", value = "当前页面", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "size", value = "分页大小", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "isDelete", value = "删除标识符", required = false, dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "keyword", value = "模糊查询关键字", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "type", value = "文章类型", required = false, dataType = "Integer"),
    })
    @GetMapping("/page")
    private Result getArticleByPage(Page<Article> page, String keyword, Integer type,Integer isDelete){
        QueryWrapper<Article> ew = new QueryWrapper<>();
        if(StringUtils.isNotBlank(keyword)){
            ew.and( wrapper -> wrapper.like("title",keyword).or().like("author",keyword));
        }
        if(null != type){
            ew.eq("type",type);
        }
        if(null != isDelete){
            ew.eq("is_delete",isDelete);
        }
        ew.orderByDesc("ctime");
        page = this.service.page(page,ew);
        page.getRecords().forEach(e->{e.setContent("");});
        return Result.success(page);
    }

}

