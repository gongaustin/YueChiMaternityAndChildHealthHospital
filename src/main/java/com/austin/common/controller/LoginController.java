package com.austin.common.controller;


import com.austin.common.core.bean.CodeMsg;
import com.austin.common.core.bean.Result;
import com.austin.common.entity.User;
import com.austin.common.entity.vo.ValidBase64CodeVO;
import com.austin.common.service.IUserService;
import com.austin.common.utils.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.ImmutableMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

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
public class LoginController{

    @Autowired
    public RedisTemplate redisTemplate;

    @Autowired
    public IUserService service;

    @ApiOperation(value = "登录接口", notes = "登录接口")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(paramType = "query", name = "username", value = "用户名", required = true, dataType = "String"),
                    @ApiImplicitParam(paramType = "query", name = "password", value = "密码", required = true, dataType = "String"),
            }
    )
    @PostMapping(params = {"username","password"})
    private Result login(@NotBlank String username,@NotBlank String password,String key,String captcha){

        String code = this.redisTemplate.opsForValue().get(key)+"";
        if(!StringUtils.equalsIgnoreCase(code,captcha)) return Result.message(CodeMsg.CAPTCHA_ERROR);

        QueryWrapper<User> ew = new QueryWrapper<>();
        ew.eq("username",username);
        User user = this.service.getOne(ew);
        //查询不到用户
        if(user==null) return Result.message(CodeMsg.NO_USER);
        //用户被禁用
        if(user.getIsDelete() == 1) return Result.message(CodeMsg.USER_FORBIDDEN);
        //Password
        if(!user.getPassword().equals(Md5.md5Encode(password))) return Result.message(CodeMsg.PASSWORD_ERROR);
        //认证生成
        String token = JWTUtil.sign(user.getId(), user.getUsername());
        int isAdmin = 0;
        if(StringUtils.equalsIgnoreCase("admin",username)) isAdmin = 1;
        return Result.success(ImmutableMap.of("Authorization",token,"isAdmin",isAdmin,"msg","login success!"));
    }


    @ApiOperation(value = "BASE64验证码")
    @GetMapping("/base64Code")
    public Result getCaptchaCode() {
        CaptchaUtil instance = CaptchaUtil.getInstance();
        // 验证码标识
        String key = MyRandomUtils.randomUUID();
        this.redisTemplate.opsForValue().set(key, instance.getCode(), CaptchaUtil.DEFAULT_CACHE_TIME, TimeUnit.SECONDS);
        System.out.println(instance.getCode());
        // 将图像输出到Servlet输出流中。
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            ImageIO.write(instance.getBuffImg(), "jpeg", out);
            return Result.success(new ValidBase64CodeVO(Base64Utils.encodeToString(out.toByteArray()), "image/jpeg", key));
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

}

