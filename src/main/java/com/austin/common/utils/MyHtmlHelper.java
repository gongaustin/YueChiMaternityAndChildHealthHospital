package com.austin.common.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @Description:
 * @Author: GongJun
 * @Date: Created in 20:26 2021/7/4
 */
public class MyHtmlHelper {
    public static String subHtmlText (String content,int maxLength){
        if(content == null) return "...";
        Document document = Jsoup.parse(content);
        content = document.text();
        int l = content.length();
        int sub = Math.min(l, maxLength);
        return  content.substring(0,sub)+"...";
    }
}
