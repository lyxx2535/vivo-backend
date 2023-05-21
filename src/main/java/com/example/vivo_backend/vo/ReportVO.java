package com.example.vivo_backend.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class ReportVO {

    @ApiModelProperty(value = "存储tagVO的列表", example = "略")
    private List<TagVO> tagReport;
}
