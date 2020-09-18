package com.project.ischool.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @desc 系统权限路径
 * @author  alancci
 * @date   2020/9/18 16:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Perm {
    private Integer permId;
    private String permName;
    private String url;
}
