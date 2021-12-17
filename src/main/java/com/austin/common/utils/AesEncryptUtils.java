package com.austin.common.utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

import com.alibaba.fastjson.JSONObject;
import com.austin.common.core.constant.AESConstant;
import org.apache.commons.codec.binary.Base64;

import java.util.HashMap;
import java.util.Map;


/**
 * @Description:AES加密
 * @Author: GongJun
 * @Date: Created in 18:43 2021/8/25
 */
public class AesEncryptUtils {
    //可配置到Constant中，并读取配置文件注入,16位,自己定义
    private static final String KEY = AESConstant.AES_KEY;

    //参数分别代表 算法名称/加密模式/数据填充方式
    private static final String ALGORITHMSTR = "AES/ECB/PKCS5Padding";

    /**
     * 加密
     * @param content 加密的字符串
     * @param encryptKey key值
     * @return
     * @throws Exception
     */
    public static String encrypt(String content, String encryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);
        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptKey.getBytes(), "AES"));
        byte[] b = cipher.doFinal(content.getBytes("utf-8"));
        // 采用base64算法进行转码,避免出现中文乱码
        return Base64.encodeBase64String(b);

    }

    /**
     * 解密
     * @param encryptStr 解密的字符串
     * @param decryptKey 解密的key值
     * @return
     * @throws Exception
     */
    public static String decrypt(String encryptStr, String decryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);
        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decryptKey.getBytes(), "AES"));
        // 采用base64算法进行转码,避免出现中文乱码
        byte[] encryptBytes = Base64.decodeBase64(encryptStr);
        byte[] decryptBytes = cipher.doFinal(encryptBytes);
        return new String(decryptBytes);
    }

    public static String encrypt(String content) throws Exception {
        return encrypt(content, KEY);
    }
    public static String decrypt(String encryptStr) throws Exception {
        return decrypt(encryptStr, KEY);
    }


    public static void main(String[] args) throws Exception {
        Map map=new HashMap<String,String>();
        map.put("key","value");
        map.put("中文","汉字");
        String content = JSONObject.toJSONString(map);
        System.out.println("加密前：" + content);

        String encrypt = encrypt(content, KEY);
        System.out.println("加密后：" + encrypt);

        String decrypt = decrypt("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", KEY);
        System.out.println("解密后：" + decrypt);
    }

}
