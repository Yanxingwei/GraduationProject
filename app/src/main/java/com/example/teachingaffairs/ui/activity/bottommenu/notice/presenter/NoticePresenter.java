package com.example.teachingaffairs.ui.activity.bottommenu.notice.presenter;

import com.example.teachingaffairs.ui.activity.bottommenu.notice.bean.NoticeBean;
import com.example.teachingaffairs.ui.activity.bottommenu.notice.model.INoticeModel;
import com.example.teachingaffairs.ui.activity.bottommenu.notice.model.NoticeModel;
import com.example.teachingaffairs.ui.activity.bottommenu.notice.view.INoticeView;

import java.util.List;

/**
 * Created by 闫星位 on 2018/1/23.
 */

public class NoticePresenter {
    private INoticeModel mNoticeModel;
    private INoticeView mNoticeView;
    public NoticePresenter(INoticeView mNoticeView){
        this.mNoticeView = mNoticeView;
        this.mNoticeModel = new NoticeModel();
    }
    public  void bindmv(){
        mNoticeModel.dataListener(new INoticeModel.loadListener() {
            @Override
            public void load(List<NoticeBean> data) {
                mNoticeView.showdata(data);
            }
        });
    }
}
