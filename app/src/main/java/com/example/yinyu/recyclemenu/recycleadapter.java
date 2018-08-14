package com.example.yinyu.recyclemenu;

import android.content.Context;
import android.support.annotation.NonNull;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.logging.Handler;

/**
 * Created by yinyu on 2018/8/14.
 */

public class recycleadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<String> data;

    public recycleadapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_recycle,parent,false);
        return new ViewHolder(view) ;

    }

    public void setdata(List<String> data)
    {
        this.data=data;
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if(holder instanceof ViewHolder)
        {
            ((ViewHolder)holder).menu.setText(data.get(position));
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"点击了menu"+position,Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return data!=null?data.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView menu;
    public ViewHolder(View itemview) {
        super(itemview);
        menu=itemview.findViewById(R.id.menu);
    }
}
}
