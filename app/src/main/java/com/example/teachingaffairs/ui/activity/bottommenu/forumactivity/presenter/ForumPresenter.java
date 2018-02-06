package com.example.teachingaffairs.ui.activity.bottommenu.forumactivity.presenter;

import com.example.teachingaffairs.ui.activity.bottommenu.forumactivity.bean.ForumBean;
import com.example.teachingaffairs.ui.activity.bottommenu.forumactivity.model.ForumModel;
import com.example.teachingaffairs.ui.activity.bottommenu.forumactivity.model.IForumModel;
import com.example.teachingaffairs.ui.activity.bottommenu.forumactivity.view.IForumView;

import java.util.List;

/**
 * Created by 闫星位 on 2018/2/2.
 */

public class ForumPresenter {
    private IForumModel mForumModel;
    private IForumView forumView;
    public ForumPresenter(IForumView forumView){
        this.forumView = forumView;
        mForumModel = new ForumModel();
    }
    public void setJudge_data(String judge_data){
        mForumModel.getJudge_data(judge_data);
    }
    public void bindmv(){
        mForumModel.loadForumdata(new IForumModel.forumdataListener() {
            @Override
            public void load(List<ForumBean> data) {
                forumView.showdata(data);
            }
        });
    }
}
