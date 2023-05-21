package com.example.vivo_backend.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class TagVO {

    @ApiModelProperty(value = "tag名", example = "美食")
    private String tag;
    @ApiModelProperty(value = "拥有此tag的攻略/游记数量", example = "0")
    private int num;

    public void addOne(){
        num++;
    }
}
