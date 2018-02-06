package com.example.teachingaffairs.ui.activity.bottommenu.application.teacher.model;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.bottommenu.application.teacher.bean.ApplicationTeacherBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 闫星位 on 2018/2/6.
 */

public class ApplicationTeacherModel implements IApplicationTeacherModel {

    private String type;
    private List<ApplicationTeacherBean> data = new ArrayList<>();
    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void loaddata(loadListener listener) {
        switch(type){
            case "监考安排":
                data.add(new ApplicationTeacherBean(R.mipmap.textbook1,"大学语文","2018-2-15","15:30-17:30","5-401"));
                data.add(new ApplicationTeacherBean(R.mipmap.textbook2,"大学数学","2018-2-15","15:30-17:30","5-401"));
                data.add(new ApplicationTeacherBean(R.mipmap.textbook3,"大学语文","2018-2-15","15:30-17:30","5-401"));
                data.add(new ApplicationTeacherBean(R.mipmap.textbook4,"大学语文","2018-2-15","15:30-17:30","5-401"));
                data.add(new ApplicationTeacherBean(R.mipmap.textbook5,"大学语文","2018-2-15","15:30-17:30","5-401"));
                data.add(new ApplicationTeacherBean(R.mipmap.textbook1,"大学语文","2018-2-15","15:30-17:30","5-401"));
                data.add(new ApplicationTeacherBean(R.mipmap.textbook2,"大学语文","2018-2-15","15:30-17:30","5-401"));
                data.add(new ApplicationTeacherBean(R.mipmap.textbook3,"大学语文","2018-2-15","15:30-17:30","5-401"));
                data.add(new ApplicationTeacherBean(R.mipmap.textbook4,"大学语文","2018-2-15","15:30-17:30","5-401"));
                data.add(new ApplicationTeacherBean(R.mipmap.textbook5,"大学语文","2018-2-15","15:30-17:30","5-401"));
                break;
            default:
                break;
        }
        listener.load(data);
    }
}
