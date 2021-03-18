package com.austin.common.mapper;

import com.austin.common.entity.Doctor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author AustinGJ
 * @since 2021-03-18
 */
@Mapper
public interface DoctorMapper extends BaseMapper<Doctor> {

}
