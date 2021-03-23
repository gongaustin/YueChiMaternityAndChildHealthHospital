package com.austin.common.controller;


import com.austin.common.core.bean.Result;
import com.austin.common.entity.User;
import com.austin.common.service.IUserService;
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
import org.springframework.web.bind.annotation.RequestParam;
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
    @ApiOperation(value = "分页查询用户", notes = "分页查询用户")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "query", name = "current", value = "当前页面", required = true, dataType = "int"),
                    @ApiImplicitParam(paramType = "query", name = "size", value = "分页大小", required = true, dataType = "int"),
                    @ApiImplicitParam(paramType = "query", name = "isDelete", value = "删除标识符", required = false, dataType = "int"),
            }
    )
    @GetMapping("/selectByPage")
    private Result getDeptByPage(@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size, String keyword, Integer isDelete) {
        Page<User> page = new Page<>();
        page.setCurrent(current);
        page.setSize(size);
        QueryWrapper<User> ew = new QueryWrapper();
        if (StringUtils.isNotBlank(keyword)) {
            ew.and(wrapper -> wrapper.like("username", keyword).or().like("realname", keyword));
        }
        if (null != isDelete) {
            ew.eq("is_delete", isDelete);
        }
        ew.orderByDesc("ctime");
        page = service.page(page, ew);
        return Result.success(page);
    }

}

