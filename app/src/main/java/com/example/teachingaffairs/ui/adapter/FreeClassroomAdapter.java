package com.example.teachingaffairs.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.bottommenu.application.bean.ApplicationBean;

import java.util.List;

/**
 * Created by 闫星位 on 2018/1/25.
 */

public class FreeClassroomAdapter extends BaseAdapter{

    private List<ApplicationBean> datalist;
    private LayoutInflater inflater;
    public FreeClassroomAdapter(Context mContext, List<ApplicationBean> datalist){
        this.datalist = datalist;
        this.inflater = LayoutInflater.from(mContext);
    }
    @Override
    public int getCount() {
        return datalist.size();
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
        private TextView freeclassroom;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.app_app_free_classroom_item,null);
            holder.freeclassroom = (TextView) convertView.findViewById(R.id.freeclassroom);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.freeclassroom.setText(datalist.get(position).getMineSchedule());
        return convertView;
    }
}
