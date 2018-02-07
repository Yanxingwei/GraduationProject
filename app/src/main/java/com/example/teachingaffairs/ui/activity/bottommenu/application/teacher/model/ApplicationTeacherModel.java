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
            case "我的课表":
                //周一到周天第一节课
                data.add(new ApplicationTeacherBean("自动控制原理A"));
                data.add(new ApplicationTeacherBean(""));
                data.add(new ApplicationTeacherBean(""));
                data.add(new ApplicationTeacherBean(null));
                data.add(new ApplicationTeacherBean("电子系统课程设计B"));
                data.add(new ApplicationTeacherBean("通信系统概论A"));
                data.add(new ApplicationTeacherBean("自动控制原理A"));

                //周一到周天第二节课
                data.add(new ApplicationTeacherBean("自动控制原理A"));
                data.add(new ApplicationTeacherBean(""));
                data.add(new ApplicationTeacherBean(""));
                data.add(new ApplicationTeacherBean(null));
                data.add(new ApplicationTeacherBean("电子系统课程设计B"));
                data.add(new ApplicationTeacherBean(""));
                data.add(new ApplicationTeacherBean("自动控制原理A"));

                //周一到周天第三节课
                data.add(new ApplicationTeacherBean(""));
                data.add(new ApplicationTeacherBean(""));
                data.add(new ApplicationTeacherBean("自动控制原理A"));
                data.add(new ApplicationTeacherBean("自动控制原理A"));
                data.add(new ApplicationTeacherBean("电子系统课程设计A"));
                data.add(new ApplicationTeacherBean("通信系统概论B"));
                data.add(new ApplicationTeacherBean("自动控制原理A"));

                //周一到周天第四节课
                data.add(new ApplicationTeacherBean("自动控制原理A"));
                data.add(new ApplicationTeacherBean("通信系统概论B"));
                data.add(new ApplicationTeacherBean("通信系统概论B"));
                data.add(new ApplicationTeacherBean(null));
                data.add(new ApplicationTeacherBean("电子系统课程设计A"));
                data.add(new ApplicationTeacherBean("通信系统概论B"));
                data.add(new ApplicationTeacherBean("自动控制原理A"));

                //周一到周天第五节课
                data.add(new ApplicationTeacherBean("自动控制原理A"));
                data.add(new ApplicationTeacherBean(""));
                data.add(new ApplicationTeacherBean(""));
                data.add(new ApplicationTeacherBean("自动控制原理A"));
                data.add(new ApplicationTeacherBean(null));
                data.add(new ApplicationTeacherBean("通信系统概论B"));
                data.add(new ApplicationTeacherBean(""));
                listener.load(data);
                break;
            case "评教结果":
                data.add(new ApplicationTeacherBean(R.mipmap.textbook1,"大学物理","2018-2-3","97"));
                data.add(new ApplicationTeacherBean(R.mipmap.textbook2,"大学英语","2018-2-3","94"));
                data.add(new ApplicationTeacherBean(R.mipmap.textbook3,"大学数学","2018-2-3","95"));
                data.add(new ApplicationTeacherBean(R.mipmap.textbook5,"信号与系统","2018-2-3","99"));
                break;
            default:
                break;
        }
        listener.load(data);
    }
}
