package com.austin.common.service.impl;

import com.austin.common.entity.Feedback;
import com.austin.common.mapper.FeedbackMapper;
import com.austin.common.service.IFeedbackService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 意见收集 服务实现类
 * </p>
 *
 * @author AustinGJ
 * @since 2021-06-02
 */
@Service
public class FeedbackServiceImpl extends ServiceImpl<FeedbackMapper, Feedback> implements IFeedbackService {

}
