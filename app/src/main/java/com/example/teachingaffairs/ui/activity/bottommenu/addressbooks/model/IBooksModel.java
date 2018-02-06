package com.example.teachingaffairs.ui.activity.bottommenu.addressbooks.model;

import com.example.teachingaffairs.ui.activity.bottommenu.addressbooks.bean.BooksBean;

import java.util.List;

/**
 * Created by 闫星位 on 2018/1/19.
 */

public interface IBooksModel {
    void setCollege(String college);
    void onLoadBooksBean(loadlistener listener);
    interface loadlistener{
        void load(List<BooksBean> data);
        void loadtitle(String title);
    }
}
