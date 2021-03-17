package com.austin.common.core.annotation;

import java.lang.annotation.*;

/**
 * @Description:自定义注解
 * @Author: GongJun
 * @Date: Created in 10:39 2021/1/21
 */
@Target(ElementType.METHOD) //注解放置的目标位置,METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME) //注解在哪个阶段执行
@Documented //生成文档
public @interface MyLog {
    String value() default "";
}
