package com.austin.common.mapper;

import com.austin.common.entity.Feedback;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 意见收集 Mapper 接口
 * </p>
 *
 * @author AustinGJ
 * @since 2021-06-02
 */
@Mapper
public interface FeedbackMapper extends BaseMapper<Feedback> {

}
