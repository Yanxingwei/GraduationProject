package com.example.teachingaffairs.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.teachingaffairs.R;

import java.util.List;
import java.util.Map;

/**
 * Created by 闫星位 on 2018/1/2.
 */

public class PowerAdapter extends BaseAdapter {
    private LayoutInflater mInflate;
    private List<Map<String,Object>> powerList;
    public PowerAdapter(Context context,List<Map<String,Object>> powerList){
        this.powerList = powerList;
        this.mInflate = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return powerList.size();
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
        public TextView power;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        //如果缓存convertView为空，则需要创建View 
        if(convertView == null){
            holder = new ViewHolder();
            //根据自定义的Item布局加载布局
            convertView = mInflate.inflate(R.layout.list_power,null);
            holder.power = (TextView) convertView.findViewById(R.id.power);
            //将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag 
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.power.setText((String)powerList.get(position).get("power"));
        return convertView;
    }
}

