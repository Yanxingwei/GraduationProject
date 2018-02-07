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

    /**
     * 我的课表set以及get方法
     * mineSchedule 具体课程
     */
    private String mineSchedule;
    public ApplicationTeacherBean(String mineSchedule){
        this.mineSchedule = mineSchedule;
    }
    public String getMineSchedule() {
        return mineSchedule;
    }

    /**
     * 评教结果set以及get方法
     * book_picture 书本照片
     * book_name 书本名字
     * course_exam_time 考试时间
     * evaluation_results 评教结果
     */
    private int book_picture;
    private String book_name,course_exam_time,evaluation_results;
    public ApplicationTeacherBean(int book_picture,String book_name,String course_exam_time,String evaluation_results){
        this.book_picture = book_picture;
        this.book_name = book_name;
        this.course_exam_time = course_exam_time;
        this.evaluation_results = evaluation_results;
    }
    public int getBook_picture() {
        return book_picture;
    }

    public String getBook_name() {
        return book_name;
    }

    public String getCourse_exam_time() {
        return course_exam_time;
    }

    public String getEvaluation_results() {
        return evaluation_results;
    }

}
