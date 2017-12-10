package com.bwie.zhoukaolianxi2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bwie.zhoukaolianxi2.adapter.MyAdapter;
import com.bwie.zhoukaolianxi2.bean.BaseBean;
import com.bwie.zhoukaolianxi2.bean.MyBean;
import com.bwie.zhoukaolianxi2.presenter.getPresenter;
import com.bwie.zhoukaolianxi2.presenter.getPresenterImpl;
import com.bwie.zhoukaolianxi2.view.getView;

public class MainActivity extends AppCompatActivity implements getView {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         recyclerView= (RecyclerView) findViewById(R.id.recycler);
        getPresenter p=new getPresenterImpl(this);
        p.guanlian();
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
    }

    @Override
    public void ShowData(final MyBean bean) {
        MyAdapter adapter=new MyAdapter(MainActivity.this,bean);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickLinster(new MyAdapter.OnItemClickLinster() {
            @Override
            public void OnItemClickLinser(View v, int pos) {
                int goods_id = bean.getGoods_list().get(pos).getGoods_id();
                Intent in=new Intent(MainActivity.this,Main2Activity.class);
                in.putExtra("goods_id",goods_id+"");
                startActivity(in);
            }

            @Override
            public void OnItemLongClickLinser(View v, int pos) {

            }
        });
    }

}
