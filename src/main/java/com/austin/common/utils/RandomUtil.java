package com.austin.common.utils;

import java.util.UUID;

/**
 * @Description:随机数生成工具
 * @Author: GongJun
 * @Date: Created in 14:41 2021/6/2
 */
public class RandomUtil {
    public static String randomUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
