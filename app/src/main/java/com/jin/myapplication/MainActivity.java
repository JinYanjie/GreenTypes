package com.jin.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyAdapter.SolveData{
    private static final String TAG = "MainActivity";
        private RecyclerView recyclerView;
    MyAdapter adapter;
    private List<GreensTypes> lists=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
        recyclerView= (RecyclerView) findViewById(R.id.recycle);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter=new MyAdapter(lists,this);
        recyclerView.setAdapter(adapter);

    }

    /**
     * 我简单加了一个数据
     */
    public void getData(){
        lists.add(new GreensTypes("yi"));
        lists.add(new GreensTypes("er"));
        lists.add(new GreensTypes("san"));
    }

//    这里用一个views保存各个items
    private List<View> views=new ArrayList<>();
    @Override
    public void solve(final MyAdapter.ViewHolder holder, final int position, List<GreensTypes> lists) {
        final GreensTypes greensTypes=lists.get(position);
//        这里是把item布局添加到views里面
        views.add(holder.linearLayout);
        Log.e(TAG, "solve: views.size()=="+views.size() );
        final int size=lists.size();


//        lists里面存的是GreensTypes，菜系。
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                点击的时候判断点击的是哪个，如果是就把背景设置为蓝色，否则就让其他item背景为白色。
                for (int i=0;i<size;i++){
                    if (i==position){
                        Log.e(TAG, "onClick: "+"变成蓝色" );
                        holder.linearLayout.setBackgroundColor(Color.BLUE);
                        holder.greenType.setText(greensTypes.getName());
                    }else {
                        views.get(i).setBackgroundColor(Color.WHITE);
                    }
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }
}
