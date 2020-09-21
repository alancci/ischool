package com.project.ischool.utils;

import java.util.Random;
/**
 * @desc 随机生成n位盐
 * @author  alancci
 * @date   2020/9/21 10:21
 */
public class SaltUtils {
    static char[] chars = "abcdefghijklmnuqprstuvwxyz1234567890!@#$%^&*()".toCharArray();
    public static String getSalt(int n){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < n; i++) {
            char achar = chars[new Random().nextInt(chars.length)];
            stringBuilder.append(achar);
        }
        return stringBuilder.toString();
    }
}

