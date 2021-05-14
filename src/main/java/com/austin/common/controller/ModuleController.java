package com.austin.common.controller;

import com.austin.common.core.bean.CodeMsg;
import com.austin.common.core.bean.Result;
import com.austin.common.entity.Module;
import com.austin.common.service.IModuleService;
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
 * @Description:模块管理
 * @Author: GongJun
 * @Date: Created in 14:38 2021/5/6
 */
@RestController
@RequestMapping("/module")
@Api("模块前端控制器")
public class ModuleController {


    @Autowired
    private IModuleService service;

    //分页查询
    @ApiOperation(value = "分页查询科室", notes = "分页查询科室")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "query", name = "current", value = "当前页面", required = true, dataType = "int"),
                    @ApiImplicitParam(paramType = "query", name = "size", value = "分页大小", required = true, dataType = "int"),
                    @ApiImplicitParam(paramType = "query", name = "isDelete", value = "删除标识符", required = false, dataType = "int"),
            }
    )
    @GetMapping("/selectByPage")
    private Result getDeptByPage(@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size, String keyword, Integer isDelete) {
        Page<Module> page = new Page<>();
        page.setCurrent(current);
        page.setSize(size);
        QueryWrapper<Module> ew = new QueryWrapper();
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
        Module me = this.service.getById(id);
        return Result.success(me);
    }




    //ID逻辑删除
    @ApiOperation(value = "新增模块", notes = "新增模块")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "query", name = "deptName", value = "科室名", required = true, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "description", value = "科室描述", required = true, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "type", value = "科室类型", required = true, dataType = "int"),
                    @ApiImplicitParam(paramType = "query", name = "contact", value = "科室联系方式", required = true, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "leaderDoctorId", value = "负责人ID", required = true, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "isImportant", value = "是否重点科室(0:不是,1:是)", required = true, dataType = "int"),
                    @ApiImplicitParam(paramType = "query", name = "addr", value = "科室地址", required = true, dataType = "String"),
            }
    )
    @PostMapping(value = "/add", params = {"deptName","type","description"})
    private Result deleteLogicById(@NotNull Module module) {
        boolean b = this.service.save(module);
        if(b) return Result.message(CodeMsg.OPERATE_SUCCESS);
        return Result.message(CodeMsg.OPERATE_FAIL);
    }


    @ApiOperation(value = "修改科室信息", notes = "修改科室信息")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "query", name = "id", value = "文章ID", required = true, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "deptName", value = "科室名", required = false, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "description", value = "科室描述", required = false, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "type", value = "科室类型", required = false, dataType = "int"),
                    @ApiImplicitParam(paramType = "query", name = "contact", value = "科室联系方式", required = false, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "isImportant", value = "是否重点科室", required = false, dataType = "int"),
            }
    )
    @PostMapping(value = "/update", params = {"id"})
    private Result updateById(@NotNull Module module) {
        boolean b = this.service.save(module);
        if(b) return Result.message(CodeMsg.OPERATE_SUCCESS);
        return Result.message(CodeMsg.OPERATE_FAIL);
    }
    //ID逻辑删除


    //ID逻辑删除
    @ApiOperation(value = "删除科室(逻辑删除)", notes = "删除科室(逻辑删除)")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "id", value = "科室ID", required = true, dataType = "String"),})
    @PostMapping(value = "/deleteLogicById", params = {"id"})
    private Result deleteLogicById(@NotBlank String id) {
        Module module = new Module();
        module.setId(id);
        boolean b = this.service.updateById(module);
        if(b) return Result.message(CodeMsg.OPERATE_SUCCESS);
        return Result.message(CodeMsg.OPERATE_FAIL);
    }


    //ID物理删除
    @ApiOperation(value = "删除科室(物理删除)", notes = "删除科室(物理删除)")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "query", name = "id", value = "科室ID", required = true, dataType = "String"),
            }
    )
    @PostMapping(value = "/deletePhysicsById", params = {"id"})
    private Result deletePhysicsById(@NotBlank String id) {
        boolean b = this.service.removeById(id);
        if(b) return Result.message(CodeMsg.OPERATE_SUCCESS);
        return Result.message(CodeMsg.OPERATE_FAIL);
    }

}
