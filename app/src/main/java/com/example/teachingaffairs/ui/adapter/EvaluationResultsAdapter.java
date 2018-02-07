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
 * Created by 闫星位 on 2018/2/7.
 */

public class EvaluationResultsAdapter extends BaseAdapter {
    private List<ApplicationTeacherBean> data;
    private LayoutInflater inflater;
    public EvaluationResultsAdapter(Context mContext,List<ApplicationTeacherBean> data){
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
        private ImageView book_picture;
        private TextView course_name,exam_time,evaluation_results;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.teacher_evaluation_results_item,null);
            holder = new ViewHolder();
            holder.book_picture = (ImageView) convertView.findViewById(R.id.book_picture);
            holder.course_name = (TextView) convertView.findViewById(R.id.course_name);
            holder.exam_time = (TextView) convertView.findViewById(R.id.exam_time);
            holder.evaluation_results = (TextView) convertView.findViewById(R.id.evaluation_results);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.book_picture.setBackgroundResource(data.get(position).getBook_picture());
        holder.course_name.setText(data.get(position).getBook_name());
        holder.exam_time.setText(data.get(position).getCourse_exam_time());
        holder.evaluation_results.setText(data.get(position).getEvaluation_results()+"分");
        return convertView;
    }
}
