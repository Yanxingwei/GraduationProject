package com.example.teachingaffairs.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.bottommenu.application.bean.ApplicationBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 闫星位 on 2018/1/26.
 */

public class CourseSelectionAdapter extends BaseAdapter {
    private List<ApplicationBean> data = new ArrayList<>();
    private LayoutInflater inflater;
    public CourseSelectionAdapter(Context mContext, List<ApplicationBean> data){
        this.data = data;
        this.inflater = LayoutInflater.from(mContext);
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder{
        //textbooks_picture书本图片
        private ImageView textbook_picture;
        /**
         * textbook_name 课本名称
         * teacher_name 教师姓名
         * time 上课时间
         * address 上课地点
         */
        private TextView textbook_name,teacher_name,time,address;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.app_app_course_selection_item,null);
            holder.textbook_picture = (ImageView) convertView.findViewById(R.id.textbook_picture);
            holder.textbook_name = (TextView) convertView.findViewById(R.id.textbook_name);
            holder.teacher_name = (TextView) convertView.findViewById(R.id.teacher_name);
            holder.time = (TextView) convertView.findViewById(R.id.time);
            holder.address = (TextView) convertView.findViewById(R.id.address);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textbook_picture.setBackgroundResource(data.get(position).getTextbook_picture());
        holder.textbook_name.setText(data.get(position).getTextbook_name());
        holder.teacher_name.setText(data.get(position).getTeacher_name());
        holder.time.setText(data.get(position).getTime());
        holder.address.setText(data.get(position).getAddress());
        return convertView;
    }
}
