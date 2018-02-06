package com.example.teachingaffairs.ui.activity.bottommenu.application.model;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.bottommenu.application.bean.ApplicationBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 闫星位 on 2018/1/26.
 */

public class ApplicationModel implements IApplicationModel{
    private List<ApplicationBean> data = new ArrayList<>();
    private List<ApplicationBean> itemGroup = new ArrayList<>();
    private List<List<ApplicationBean>> itemChild = new ArrayList<>();
    private List<ApplicationBean> itemlist;
    private String type;
    @Override
    public void setType(String type) {
        this.type = type;
    }
    @Override
    public void loadLisntern(mineSchedule mineschedule) {

        switch(type){
            case "本周课表":
                //周一到周天第一节课
                data.add(new ApplicationBean("自动控制原理A"));
                data.add(new ApplicationBean(""));
                data.add(new ApplicationBean(""));
                data.add(new ApplicationBean(null));
                data.add(new ApplicationBean("电子系统课程设计B"));
                data.add(new ApplicationBean("通信系统概论A"));
                data.add(new ApplicationBean("自动控制原理A"));

                //周一到周天第二节课
                data.add(new ApplicationBean("自动控制原理A"));
                data.add(new ApplicationBean(""));
                data.add(new ApplicationBean(""));
                data.add(new ApplicationBean(null));
                data.add(new ApplicationBean("电子系统课程设计B"));
                data.add(new ApplicationBean(""));
                data.add(new ApplicationBean("自动控制原理A"));

                //周一到周天第三节课
                data.add(new ApplicationBean(""));
                data.add(new ApplicationBean(""));
                data.add(new ApplicationBean("自动控制原理A"));
                data.add(new ApplicationBean("自动控制原理A"));
                data.add(new ApplicationBean("电子系统课程设计A"));
                data.add(new ApplicationBean("通信系统概论B"));
                data.add(new ApplicationBean("自动控制原理A"));

                //周一到周天第四节课
                data.add(new ApplicationBean("自动控制原理A"));
                data.add(new ApplicationBean("通信系统概论B"));
                data.add(new ApplicationBean("通信系统概论B"));
                data.add(new ApplicationBean(null));
                data.add(new ApplicationBean("电子系统课程设计A"));
                data.add(new ApplicationBean("通信系统概论B"));
                data.add(new ApplicationBean("自动控制原理A"));

                //周一到周天第五节课
                data.add(new ApplicationBean("自动控制原理A"));
                data.add(new ApplicationBean(""));
                data.add(new ApplicationBean(""));
                data.add(new ApplicationBean("自动控制原理A"));
                data.add(new ApplicationBean(null));
                data.add(new ApplicationBean("通信系统概论B"));
                data.add(new ApplicationBean(""));
                mineschedule.loadminSchedule(data);
                break;
            case "选课中心":
                /**
                 * 选课中心显示的数据
                 */
                data.add(new ApplicationBean(R.mipmap.textbook1,"大学语文","闫星位","星期一、三(8、9节)","4-106"));
                data.add(new ApplicationBean(R.mipmap.textbook2,"大学数学","闫星位","星期二、四(8、9节)","5-206"));
                data.add(new ApplicationBean(R.mipmap.textbook3,"大学英语","闫星位","星期一、三(8、9节)","6-306"));
                data.add(new ApplicationBean(R.mipmap.textbook4,"大学物理","闫星位","星期二、四(8、9节)","7-406"));
                data.add(new ApplicationBean(R.mipmap.textbook5,"大学哈哈","闫星位","星期一、三(8、9节)","8-506"));
                mineschedule.loadminSchedule(data);
                break;
            case "大学英语":
                data.add(new ApplicationBean("这是大学英语，面向所有的在校大学生，有兴趣的可以参加哦。"));
                mineschedule.loadminSchedule(data);
                break;
            case "大学语文":
                data.add(new ApplicationBean("这是大学语文，面向所有的在校大学生，有兴趣的可以参加哦。"));
                mineschedule.loadminSchedule(data);
                break;
            case "大学数学":
                data.add(new ApplicationBean("这是大学数学，面向所有的在校大学生，有兴趣的可以参加哦。"));
                mineschedule.loadminSchedule(data);
                break;
            case "大学物理":
                data.add(new ApplicationBean("这是大学物理，面向所有的在校大学生，有兴趣的可以参加哦。"));
                mineschedule.loadminSchedule(data);
                break;
            case "大学哈哈":
                data.add(new ApplicationBean("这是大学哈哈，面向所有的在校大学生，有兴趣的可以参加哦。"));
                mineschedule.loadminSchedule(data);
                break;
            case"本学期课程":
                data.add(new ApplicationBean(R.mipmap.textbook1,"大学语文","某某某1"));
                data.add(new ApplicationBean(R.mipmap.textbook2,"大学数学","某某某2"));
                data.add(new ApplicationBean(R.mipmap.textbook3,"大学英语","某某某3"));
                data.add(new ApplicationBean(R.mipmap.textbook4,"大学物理","某某某4"));
                data.add(new ApplicationBean(R.mipmap.textbook5,"大学哈哈","某某某5"));
                mineschedule.loadminSchedule(data);
                break;
            case"网上评教":
                itemGroup.add(new ApplicationBean("教学内容"));
                itemGroup.add(new ApplicationBean("教学态度"));
                itemGroup.add(new ApplicationBean("教学方法"));
                itemGroup.add(new ApplicationBean("教学效果"));

                itemlist = new ArrayList<>();
                itemlist.add(new ApplicationBean("1.讲授内容符合教学大纲要求，熟悉教学内容：","很好","好","一般","差",""));
                itemlist.add(new ApplicationBean("2.条理清晰、观点正确、概念清楚、逻辑严密：","很好","好","一般","差",""));
                itemlist.add(new ApplicationBean("3.重点、难点突出，深度适宜：","很好","好","一般","差",""));
                itemlist.add(new ApplicationBean("4.理论联系实际、举例恰当且通俗易懂：","很好","好","一般","差",""));
                itemlist.add(new ApplicationBean("5.是否注意介绍本学科的前沿动态：","很好","好","一般","差",""));
                itemChild.add(itemlist);

                itemlist = new ArrayList<>();
                itemlist.add(new ApplicationBean("1.能否明显的看出课前进行了认真的备课：","很好","好","一般","差",""));
                itemlist.add(new ApplicationBean("2.为人师表，忠于职守，没有课堂上接电话、迟到、早退或随意调课、缺课现象：","很好","好","一般","差",""));
                itemChild.add(itemlist);

                itemlist = new ArrayList<>();
                itemlist.add(new ApplicationBean("1.教学方法多样灵活，讲究授课技巧和艺术，注重因材施教：","很好","好","一般","差",""));
                itemlist.add(new ApplicationBean("2.能激发学生兴趣，鼓励学生积极思考和用于创新：","很好","好","一般","差",""));
                itemlist.add(new ApplicationBean("3.授课过程不仅传授学科知识，也渗透思想品德教育：","很好","好","一般","差",""));
                itemlist.add(new ApplicationBean("4.布置预习、问题思考和讨论、参考书和文献的查阅，注重培养学生的自学能力：","很好","好","一般","差",""));
                itemChild.add(itemlist);

                itemlist = new ArrayList<>();
                itemlist.add(new ApplicationBean("1.通过本学期的学习，你能否学以致用，自学等能力有所加强：","很好","好","一般","差",""));
                itemlist.add(new ApplicationBean("2.在教学过程中得到教师的关注度：","很好","好","一般","差",""));
                itemlist.add(new ApplicationBean("3.是否觉得上课有效率，本门课程进度适中：","很好","好","一般","差",""));
                itemChild.add(itemlist);
                mineschedule.showELVdata(itemGroup,itemChild);
                break;
            case "考试安排":
                data.add(new ApplicationBean(R.mipmap.textbook1,"大学语文","2018-2-15","15:30-17:30","5-401"));
                data.add(new ApplicationBean(R.mipmap.textbook2,"大学数学","2018-2-15","15:30-17:30","5-401"));
                data.add(new ApplicationBean(R.mipmap.textbook3,"大学语文","2018-2-15","15:30-17:30","5-401"));
                data.add(new ApplicationBean(R.mipmap.textbook4,"大学语文","2018-2-15","15:30-17:30","5-401"));
                data.add(new ApplicationBean(R.mipmap.textbook5,"大学语文","2018-2-15","15:30-17:30","5-401"));
                data.add(new ApplicationBean(R.mipmap.textbook1,"大学语文","2018-2-15","15:30-17:30","5-401"));
                data.add(new ApplicationBean(R.mipmap.textbook2,"大学语文","2018-2-15","15:30-17:30","5-401"));
                data.add(new ApplicationBean(R.mipmap.textbook3,"大学语文","2018-2-15","15:30-17:30","5-401"));
                data.add(new ApplicationBean(R.mipmap.textbook4,"大学语文","2018-2-15","15:30-17:30","5-401"));
                data.add(new ApplicationBean(R.mipmap.textbook5,"大学语文","2018-2-15","15:30-17:30","5-401"));
                mineschedule.loadminSchedule(data);
                break;
            case "成绩查询":
                data.add(new ApplicationBean("大学语文","2014春","正常考试","80","2.0","必修","考试","正常"));
                data.add(new ApplicationBean("大学语文","2014春","正常考试","80","2.0","必修","考试","正常"));
                data.add(new ApplicationBean("大学语文","2014春","正常考试","80","2.0","必修","考试","正常"));
                data.add(new ApplicationBean("大学语文","2014春","正常考试","80","2.0","必修","考试","正常"));
                data.add(new ApplicationBean("大学语文","2014春","正常考试","80","2.0","必修","考试","正常"));
                data.add(new ApplicationBean("大学语文","2014春","正常考试","80","2.0","必修","考试","正常"));
                data.add(new ApplicationBean("大学语文","2014春","正常考试","80","2.0","必修","考试","正常"));
                data.add(new ApplicationBean("大学语文","2014春","正常考试","80","2.0","必修","考试","正常"));
                mineschedule.loadminSchedule(data);
                break;
            case "空闲教室":
                data.add(new ApplicationBean("5-106"));
                data.add(new ApplicationBean("5-105"));
                data.add(new ApplicationBean("5-104"));
                data.add(new ApplicationBean("5-103"));
                data.add(new ApplicationBean("5-102"));
                data.add(new ApplicationBean("5-101"));
                data.add(new ApplicationBean("5-206"));
                data.add(new ApplicationBean("5-205"));
                data.add(new ApplicationBean("5-204"));
                data.add(new ApplicationBean("5-203"));
                data.add(new ApplicationBean("5-202"));
                data.add(new ApplicationBean("5-201"));
                mineschedule.loadminSchedule(data);
                break;
            default:
                break;
        }
    }
}
