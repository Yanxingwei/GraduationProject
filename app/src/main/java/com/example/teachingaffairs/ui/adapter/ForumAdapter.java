package com.example.teachingaffairs.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.bottommenu.forumactivity.bean.ForumBean;

import java.util.List;

/**
 * Created by 闫星位 on 2018/1/12.
 */

public class ForumAdapter extends BaseAdapter {
    private List<ForumBean> datalist;
    private LayoutInflater inflater;
    public ForumAdapter(Context mContext, List<ForumBean> datalist){
        this.datalist = datalist;
        this.inflater =LayoutInflater.from(mContext);
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
        private ImageView head_picture;
        private ImageView content_picture;
        private TextView user_name;
        private TextView content_text;
        private TextView release_time;
        private TextView discuss_number;
        private View forum_underline;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.app_forum_item,null);
            holder.head_picture = (ImageView) convertView.findViewById(R.id.head_picture);
            holder.content_picture = (ImageView) convertView.findViewById(R.id.content_picture);
            holder.content_text = (TextView) convertView.findViewById(R.id.content_text);
            holder.user_name = (TextView) convertView.findViewById(R.id.user_name);
            holder.release_time = (TextView) convertView.findViewById(R.id.release_time);
            holder.discuss_number = (TextView) convertView.findViewById(R.id.discuss_number);
            holder.forum_underline = (View) convertView.findViewById(R.id.forum_underline);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.head_picture.setBackgroundResource(datalist.get(position).getHead_picture());
        holder.content_picture.setBackgroundResource(datalist.get(position).getContent_picture());
        holder.content_text.setText(datalist.get(position).getContent_text());
        holder.user_name.setText(datalist.get(position).getUser_name());
        holder.release_time.setText(datalist.get(position).getRelease_time());
        holder.discuss_number.setText(datalist.get(position).getDiscuss_number());
        if(datalist.size()-1 == position){
            holder.forum_underline.setVisibility(View.GONE);
        }else{
            holder.forum_underline.setVisibility(View.VISIBLE);
        }
        return convertView;
    }
}