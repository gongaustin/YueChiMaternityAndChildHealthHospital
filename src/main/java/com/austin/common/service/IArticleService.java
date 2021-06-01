package com.austin.common.service;

import com.austin.common.entity.Article;
import com.austin.common.entity.vo.ArticleVo;
import com.austin.common.entity.vo.DoctorVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 新闻资讯列表 服务类
 * </p>
 *
 * @author AustinGJ
 * @since 2021-03-18
 */
public interface IArticleService extends IService<Article> {

    Page<ArticleVo> selectVoPage(Page page, QueryWrapper ew);

}
