package com.jin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyAdapter.SolveData {
        private RecyclerView recyclerView;
    private List<GreensTypes> lists=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
        recyclerView= (RecyclerView) findViewById(R.id.recycle);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        MyAdapter adapter=new MyAdapter(lists,this);
        recyclerView.setAdapter(adapter);
    }

    /**
     * 我简单加了一个数据
     */
    public void getData(){
        lists.add(new GreensTypes("yi"));
    }

    @Override
    public void solve(MyAdapter.ViewHolder holder, int position, List<GreensTypes> lists) {
//        lists里面存的是GreensTypes，菜系。
        GreensTypes greensTypes=lists.get(position);
        holder.greenType.setText(greensTypes.getName());
    }
}
