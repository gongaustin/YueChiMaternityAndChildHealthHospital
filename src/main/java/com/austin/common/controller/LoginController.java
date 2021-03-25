package com.austin.common.controller;


import com.austin.common.core.bean.CodeMsg;
import com.austin.common.core.bean.Result;
import com.austin.common.core.constant.YiYuanConstant;
import com.austin.common.entity.User;
import com.austin.common.service.IUserService;
import com.austin.common.utils.JWTUtil;
import com.austin.common.utils.Md5;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 网站维护人员表 前端控制器
 * </p>
 *
 * @author AustinGJ
 * @since 2021-03-18
 */
@RestController
@RequestMapping("/login")
@Api("登录前端控制器")
public class LoginController {

    @Autowired
    private IUserService service;

    @ApiOperation(value = "登录接口", notes = "登录接口")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "query", name = "username", value = "用户名", required = true, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "password", value = "密码", required = true, dataType = "String"),
            }
    )
    @PostMapping(params = {"username","password"})
    private Result login(@NotBlank String username,@NotBlank String password){
        QueryWrapper<User> ew = new QueryWrapper();
        ew.eq("username",username);
        User user = this.service.getOne(ew);
        if(user==null) return Result.message(CodeMsg.NO_USER);
        if(!user.getPassword().equals(Md5.md5Encode(password))) return Result.message(CodeMsg.PASSWORD_ERROR);
        String token = JWTUtil.sign(user.getId(), user.getUsername());
        return Result.success(token);
    }

}

