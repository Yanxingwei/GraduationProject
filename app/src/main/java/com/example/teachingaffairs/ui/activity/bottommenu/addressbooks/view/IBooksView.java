package com.example.teachingaffairs.ui.activity.bottommenu.addressbooks.view;

import com.example.teachingaffairs.ui.activity.bottommenu.addressbooks.bean.BooksBean;

import java.util.List;

/**
 * Created by 闫星位 on 2018/1/19.
 */

public interface IBooksView {
    void showdata(List<BooksBean> data);
    void showtitle(String title);
}
