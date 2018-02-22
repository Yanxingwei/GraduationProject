package com.example.teachingaffairs.ui.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 闫星位 on 2018/1/4.
 */

public class ShareHelper {
    private Context mcontext;
    public ShareHelper(Context mcontext){
        this.mcontext = mcontext;
    }

    //定义一个保存数据的方法(账号，密码)
    public void save(String username,String password){
        SharedPreferences sp = mcontext.getSharedPreferences("userdata",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.putString("username",username);
        editor.putString("password",password);
        editor.commit();
    }
    //定义一个保存数据的方法(账号)
    public void save_name(String username){
        SharedPreferences sp = mcontext.getSharedPreferences("userdata",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.putString("username",username);
        editor.commit();
    }
    //定义一个保存数据的方法(账号)
    public void save_power(String power){
        SharedPreferences sp = mcontext.getSharedPreferences("powerdata",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.putString("power",power);
        editor.commit();
    }

    //定义一个读取sp文件的方法(账号，密码)
    public Map<String,String> read(){
        SharedPreferences sp = mcontext.getSharedPreferences("userdata",Context.MODE_PRIVATE);
        SharedPreferences sp1 = mcontext.getSharedPreferences("powerdata",Context.MODE_PRIVATE);
        Map<String,String> userdata = new HashMap<String,String>();
        userdata.put("username",sp.getString("username",""));
        userdata.put("password",sp.getString("password",""));
        userdata.put("power",sp1.getString("power",""));
        return userdata;
    }

    //定义新建帖子的草稿箱
    public void save_releasepost(String title,String content){
        SharedPreferences sp = mcontext.getSharedPreferences("postdata",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.putString("title",title);
        editor.putString("content",content);
        editor.commit();
    }
    //定义读取新建帖子草稿箱内的数据
    public Map<String, String> read_releasepost(){
        SharedPreferences sp = mcontext.getSharedPreferences("postdata",Context.MODE_PRIVATE);
        Map<String,String> postdata = new HashMap<String,String>();
        postdata.put("title",sp.getString("title",""));
        postdata.put("content",sp.getString("content",""));
        return postdata;
    }

    //定义一个保存个人签名数据的方法
    public void save_sinature(String sinature){
        SharedPreferences sp = mcontext.getSharedPreferences("sinaturedata",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.putString("naturedata",sinature);
        editor.commit();
    }
    //定义读取个人签名数据的方法
    public Map<String,String> read_sinature(){
        SharedPreferences sp = mcontext.getSharedPreferences("sinaturedata",Context.MODE_PRIVATE);
        Map<String,String> sinaturedata = new HashMap<String,String>();
        sinaturedata.put("naturedata",sp.getString("naturedata",""));
        return sinaturedata;
    }
}
