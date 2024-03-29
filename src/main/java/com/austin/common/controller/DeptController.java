package com.austin.common.controller;


import com.austin.common.core.bean.CodeMsg;
import com.austin.common.core.bean.Result;
import com.austin.common.core.constant.IconConstant;
import com.austin.common.core.constant.YiYuanConstant;
import com.austin.common.entity.Dept;
import com.austin.common.service.IDeptService;
import com.austin.common.utils.MyHtmlHelper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    public IDeptService service;

    //分页查询
    @ApiOperation(value = "查询科室(分页、ID、模糊)", notes = "查询科室(分页、ID、模糊)")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "query", name = "current", value = "当前页面", required = false, dataType = "int"),
                    @ApiImplicitParam(paramType = "query", name = "size", value = "分页大小", required = false, dataType = "int"),
                    @ApiImplicitParam(paramType = "query", name = "isDelete", value = "删除标识符", required = false, dataType = "int"),
                    @ApiImplicitParam(paramType = "query", name = "id", value = "ID", required = false, dataType = "String"),
            }
            )
    @GetMapping("/list")
    public Result getDeptByPage(@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size, String keyword, Integer isDelete, String id) {
        Page<Dept> page = new Page<>();
        page.setCurrent(current);
        page.setSize(size);
        QueryWrapper<Dept> ew = new QueryWrapper();
        if (StringUtils.isNotBlank(keyword)) {
            ew.and(wrapper -> wrapper.like("dept_name", keyword).or().like("description", keyword));
        }
        if (null != isDelete) {
            ew.eq("is_delete", isDelete);
        }
        if(StringUtils.isNotBlank(id)){
            ew.eq("id",id);
        }
        ew.orderByDesc("ctime");
        page = service.page(page,ew);
        if(StringUtils.isBlank(id) && CollectionUtils.isNotEmpty(page.getRecords())){
            page.getRecords().forEach(e->{
                e.setDescription("");
            });
        }

        return Result.success(page);
    }


    //ID单查
//    @ApiOperation(value = "ID查询科室", notes = "ID查询科室")
//    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "id", value = "查询ID", required = true, dataType = "String"),})
//    @GetMapping(value = "/selectById", params = {"id"})
    public Result getDeptByID(@NotBlank String id) {
        Dept dt = this.service.getById(id);
        return Result.success(dt);
    }




    //ID逻辑删除
    @ApiOperation(value = "新增科室", notes = "新增科室")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "query", name = "deptName", value = "科室名", required = true, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "description", value = "科室描述", required = true, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "contact", value = "科室联系方式", required = false, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "isImportant", value = "是否重点特色科室(0:不是,1:是)", required = true, dataType = "int"),
                    @ApiImplicitParam(paramType = "query", name = "addr", value = "科室地址", required = false, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "addr", value = "科室地址", required = false, dataType = "String"),
            }
    )
    @PostMapping(value = "/add", params = {"deptName","description"})
    public Result deleteLogicById(@NotNull Dept dept) {
        String summary = MyHtmlHelper.subHtmlText(dept.getDescription(),200);
        dept.setSummary(summary);
        boolean b = this.service.save(dept);
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
    public Result updateById(@NotNull Dept dept) {
        String summary = MyHtmlHelper.subHtmlText(dept.getDescription(),200);
        dept.setSummary(summary);
        boolean b = this.service.updateById(dept);
        if(b) return Result.message(CodeMsg.OPERATE_SUCCESS);
        return Result.message(CodeMsg.OPERATE_FAIL);
    }
    //ID逻辑删除



    //ID逻辑删除
    @ApiOperation(value = "删除科室(逻辑删除)", notes = "删除科室(逻辑删除)")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "id", value = "科室ID", required = true, dataType = "String"),})
    @PostMapping(value = "/deleteLogicById", params = {"id"})
    public Result deleteLogicById(@NotBlank String id) {
        Dept dept = new Dept();
        dept.setId(id);
        dept.setIsDelete(1);
        boolean b = this.service.updateById(dept);
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
    public Result deletePhysicsById(@NotBlank String id) {
        boolean b = this.service.removeById(id);
        if(b) return Result.message(CodeMsg.OPERATE_SUCCESS);
        return Result.message(CodeMsg.OPERATE_FAIL);
    }

    @ApiOperation(value = "查询ICON", notes = "查询ICON")
    @GetMapping(value = "/selectIcons")
    public Result selectIcons(){
        return Result.success(IconConstant.getIcons());
    }


}

