package com.project.ischool.utils;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
  public static String formateDate(long date){
      SimpleDateFormat format = new SimpleDateFormat("yyyy 年 MM 月 dd 日 E HH 点 mm 分 ss 秒");
      return format.format(date);
  }
}
