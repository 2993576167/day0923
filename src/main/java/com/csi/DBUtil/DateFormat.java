package com.csi.DBUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
    public static final SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    //将日期准话成字符串
    public static String dateToString(Date d){
        return sdf.format(d);
    }
    //将字符串转化成日期
    public static Date stringToDate(String s){
        try {
            return sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
