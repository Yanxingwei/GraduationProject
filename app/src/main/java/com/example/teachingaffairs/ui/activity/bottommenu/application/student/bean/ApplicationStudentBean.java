package com.example.teachingaffairs.ui.activity.bottommenu.application.student.bean;

/**
 * Created by 闫星位 on 2018/1/26.
 */

public class ApplicationStudentBean {
    private String mineSchedule;
    private int textbook_picture;
    private String textbook_name,teacher_name,time,address;
    public String itemChild;
    public String rb_verygood;
    public String rb_good;
    public String rb_justsoso;
    public String rb_poor;
    public String check;

    public ApplicationStudentBean(String mineSchedule){
        this.mineSchedule = mineSchedule;
    }
    public ApplicationStudentBean(int textbook_picture, String textbook_name, String teacher_name, String time, String address){
        this.textbook_picture = textbook_picture;
        this.textbook_name = textbook_name;
        this.teacher_name = teacher_name;
        this.time = time;
        this.address = address;
    }
    public ApplicationStudentBean(String itemChild, String rb_verygood, String rb_good, String rb_justsoso, String rb_poor, String check){
        this.itemChild = itemChild;
        this.rb_verygood = rb_verygood;
        this.rb_good = rb_good;
        this.rb_justsoso = rb_justsoso;
        this.rb_poor = rb_poor;
        this.check = check;
    }
    public ApplicationStudentBean(int textbook_picture, String textbook_name, String teacher_name){
        this.textbook_picture = textbook_picture;
        this.textbook_name = textbook_name;
        this.teacher_name = teacher_name;
    }
    public String getMineSchedule(){
        return mineSchedule;
    }

    public int getTextbook_picture() {
        return textbook_picture;
    }

    public String getTextbook_name() {
        return textbook_name;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public String getTime() {
        return time;
    }

    public String getAddress() {
        return address;
    }

    public String getItemChild() {
        return itemChild;
    }
    public String getRb_verygood() {
        return rb_verygood;
    }

    public String getRb_good() {
        return rb_good;
    }

    public String getRb_justsoso() {
        return rb_justsoso;
    }

    public String getRb_poor() {
        return rb_poor;
    }

    private String course_name,course_time,course_type,total_points,course_points,course_selection_type,evaluation_mode,remark;

    public ApplicationStudentBean(String course_name, String course_time, String course_type, String total_points,
                                  String course_points, String course_selection_type, String evaluation_mode, String remark){
        this.course_name = course_name;
        this.course_time = course_time;
        this.course_type = course_type;
        this.total_points = total_points;
        this.course_points = course_points;
        this.course_selection_type = course_selection_type;
        this.evaluation_mode = evaluation_mode;
        this.remark = remark;
    }
    public String getCourse_name() {
        return course_name;
    }

    public String getCourse_time() {
        return course_time;
    }

    public String getCourse_type() {
        return course_type;
    }

    public String getTotal_points() {
        return total_points;
    }

    public String getCourse_points() {
        return course_points;
    }

    public String getCourse_selection_type() {
        return course_selection_type;
    }

    public String getEvaluation_mode() {
        return evaluation_mode;
    }

    public String getRemark() {
        return remark;
    }
}
