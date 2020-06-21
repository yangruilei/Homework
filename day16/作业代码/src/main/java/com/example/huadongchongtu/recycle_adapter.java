package com.example.huadongchongtu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class recycle_adapter extends RecyclerView.Adapter {
    List<String> list=new ArrayList();
    Context context;

    public recycle_adapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.adapter_four, parent, false);
        return new holder1(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        holder1 holder1= (recycle_adapter.holder1) holder;
        String s = list.get(position);
        holder1.text.setText(s);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class holder1 extends RecyclerView.ViewHolder {

        private final TextView text;

        public holder1(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.tv_text);
        }
    }
}
