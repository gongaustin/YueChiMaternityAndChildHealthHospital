package com.austin.common.controller;


import com.austin.common.core.bean.CodeMsg;
import com.austin.common.core.bean.Result;
import com.austin.common.entity.Article;
import com.austin.common.entity.Doctor;
import com.austin.common.entity.Feedback;
import com.austin.common.entity.vo.ArticleVo;
import com.austin.common.service.IFeedbackService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 意见收集 前端控制器
 * </p>
 *
 * @author AustinGJ
 * @since 2021-06-02
 */
@RestController
@RequestMapping("/feedback")
@Api("意见收集前端控制器")
public class FeedbackController {

    @Autowired
    IFeedbackService service;


    //分页查询
    @ApiOperation(value = "查询意见(分页、ID、模糊)", notes = "查询意见(分页、ID、模糊)")
    /**
     * paramType = "query"必须加上，否则前端调试无法传参
     * */
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "query", name = "current", value = "当前页面", required = false, dataType = "int"),
                    @ApiImplicitParam(paramType = "query", name = "size", value = "分页大小", required = false, dataType = "int"),
                    @ApiImplicitParam(paramType = "query", name = "keyword", value = "模糊查询关键字", required = false, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "id", value = "ID", required = false, dataType = "String"),
            }
    )
    @GetMapping("/list")
    private Result getArticleByPage(@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size, String keyword,String id) {
        Page<Feedback> page = new Page<>();
        page.setCurrent(current);
        page.setSize(size);
        QueryWrapper<Feedback> ew = new QueryWrapper<>();
        if (StringUtils.isNotBlank(keyword)) {
            ew.and(wrapper -> wrapper.like("name", keyword).or().like("content", keyword));
        }
        if(StringUtils.isNotBlank(id)){
            ew.eq("id",id);
        }
        ew.orderByDesc("ctime");
        page = this.service.page(page,ew);
        return Result.success(page);
    }



    //ID逻辑删除


    @ApiOperation(value = "新增意见", notes = "新增意见")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "query", name = "name", value = "姓名", required = true, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "contact", value = "联系方式", required = true, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "content", value = "反馈内容", required = true, dataType = "String"),
            }
    )
    @PostMapping(value = "/add", params = {"name","contact","content"})
    private Result save(@NotNull Feedback feedback) {
        boolean b = this.service.save(feedback);
        if(b) return Result.message(CodeMsg.OPERATE_SUCCESS);
        return Result.message(CodeMsg.OPERATE_FAIL);
    }


    @ApiOperation(value = "处理结果", notes = "处理结果")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "query", name = "id", value = "ID", required = true, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "result", value = "处理结果", required = true, dataType = "String"),
            }
    )
    @PostMapping(value = "/update", params = {"id"})
    private Result updateById(@NotNull Feedback feedback) {
        boolean b = this.service.updateById(feedback);
        if(b) return Result.message(CodeMsg.OPERATE_SUCCESS);
        return Result.message(CodeMsg.OPERATE_FAIL);
    }

    //ID物理删除
    @ApiOperation(value = "删除意见", notes = "删除意见")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "query", name = "id", value = "ID", required = true, dataType = "String"),
            }
    )
    @PostMapping(value = "/deletePhysicsById", params = {"id"})
    private Result deletePhysicsById(@NotBlank String id) {
        boolean b = this.service.removeById(id);
        if(b) return Result.message(CodeMsg.OPERATE_SUCCESS);
        return Result.message(CodeMsg.OPERATE_FAIL);
    }
}

