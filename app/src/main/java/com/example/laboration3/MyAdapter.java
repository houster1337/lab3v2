package com.example.laboration3;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    int id;
    ArrayList<String> list;
    Context context;
    int N;
    String name;

    public MyAdapter(int id, ArrayList<String> list, int N){
        this.id = id;
        this.list = list;
        this.N = N;
    }

    public MyAdapter(){

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
        return list.indexOf(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        for(int i = 0; i < N; ++i){
            name = list.get(i);
            MyRow row = new MyRow(context, name);
        }

        return convertView;
    }

    public void updateData(int id, ArrayList<String> list, int N){
        this.id = id;
        this.list = list;
        this.N = N;

    }
}
