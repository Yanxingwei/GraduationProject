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

import butterknife.Bind;

/**
 * Created by 闫星位 on 2018/2/2.
 */

public class ResultsQueryAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<ApplicationBean> datalist;

    public ResultsQueryAdapter(Context mContext, List<ApplicationBean>  datalist) {
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.app_app_results_query_item, null);
            holder.courseName = (TextView) convertView.findViewById(R.id.course_name);
            holder.time = (TextView) convertView.findViewById(R.id.time);
            holder.type = (TextView) convertView.findViewById(R.id.type);
            holder.totalPoints = (TextView) convertView.findViewById(R.id.total_points);
            holder.coursePoints = (TextView) convertView.findViewById(R.id.course_points);
            holder.courseSelectionType = (TextView) convertView.findViewById(R.id.course_selection_type);
            holder.evaluationMode = (TextView) convertView.findViewById(R.id.evaluation_mode);
            holder.remark = (TextView) convertView.findViewById(R.id.remark);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.courseName.setText(datalist.get(position).getCourse_name());
        holder.time.setText(datalist.get(position).getCourse_time());
        holder.type.setText(datalist.get(position).getCourse_type());
        holder.totalPoints.setText(datalist.get(position).getTotal_points());
        holder.coursePoints.setText(datalist.get(position).getCourse_points());
        holder.courseSelectionType.setText(datalist.get(position).getCourse_selection_type());
        holder.evaluationMode.setText(datalist.get(position).getEvaluation_mode());
        holder.remark.setText(datalist.get(position).getRemark());
        return convertView;
    }

    class ViewHolder {
        @Bind(R.id.course_name)
        TextView courseName;
        @Bind(R.id.time)
        TextView time;
        @Bind(R.id.type)
        TextView type;
        @Bind(R.id.total_points)
        TextView totalPoints;
        @Bind(R.id.course_points)
        TextView coursePoints;
        @Bind(R.id.course_selection_type)
        TextView courseSelectionType;
        @Bind(R.id.evaluation_mode)
        TextView evaluationMode;
        @Bind(R.id.remark)
        TextView remark;
    }
}
