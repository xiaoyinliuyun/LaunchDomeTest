package com.yangkunjian.launchmodetest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yangkunjian.launchmodetest.R;
import com.yangkunjian.launchmodetest.custom.CustomButton;
import com.yangkunjian.launchmodetest.custom.CustomTextView;

import java.util.List;

/**
 * Created by yangkunjian on 2017/9/22.
 */

public class TestAdapter extends BaseAdapter {

    private Context mContext;
    private List<String> mList;

    public TestAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public int getCount() {
        if (mList == null) return 0;
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.layout_test_item, null);
            holder.tvItem = (CustomTextView) convertView.findViewById(R.id.tv_item);
            holder.btnItem = (CustomButton) convertView.findViewById(R.id.btn_item);
            holder.llItem = (LinearLayout) convertView.findViewById(R.id.ll_item);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvItem.setText(mList.get(position));

        return convertView;
    }

    class ViewHolder {
        CustomTextView tvItem;
        CustomButton btnItem;
        LinearLayout llItem;
    }
}
