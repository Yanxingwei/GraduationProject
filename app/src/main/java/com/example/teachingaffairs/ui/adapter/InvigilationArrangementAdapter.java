package com.example.teachingaffairs.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.bottommenu.application.teacher.bean.ApplicationTeacherBean;

import java.util.List;

/**
 * Created by 闫星位 on 2018/2/2.
 */

public class InvigilationArrangementAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<ApplicationTeacherBean> data;
    public InvigilationArrangementAdapter(Context mContext, List<ApplicationTeacherBean> data){
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
        private ImageView course_picture;
        private TextView course_name,exam_date,exam_time,exam_address;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.app_app_exam_arrangement_item,null);
            holder.course_picture = (ImageView) convertView.findViewById(R.id.course_picture);
            holder.course_name = (TextView) convertView.findViewById(R.id.course_name);
            holder.exam_date = (TextView) convertView.findViewById(R.id.exam_date);
            holder.exam_time = (TextView) convertView.findViewById(R.id.exam_time);
            holder.exam_address = (TextView) convertView.findViewById(R.id.exam_address);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.course_picture.setBackgroundResource(data.get(position).getTextbook_picture());
        holder.course_name.setText(data.get(position).getCourse_name());
        holder.exam_date.setText(data.get(position).getExam_date());
        holder.exam_time.setText(data.get(position).getExam_time());
        holder.exam_address.setText(data.get(position).getExam_address());
        return convertView;
    }
}
