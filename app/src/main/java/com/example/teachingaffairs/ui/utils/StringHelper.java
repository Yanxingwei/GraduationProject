package com.example.teachingaffairs.ui.utils;

/**
 * Created by 闫星位 on 2018/1/17.
 */

public class StringHelper {
    public static Boolean isBlank(String s){
        if(s == null || s.trim().equals("")) {
            return true;
        }else{
            return false;
        }
    }
    public static Boolean isNoBlank(String s){
        return !isBlank(s);
    }
}
