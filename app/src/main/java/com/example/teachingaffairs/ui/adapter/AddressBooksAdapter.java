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

public class AddressBooksAdapter extends BaseAdapter{

    private ArrayList<HashMap<String,Object>> datalist;
    private LayoutInflater inflater;
    private int last_position;
    public AddressBooksAdapter(Context mContext,ArrayList<HashMap<String,Object>> datalist){
        this.datalist = datalist;
        this.inflater = LayoutInflater.from(mContext);
        last_position = datalist.size();
    }
    @Override
    public int getCount() {
        return last_position;
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
        private TextView college_number;//学院专业数量
        private TextView college_go;//右箭头logo
        private View college_underline;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.app_address_books_item,null);

            holder.college_go = convertView.findViewById(R.id.college_go);
            holder.college_logo = convertView.findViewById(R.id.college_logo);
            holder.college_name = convertView.findViewById(R.id.college_name);
            holder.college_number = convertView.findViewById(R.id.college_number);
            holder.college_underline = convertView.findViewById(R.id.college_underline);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.college_logo.setBackgroundResource((Integer) datalist.get(position).get("college_logo"));
        holder.college_name.setText((String) datalist.get(position).get("name"));
        holder.college_number.setText((String) datalist.get(position).get("number"));
        holder.college_go.setBackgroundResource((Integer) datalist.get(position).get("college_go"));

        if(last_position - 1 == position ){
            holder.college_underline.setVisibility(View.GONE);
        }else{
            holder.college_underline.setVisibility(View.VISIBLE);
        }

        return convertView;
    }
}
