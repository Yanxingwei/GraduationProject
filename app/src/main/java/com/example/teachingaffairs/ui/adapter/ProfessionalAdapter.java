package com.example.teachingaffairs.ui.adapter;

import android.content.Context;
import android.util.Log;
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

public class ProfessionalAdapter extends BaseAdapter {

    private ArrayList<HashMap<String,Object>> datalist = new ArrayList<HashMap<String, Object>>();
    private LayoutInflater inflater;
    public ProfessionalAdapter(Context mContext, ArrayList<HashMap<String, Object>> datalist){
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
        private TextView college_logo;//学院logo
        private TextView college_name;//学院名称
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Log.e("position",String.valueOf(position));
        ViewHolder holder = null;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.common_gridview_item,null);
            holder.college_logo = (TextView) convertView.findViewById(R.id.college_logo);
            holder.college_name = (TextView) convertView.findViewById(R.id.college_name);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.college_logo.setBackgroundResource((Integer) datalist.get(position).get("college_logo"));
        holder.college_name.setText((String) datalist.get(position).get("name"));
        return convertView;
    }
}