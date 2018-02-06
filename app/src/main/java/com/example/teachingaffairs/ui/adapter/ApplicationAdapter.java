package com.example.teachingaffairs.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.teachingaffairs.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by 闫星位 on 2018/1/12.
 */

public class ApplicationAdapter extends BaseAdapter {
    private ArrayList<HashMap<String,Object>> datalist;
    private LayoutInflater inflater;
    public ApplicationAdapter(Context mContext,ArrayList<HashMap<String,Object>> datalist){
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
        private TextView name;
        private TextView logo;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.common_gridview_item,null);
            holder.name = (TextView) convertView.findViewById(R.id.college_name);
            holder.logo = (TextView) convertView.findViewById(R.id.college_logo);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.logo.setBackgroundResource((Integer)datalist.get(position).get("logo"));
        holder.name.setText((String) datalist.get(position).get("name"));
        return convertView;
    }
}
