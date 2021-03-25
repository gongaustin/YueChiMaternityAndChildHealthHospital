package com.austin.common.controller;


import com.austin.common.core.bean.CodeMsg;
import com.austin.common.core.bean.Result;
import com.austin.common.core.constant.YiYuanConstant;
import com.austin.common.entity.Article;
import com.austin.common.entity.Doctor;
import com.austin.common.entity.User;
import com.austin.common.service.IUserService;
import com.austin.common.utils.Md5;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
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
@RequestMapping("/user")
@Api("管理员用户前端控制器")
public class UserController {

    @Autowired
    private IUserService service;

    //分页查询
    @ApiOperation(value = "新增管理员", notes = "新增管理员")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "query", name = "username", value = "用户名", required = true, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "password", value = "密码", required = true, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "realname", value = "真实姓名", required = true, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "cellphone", value = "联系方式", required = false, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "sex", value = "性别", required = false, dataType = "String"),

            }
    )
    @PostMapping(value = "/add", params = {"username","username","username"})

    private Result addUser(@NotNull User user) {
        QueryWrapper<User> ew = new QueryWrapper<>();
        ew.eq("username",user.getUsername());
        User userExist = this.service.getOne(ew);
        if(userExist != null) {
            return Result.message(CodeMsg.USER_ADD_ERROR);
        }
        user.setPassword(Md5.md5Encode(user.getPassword()));
        boolean result = this.service.save(user);
        if(result) return Result.message(CodeMsg.OPERATE_SUCCESS);
        return Result.message(CodeMsg.OPERATE_FAIL);
    }

    @ApiOperation(value = "分页查询管理员", notes = "分页查询管理员")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "query", name = "current", value = "当前页面", required = true, dataType = "int"),
                    @ApiImplicitParam(paramType = "query", name = "size", value = "分页大小", required = true, dataType = "int"),
            }
    )
    @GetMapping("/selectByPage")
    private Result getUserByPage(@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size, String keyword) {
        Page<User> page = new Page<>();
        page.setCurrent(current);
        page.setSize(size);
        QueryWrapper<User> ew = new QueryWrapper();
        if (StringUtils.isNotBlank(keyword)) {
            ew.and(wrapper -> wrapper.like("username", keyword).or().like("realname", keyword));
        }
        ew.orderByDesc("ctime");
        page = this.service.page(page, ew);
        return Result.success(page);
    }

    //ID单查

    @ApiOperation(value = "ID查询管理员", notes = "ID查询管理员")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "id", value = "查询ID", required = true, dataType = "String"),})
    @GetMapping(value = "/selectById", params = {"id"})

    private Result getUserByID(@NotBlank String id) {
        User ur = this.service.getById(id);
        return Result.success(ur);
    }

    //新增管理员用户

    @ApiOperation(value = "修改管理员信息", notes = "修改管理员信息")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "query", name = "id", value = "医生ID", required = true, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "username", value = "用户名", required = false, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "realname", value = "真实姓名", required = false, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "cellphone", value = "联系方式", required = false, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "sex", value = "性别", required = false, dataType = "String"),
            }
    )
    @PostMapping(value = "/update", params = {"id"})

    private Result updateById(@NotNull User user) {
        if(StringUtils.isNotBlank(user.getUsername())) {
            QueryWrapper<User> ew = new QueryWrapper();
            ew.eq("username","admin");
            User admin = this.service.getOne(ew);
            if(user.getId().equals(admin.getId())&&!StringUtils.endsWithIgnoreCase("admin",user.getUsername())){
                return Result.message(CodeMsg.ADMIN_UPDATE_ERROR);
            }
        };
        boolean result = this.service.updateById(user);
        if(result) return Result.message(CodeMsg.OPERATE_SUCCESS);
        return Result.message(CodeMsg.OPERATE_FAIL);
    }
    //ID逻辑删除


    //ID逻辑删除
    @ApiOperation(value = "删除管理员(逻辑删除)", notes = "删除管理员(逻辑删除)")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "id", value = "用户ID", required = true, dataType = "String"),})
    @PostMapping(value = "/deleteLogicById", params = {"id"})

    private Result deleteLogicById(@NotBlank String id) {
        User user = this.service.getById(id);
        if(StringUtils.endsWithIgnoreCase("admin",user.getUsername())){
            return Result.message(CodeMsg.ADMIN_DELETE_ERROR);
        }
        user.setIsDelete(1);
        boolean result = this.service.updateById(user);
        if(result) return Result.message(CodeMsg.OPERATE_SUCCESS);
        return Result.message(CodeMsg.OPERATE_FAIL);
    }


    //ID物理删除
    @ApiOperation(value = "删除管理员(物理删除)", notes = "删除管理员(物理删除)")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "query", name = "id", value = "管理员用户ID", required = true, dataType = "String"),
            }
    )
    @PostMapping(value = "/deletePhysicsById", params = {"id"})
    private Result deletePhysicsById(@NotBlank String id) {
        User user = this.service.getById(id);
        if(StringUtils.endsWithIgnoreCase("admin",user.getUsername())){
            return Result.message(CodeMsg.ADMIN_DELETE_ERROR);
        }
        boolean result = this.service.removeById(id);
        if(result) return Result.message(CodeMsg.OPERATE_SUCCESS);
        return Result.message(CodeMsg.OPERATE_FAIL);
    }

    @ApiOperation(value = "修改密码", notes = "修改密码")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "query", name = "id", value = "管理员用户ID", required = true, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "oldPassword", value = "原密码", required = true, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "newPassword", value = "新密码", required = true, dataType = "String"),
            }
    )
    @PostMapping(value = "/modifyPassword",params = {"id","oldPassword","newPassword"})

    private Result modifyPassword(@NotBlank String id,@NotBlank String oldPassword,@NotBlank String newPassword){
        User user = this.service.getById(id);
        if(user.getPassword().equals(Md5.md5Encode(oldPassword))){
            user.setPassword(Md5.md5Encode(newPassword));
            boolean result = this.service.updateById(user);
            if(result) return Result.message(CodeMsg.OPERATE_SUCCESS);
            return Result.message(CodeMsg.OPERATE_FAIL);
        }
        return Result.message(CodeMsg.MODIFY_PASSWORD_ERROR);
    }


    @ApiOperation(value = "[超管接口]重置密码(为123456)", notes = "[超管接口]重置密码(为123456)")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "query", name = "id", value = "管理员用户ID", required = true, dataType = "String"),
            }
    )
    @PostMapping(value = "/resetPassword",params = {"id"})

    private Result resetPassword(@NotBlank String id){
        User user = this.service.getById(id);
        user.setPassword(Md5.md5Encode(YiYuanConstant.RESET_PASSWORD));
        boolean result = this.service.updateById(user);
        if(result) return Result.message(CodeMsg.OPERATE_SUCCESS);
        return Result.message(CodeMsg.OPERATE_FAIL);
    }

}

