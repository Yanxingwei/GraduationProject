package com.example.teachingaffairs.ui.activity.bottommenu.addressbooks.bean;

/**
 * Created by 闫星位 on 2018/1/19.
 */

public class BooksBean {
    private String depertment,number;
    private int go_logo,head_logo;
    public BooksBean(int go_logo,int head_logo,String depertment,String number){
        this.go_logo = go_logo;
        this.head_logo = head_logo;
        this.depertment = depertment;
        this.number = number;
    }
    public int getGo_logo(){
        return go_logo;
    }
    public int getHead_logo(){
        return head_logo;
    }
    public String getDepertment(){
        return depertment;
    }
    public String getNumber(){
        return number;
    }
}
