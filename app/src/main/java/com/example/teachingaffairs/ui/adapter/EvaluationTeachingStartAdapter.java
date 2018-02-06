package com.example.teachingaffairs.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.bottommenu.application.student.bean.ApplicationStudentBean;

import java.util.List;

/**
 * Created by 闫星位 on 2018/1/29.
 * 网上评教适配器
 */

public class EvaluationTeachingStartAdapter extends BaseExpandableListAdapter {

    private LayoutInflater inflater;
    private List<ApplicationStudentBean> itemGroup;
    private List<List<ApplicationStudentBean>> itemChild;

    public EvaluationTeachingStartAdapter(Context mContext, List<ApplicationStudentBean> itemGroup, List<List<ApplicationStudentBean>> itemChild){
        this.inflater = LayoutInflater.from(mContext);
        this.itemGroup = itemGroup;
        this.itemChild = itemChild;
    }

    @Override
    public int getGroupCount() {
        return itemGroup.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return itemChild.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return itemGroup.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return itemChild.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    static class GroupHolder{
        private TextView elv_group;
    }
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupHolder holder;
        if(convertView == null){
            holder = new GroupHolder();
            convertView = inflater.inflate(R.layout.app_app_evaluation_teaching_start_groupitem,null);
            holder.elv_group = (TextView) convertView.findViewById(R.id.elv_group);
            convertView.setTag(holder);
        }else{
            holder = (GroupHolder) convertView.getTag();
        }
        holder.elv_group.setText(itemGroup.get(groupPosition).getMineSchedule());
        return convertView;
    }
    static class ChildHolder{
        private TextView elv_child_problem;
        private RadioButton rb_Verygood,rb_good,rb_justsoso,rb_poor;
    }
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final ChildHolder holder;
        if(convertView == null){
            holder = new ChildHolder();
            convertView = inflater.inflate(R.layout.app_app_evaluation_teaching_start_childitem,null);
            holder.elv_child_problem = (TextView) convertView.findViewById(R.id.elv_child_problem);

            holder.rb_Verygood = (RadioButton) convertView.findViewById(R.id.rb_Verygood);
            holder.rb_good = (RadioButton) convertView.findViewById(R.id.rb_good);
            holder.rb_justsoso = (RadioButton) convertView.findViewById(R.id.rb_justsoso);
            holder.rb_poor = (RadioButton) convertView.findViewById(R.id.rb_poor);

            convertView.setTag(holder);
        }else{
            holder = (ChildHolder) convertView.getTag();
        }

        ApplicationStudentBean module = itemChild.get(groupPosition).get(childPosition);

        holder.elv_child_problem.setText(itemChild.get(groupPosition).get(childPosition).getItemChild());
        holder.rb_Verygood.setText(itemChild.get(groupPosition).get(childPosition).getRb_verygood());
        holder.rb_good.setText(itemChild.get(groupPosition).get(childPosition).getRb_good());
        holder.rb_justsoso.setText(itemChild.get(groupPosition).get(childPosition).getRb_justsoso());
        holder.rb_poor.setText(itemChild.get(groupPosition).get(childPosition).getRb_poor());

        initListener(holder,module);
        if(TextUtils.isEmpty(module.check)){
            holder.rb_Verygood.setButtonDrawable(R.mipmap.radiobutton_normal);
            holder.rb_good.setButtonDrawable(R.mipmap.radiobutton_normal);
            holder.rb_justsoso.setButtonDrawable(R.mipmap.radiobutton_normal);
            holder.rb_poor.setButtonDrawable(R.mipmap.radiobutton_normal);
        }else{
            judgeSelect(module.check,holder);
        }
        return convertView;
    }
    private void initListener(final ChildHolder holder, final ApplicationStudentBean module){
        holder.rb_Verygood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                module.check = "很好";
                judgeSelect(module.check,holder);
            }
        });
        holder.rb_good.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                module.check = "好";
                judgeSelect(module.check,holder);
            }
        });
        holder.rb_justsoso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                module.check = "一般";
                judgeSelect(module.check,holder);
            }
        });
        holder.rb_poor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                module.check = "差";
                judgeSelect(module.check,holder);
            }
        });
    }
    private void judgeSelect(String check,ChildHolder holder){
        if("很好".equals(check)){
            holder.rb_Verygood.setButtonDrawable(R.mipmap.radiobutton_checked);
            holder.rb_good.setButtonDrawable(R.mipmap.radiobutton_normal);
            holder.rb_justsoso.setButtonDrawable(R.mipmap.radiobutton_normal);
            holder.rb_poor.setButtonDrawable(R.mipmap.radiobutton_normal);
        }else if("好".equals(check)){
            holder.rb_Verygood.setButtonDrawable(R.mipmap.radiobutton_normal);
            holder.rb_good.setButtonDrawable(R.mipmap.radiobutton_checked);
            holder.rb_justsoso.setButtonDrawable(R.mipmap.radiobutton_normal);
            holder.rb_poor.setButtonDrawable(R.mipmap.radiobutton_normal);
        }else if("一般".equals(check)){
            holder.rb_Verygood.setButtonDrawable(R.mipmap.radiobutton_normal);
            holder.rb_good.setButtonDrawable(R.mipmap.radiobutton_normal);
            holder.rb_justsoso.setButtonDrawable(R.mipmap.radiobutton_checked);
            holder.rb_poor.setButtonDrawable(R.mipmap.radiobutton_normal);
        }else if("差".equals(check)){
            holder.rb_Verygood.setButtonDrawable(R.mipmap.radiobutton_normal);
            holder.rb_good.setButtonDrawable(R.mipmap.radiobutton_normal);
            holder.rb_justsoso.setButtonDrawable(R.mipmap.radiobutton_normal);
            holder.rb_poor.setButtonDrawable(R.mipmap.radiobutton_checked);
        }
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
