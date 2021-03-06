package com.jin.myapplication;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by jyj on 2017/3/23.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private static final String TAG = "MyAdapter";
    private List<GreensTypes> lists;
//    这里是通过构造函数，让MainActivity实现
    public MyAdapter(List<GreensTypes> lists,  SolveData solveData) {
        Log.e(TAG, "MyAdapter: " );
        this.lists = lists;
        this.solveData = solveData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e(TAG, "onCreateViewHolder: " );
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.type_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.e(TAG, "onBindViewHolder: " );
        solveData.solve(holder, position,lists);
    }

    @Override
    public int getItemCount() {
        Log.e(TAG, "getItemCount: " );
        return lists.size();
    }

    static  class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView greenType;
        LinearLayout linearLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            Log.e(TAG, "ViewHolder: " );
            imageView= (ImageView) itemView.findViewById(R.id.img);
            greenType= (TextView) itemView.findViewById(R.id.green_type);
            linearLayout= (LinearLayout) itemView.findViewById(R.id.line1);
        }
    }
//    这是写的一个接口，用于把这些方法传到MainActivity里面。
    private  SolveData solveData;
   public interface  SolveData{
       /**
        *
        * @param holder 这个就是 onBindViewHolder(ViewHolder holder, int position)里面的参数
        * @param position
        * @param lists  这个是从Activity里面传递过来的数据（感觉其实没必要）
        */
       void   solve(ViewHolder holder, int position,List<GreensTypes> lists);
    }

}
