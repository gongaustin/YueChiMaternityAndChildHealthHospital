package com.austin.common.controller;


import com.austin.common.core.bean.Result;
import com.austin.common.entity.Dept;
import com.austin.common.service.IDeptService;
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

import javax.validation.constraints.NotBlank;

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
    @ApiOperation(value = "分页查询部门", notes = "分页查询部门")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "current", value = "当前页面", required = true, dataType = "Integer"), @ApiImplicitParam(paramType = "query", name = "size", value = "分页大小", required = true, dataType = "Integer"), @ApiImplicitParam(paramType = "query", name = "isDelete", value = "删除标识符", required = false, dataType = "Integer"),})
    @GetMapping("/selectByPage")
    private Result getDeptByPage(Page<Dept> page, String keyword, Integer isDelete) {

        QueryWrapper<Dept> ew = new QueryWrapper();
        if (StringUtils.isNotBlank(keyword)) {
            ew.and(wrapper -> wrapper.like("dept_name", keyword).or().like("description", keyword));
        }
        if (null != isDelete) {
            ew.eq("is_delete", isDelete);
        }
        ew.orderByDesc("ctime");
        page = service.page(page);

        return Result.success(page);
    }


    //ID单查
    @ApiOperation(value = "ID查询科室", notes = "ID查询科室")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "id", value = "查询ID", required = true, dataType = "String"),})
    @GetMapping(value = "/selectById", params = {"id"})
    private Result getDoctorByID(@NotBlank String id) {
        Dept dt = this.service.getById(id);
        return Result.success(dt);
    }

}

