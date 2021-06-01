package com.austin.common.mapper;

import com.austin.common.entity.Article;
import com.austin.common.entity.vo.ArticleVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 新闻资讯列表 Mapper 接口
 * </p>
 *
 * @author AustinGJ
 * @since 2021-03-18
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

    Page<ArticleVo> selectVoPage(Page page, QueryWrapper ew);

}
