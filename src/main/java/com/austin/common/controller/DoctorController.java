package com.austin.common.controller;


import com.austin.common.core.bean.Result;
import com.austin.common.entity.Doctor;
import com.austin.common.service.IDoctorService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author AustinGJ
 * @since 2021-03-18
 */
@RestController
@RequestMapping("/doctor")
@Api("医生前端控制器")
public class DoctorController {


    @Autowired
    private IDoctorService service;

    //分页查询
    @ApiOperation(value = "分页查询医生", notes = "分页查询医生")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "query", name = "current", value = "当前页面", required = true, dataType = "int"),
                    @ApiImplicitParam(paramType = "query", name = "size", value = "分页大小", required = true, dataType = "int"),
                    @ApiImplicitParam(paramType = "query", name = "isDelete", value = "删除标识符", required = false, dataType = "int"),
            }
            )
    @GetMapping("/selectByPage")
    private Result getDeptByPage(@RequestParam(defaultValue = "1") Integer current,@RequestParam(defaultValue = "10") Integer size, String keyword, Integer isDelete) {
        Page<Doctor> page = new Page<>();
        page.setCurrent(current);
        page.setSize(size);
        QueryWrapper<Doctor> ew = new QueryWrapper();
        if (StringUtils.isNotBlank(keyword)) {
            ew.and(wrapper -> wrapper.like("name", keyword).or().like("title", keyword).or().like("special_talent", keyword));
        }
        if (null != isDelete) {
            ew.eq("is_delete", isDelete);
        }
        ew.orderByDesc("ctime");
        page = service.page(page, ew);
        return Result.success(page);
    }


    //ID单查
    @ApiOperation(value = "ID查询医生", notes = "ID查询医生")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "id", value = "查询ID", required = true, dataType = "String"),})
    @GetMapping(value = "/selectById", params = {"id"})
    private Result getDoctorByID(@NotBlank String id) {
        Doctor dr = this.service.getById(id);
        return Result.success(dr);
    }


}

