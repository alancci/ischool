package com.project.ischool.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
/**
 * @desc 系统角色
 * @author  alancci
 * @date   2020/9/18 16:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Integer roleId;
    private String roleName;
    private List<Perm> perm;
}