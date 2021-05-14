package com.austin.common.service.impl;

import com.austin.common.entity.Module;
import com.austin.common.mapper.ModuleMapper;
import com.austin.common.service.IModuleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 模块管理 服务实现类
 * </p>
 *
 * @author AustinGJ
 * @since 2021-05-14
 */
@Service
public class ModuleServiceImpl extends ServiceImpl<ModuleMapper, Module> implements IModuleService {

}
