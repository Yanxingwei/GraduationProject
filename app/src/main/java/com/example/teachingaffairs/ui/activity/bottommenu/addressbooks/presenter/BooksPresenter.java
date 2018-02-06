package com.example.teachingaffairs.ui.activity.bottommenu.addressbooks.presenter;

import com.example.teachingaffairs.ui.activity.bottommenu.addressbooks.bean.BooksBean;
import com.example.teachingaffairs.ui.activity.bottommenu.addressbooks.model.BooksModel;
import com.example.teachingaffairs.ui.activity.bottommenu.addressbooks.model.IBooksModel;
import com.example.teachingaffairs.ui.activity.bottommenu.addressbooks.view.IBooksView;

import java.util.List;

/**
 * Created by 闫星位 on 2018/1/19.
 */

public class BooksPresenter {
    private IBooksModel mBooksModel;
    private IBooksView mBooksView;
    public BooksPresenter(IBooksView mBooksView){
        this.mBooksView = mBooksView;
        this.mBooksModel = new BooksModel();
    }
    public void getcollege(String college){
        mBooksModel.setCollege(college);
    }
    public void bindmv(){
        mBooksModel.onLoadBooksBean(new IBooksModel.loadlistener() {
            @Override
            public void load(List<BooksBean> data) {
                mBooksView.showdata(data);
            }

            @Override
            public void loadtitle(String title) {
                mBooksView.showtitle(title);
            }
        });
    }
}
