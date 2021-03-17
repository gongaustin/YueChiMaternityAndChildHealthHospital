package com.austin.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author:GongJun
 * @Date:2019/9/18
 */

public class FileTools {

    private static final Logger logger = LoggerFactory.getLogger(FileTools.class);

    private final static Map<String, String> FILE_TYPE_MAP = new HashMap<>();

    static {
        FILE_TYPE_MAP.put("D0CF11", ".doc");  //  d0cf11e0a1b11ae10000000000000000
        FILE_TYPE_MAP.put("504b03", ".docm");  // 504b03040a0000000000874ee2400000
        FILE_TYPE_MAP.put("504b03", ".docx");  // 504b03040a0000000000874ee2400000
        FILE_TYPE_MAP.put("504b03", ".dotx");  // 504b03040a0000000000874ee2400000
        FILE_TYPE_MAP.put("504b03", ".dotm"); //  504b03040a0000000000874ee2400000
        FILE_TYPE_MAP.put("D0CF11", ".xls");  //  d0cf11e0a1b11ae10000000000000000
        FILE_TYPE_MAP.put("504b03", ".xlsx"); //  504b030414000600080000002100ca84
        FILE_TYPE_MAP.put("504b03", ".xltm");  // 504b03040a0000000000874ee2400000
        FILE_TYPE_MAP.put("504b03", ".xltx");  // 504b03040a0000000000874ee2400000
        FILE_TYPE_MAP.put("D0CF11", ".xlsb");  //
        FILE_TYPE_MAP.put("D0CF11", ".xlam");  //
        FILE_TYPE_MAP.put("d0cf11e0a1b11ae10000000000000000", ".ppt");  //  d0cf11e0a1b11ae10000000000000000
        FILE_TYPE_MAP.put("504b030414000600080000002100a287", ".pptx");  // 504b030414000600080000002100a287
        FILE_TYPE_MAP.put("504b03", ".ppsx");  // 504b03040a0000000000874ee2400000
        FILE_TYPE_MAP.put("504b03", ".potx");  // 504b03040a0000000000874ee2400000
        FILE_TYPE_MAP.put("504b03", ".potm");  // 504b03040a0000000000874ee2400000
        FILE_TYPE_MAP.put("D0CF11", ".ppam");  //
        FILE_TYPE_MAP.put("504b03", ".ppsm");  // 504b03040a0000000000874ee2400000
        FILE_TYPE_MAP.put("255044", ".pdf");  //  255044462d312e350d0a25b5b5b5b50d  xls 另存为 255044462d312e370a25c2b3c7d80d0a
        // jpg ffd8ffe000104a464946000101010078(ppt 另存)
    }

    /**
     * 校验文件真实格式
     *
     * @param multipartFile
     * @return
     * @throws IOException
     */
    public static String getCorrectType(MultipartFile multipartFile) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = multipartFile.getInputStream();
            byte[] b = new byte[16];
            inputStream.read(b, 0, b.length);
            String headerHex = String.valueOf(bytesToHexString(b));
            // logger.info("16进制编码:" + headerHex);
            headerHex = headerHex.substring(0, 6).toUpperCase();
            String value = FILE_TYPE_MAP.get(headerHex);
            // logger.info("当前文件 headerHex == " + headerHex + ", 类型 type == " + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return "";
    }

    /**
     * 将文件头转换成16进制字符串
     *
     * @param src
     * @return 16进制字符串
     */
    private static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
}