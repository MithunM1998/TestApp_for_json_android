package com.example.testapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Context mContext;
    private List<Fact> mFactList;
    //private String mFactList;
     Fact fact=new Fact();
    LayoutInflater inflater;
    public MyAdapter(Context context, List<Fact> mFact) {
        this.mContext = context;
        this.mFactList=mFact;
        inflater = (LayoutInflater.from(context));
    }
    @Override
    public int getCount() {
        return mFactList.size();
    }

    @Override
    public Object getItem(int i) {
        return mFactList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    static class ViewHolder{
        protected TextView textView;
    }
    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if (view==null){
            view=inflater.inflate(R.layout.fact,null,true);
            viewHolder = new ViewHolder();

            viewHolder.textView=(TextView)view.findViewById(R.id.textView);
            view.setTag(viewHolder);
            view.setTag(R.id.textView, viewHolder.textView);

        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textView.setTag(i);
        viewHolder.textView.setText("Fact"+fact.getmFact());

        return view;
    }
}
