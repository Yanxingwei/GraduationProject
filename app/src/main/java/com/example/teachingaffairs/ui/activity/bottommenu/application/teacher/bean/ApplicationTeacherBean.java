package com.example.teachingaffairs.ui.activity.bottommenu.application.teacher.bean;

/**
 * Created by 闫星位 on 2018/2/6.
 */

public class ApplicationTeacherBean {

    /**
     * 教师监考安排set以及get方法
     * textbook_picture 书本照片
     * course_name 课程名称
     * exam_date 考试日期
     * exam_time 考试具体时间
     * exam_address 考试地点
     */
    private int textbook_picture;
    private String course_name;
    private String exam_date;
    private String exam_time;
    private String exam_address;

    public ApplicationTeacherBean(int textbook_picture,String course_name,String exam_date,String exam_time,String exam_address){
        this.textbook_picture = textbook_picture;
        this.course_name = course_name;
        this.exam_date = exam_date;
        this.exam_time = exam_time;
        this.exam_address = exam_address;
    }
    public int getTextbook_picture() {
        return textbook_picture;
    }

    public String getCourse_name() {
        return course_name;
    }

    public String getExam_date() {
        return exam_date;
    }

    public String getExam_time() {
        return exam_time;
    }

    public String getExam_address() {
        return exam_address;
    }

}
