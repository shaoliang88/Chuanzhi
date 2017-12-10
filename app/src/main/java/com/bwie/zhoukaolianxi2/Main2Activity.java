package com.bwie.zhoukaolianxi2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bwie.zhoukaolianxi2.adapter.BaseAdapters;
import com.bwie.zhoukaolianxi2.bean.BaseBean;
import com.bwie.zhoukaolianxi2.presenter.getPresenter2;
import com.bwie.zhoukaolianxi2.presenter.getPresenterImpl2;
import com.bwie.zhoukaolianxi2.view.getView2;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity implements getView2 {
    @BindView(R.id.recycler_item)
    RecyclerView recyclerItem;
    private String goods_id;
    private BaseBean baseBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        goods_id = intent.getStringExtra("goods_id");
        recyclerItem.setLayoutManager(new LinearLayoutManager(this));
        getPresenter2 presenter2=new getPresenterImpl2(this);
        presenter2.guanlian2(goods_id);
    }

    @Override
    public void ShowData2(BaseBean baseBean) {
        BaseAdapters adapter = new BaseAdapters(Main2Activity.this, baseBean);
        recyclerItem.setAdapter(adapter);
        Log.d("dawdadjoawjdoad", baseBean.getImage_url());
    }

    @Override
    public String cid() {
        return goods_id;
    }
}
