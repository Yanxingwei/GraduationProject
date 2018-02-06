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

import java.util.List;

/**
 * Created by 闫星位 on 2018/1/29.
 * 网上评教适配器
 */

public class EvaluationTeachingAdapter extends BaseAdapter{
    private List<ApplicationBean> data;
    private LayoutInflater inflater;
    public EvaluationTeachingAdapter(Context mContext, List<ApplicationBean> data){
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
        private ImageView textbook_picture;
        private TextView textbook_name,teacher_name;
        private TextView btn_now_onClick,btn_has_onClick;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.app_app_evaluation_teaching_item,null);
            holder.textbook_picture = (ImageView) convertView.findViewById(R.id.textbook_picture);
            holder.textbook_name = (TextView) convertView.findViewById(R.id.textbook_name);
            holder.teacher_name = (TextView) convertView.findViewById(R.id.teacher_name);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }
        holder.textbook_picture.setBackgroundResource(data.get(position).getTextbook_picture());
        holder.textbook_name.setText(data.get(position).getTextbook_name());
        holder.teacher_name.setText(data.get(position).getTeacher_name());
        return convertView;
    }
}
