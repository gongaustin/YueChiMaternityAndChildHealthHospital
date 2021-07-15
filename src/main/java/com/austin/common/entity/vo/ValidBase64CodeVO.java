package com.austin.common.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: GongJun
 * @Date: Created in 11:06 2021/7/15
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ValidBase64CodeVO {
    @ApiModelProperty("base64后的图片验证码")
    private String base64;

    @ApiModelProperty("图片媒体类型")
    private String mediaType;

    @ApiModelProperty("图片验证码的key")
    private String validateKey;
}
