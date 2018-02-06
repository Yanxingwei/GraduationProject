package com.example.teachingaffairs.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.bottommenu.notice.bean.NoticeBean;

import java.util.List;

/**
 * Created by 闫星位 on 2018/1/23.
 */

public class NoticeAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<NoticeBean> data;
    public NoticeAdapter(Context mContext,List<NoticeBean> data){
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
        private TextView oldetime;//年月日
        private TextView notice_time;//具体时间
        private TextView notice_content;//公告内容
        private TextView notice_source;//公告来源
        private TextView notice_type;//公告来源
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.app_notice_item,null);
            holder.oldetime = (TextView) convertView.findViewById(R.id.old_time);
            holder.notice_content = (TextView) convertView.findViewById(R.id.notice_content);
            holder.notice_source = (TextView) convertView.findViewById(R.id.notice_source);
            holder.notice_time = (TextView) convertView.findViewById(R.id.notice_time);
            holder.notice_type = (TextView) convertView.findViewById(R.id.notice_type);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.notice_time.setText(data.get(position).getNotice_time());
        holder.notice_source.setText(data.get(position).getNotice_source());
        holder.notice_content.setText(data.get(position).getNotice_content());
        holder.oldetime.setText(data.get(position).getOldertime());
        holder.notice_type.setText(data.get(position).getType());
        return convertView;
    }
}
