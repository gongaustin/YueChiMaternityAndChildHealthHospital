package com.austin.common.entity.vo;

import com.austin.common.entity.Article;

/**
 * @Description:
 * @Author: GongJun
 * @Date: Created in 22:27 2021/6/1
 */
public class ArticleVo extends Article {
    private String moduleName;

    private String articleAttachmentUrl;

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getArticleAttachmentUrl() {
        return articleAttachmentUrl;
    }

    public void setArticleAttachmentUrl(String articleAttachmentUrl) {
        this.articleAttachmentUrl = articleAttachmentUrl;
    }
}
