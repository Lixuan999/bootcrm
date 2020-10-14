package com.xuan.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 部门表
 *
 * @author xuan
 * */

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Department {
    private Integer id;
    private String departmentName;
}
