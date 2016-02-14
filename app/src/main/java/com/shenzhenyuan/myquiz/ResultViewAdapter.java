package com.shenzhenyuan.myquiz;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shenzhenyuan on 2/14/16.
 */
public class ResultViewAdapter extends BaseAdapter {
    private Activity mActivity;
    private ArrayList<String> list;

    public ResultViewAdapter(Activity activity, ArrayList<String> list){
        this.mActivity = activity;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView != null) return convertView;

        LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.content_result_row, null);

        TextView quizID = (TextView) convertView.findViewById(R.id.name);
        TextView quizResult = (TextView) convertView.findViewById(R.id.result);
        final String f = list.get(position);

        if (f != null) {
            quizID.setText("Quiz "+(1+position));
            quizResult.setText(f);
            if(f.equals(mActivity.getResources().getString(R.string.correct))){
                quizResult.setTextColor(mActivity.getResources().getColor(R.color.green));
            }
            else{
                quizResult.setTextColor(mActivity.getResources().getColor(R.color.red));
            }
        }
        return convertView;
    }


    public void updateListView(ArrayList<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}
