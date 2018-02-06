package com.example.teachingaffairs.ui.activity.bottommenu.forumactivity.model;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.bottommenu.forumactivity.bean.ForumBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 闫星位 on 2018/2/2.
 */

public class ForumModel implements IForumModel{

    private String judge_data;
    private List<ForumBean> data = new ArrayList<>();

    @Override
    public void getJudge_data(String judge_data) {
        this.judge_data = judge_data;
    }

    @Override
    public void loadForumdata(forumdataListener listener) {
        switch(judge_data){
            case "帖子列表":
                data.add(new ForumBean(R.mipmap.aaa,R.mipmap.aaaa,"闫星位","啦啦啦啦啦阿里拉阿拉啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦","2018-2-5","0"));
                data.add(new ForumBean(R.mipmap.aaa,R.mipmap.aaaa,"闫星位","啦啦啦啦啦阿里拉阿拉啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦","2018-2-5","0"));
                data.add(new ForumBean(R.mipmap.aaa,R.mipmap.aaaa,"闫星位","啦啦啦啦啦阿里拉阿拉啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦","2018-2-5","0"));
                data.add(new ForumBean(R.mipmap.aaa,R.mipmap.aaaa,"闫星位","啦啦啦啦啦阿里拉阿拉啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦","2018-2-5","0"));
                data.add(new ForumBean(R.mipmap.aaa,R.mipmap.aaaa,"闫星位","啦啦啦啦啦阿里拉阿拉啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦","2018-2-5","0"));
                data.add(new ForumBean(R.mipmap.aaa,R.mipmap.aaaa,"闫星位","啦啦啦啦啦阿里拉阿拉啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦","2018-2-5","0"));
                break;
        }
        listener.load(data);
    }
}
