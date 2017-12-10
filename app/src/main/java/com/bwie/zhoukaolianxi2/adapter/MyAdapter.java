package com.bwie.zhoukaolianxi2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.zhoukaolianxi2.R;
import com.bwie.zhoukaolianxi2.bean.MyBean;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2017/12/9.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private MyBean bean;

    public MyAdapter(Context context, MyBean bean) {
        this.context = context;
        this.bean = bean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item, null);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
    ViewHolder viewHolder=(ViewHolder)holder;
        if(onItemClickLinster!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = holder.getLayoutPosition();
                    onItemClickLinster.OnItemClickLinser(view,pos);
                    onItemClickLinster.OnItemLongClickLinser(view,pos);
                }
            });
        }
        viewHolder.simpl.setImageURI(bean.getGoods_list().get(position).getImage_url());
        viewHolder.tv.setText(bean.getGoods_list().get(position).getShort_name());
    }

    @Override
    public int getItemCount() {
        return bean.getGoods_list().size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.simpl)
        SimpleDraweeView simpl;
        @BindView(R.id.tv)
        TextView tv;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
    public interface OnItemClickLinster{
        void OnItemClickLinser(View v, int pos);
        void OnItemLongClickLinser(View v, int pos);
    }

    private OnItemClickLinster onItemClickLinster;

    public void setOnItemClickLinster(OnItemClickLinster onItemClickLinster) {
        this.onItemClickLinster = onItemClickLinster;
    }
}
