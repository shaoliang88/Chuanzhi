package com.bwie.zhoukaolianxi2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.zhoukaolianxi2.R;
import com.bwie.zhoukaolianxi2.bean.BaseBean;
import com.bwie.zhoukaolianxi2.utils.BannerImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2017/12/9.
 */

public class BaseAdapters extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private BaseBean baseBean;
    private int TYPE_BANNER = 0;
    private int TYPE_GRID = 1;
    public BaseAdapters(Context context, BaseBean baseBean) {
        this.context = context;
        this.baseBean = baseBean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == TYPE_BANNER) {
            View view = View.inflate(context, R.layout.item2, null);
            BannerViewHolder holder = new BannerViewHolder(view);
            return holder;
        } else if (viewType == TYPE_GRID) {
            View view = View.inflate(context, R.layout.item3, null);
           ViewHolder holder=new ViewHolder(view);
            return holder;
        }


        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
   if (holder instanceof BannerViewHolder){
       BannerViewHolder viewHolder = (BannerViewHolder) holder;
       viewHolder.banner.setImageLoader(new BannerImageLoader());
       List<String> bannerList = new ArrayList<>();
       for (int i = 0; i < baseBean.getSku().size(); i++) {
           bannerList.add(baseBean.getSku().get(i).getThumb_url());
       }
       viewHolder.banner.setBannerAnimation(Transformer.DepthPage).isAutoPlay(true);
       viewHolder.banner.setImages(bannerList);
       viewHolder.banner.setDelayTime(3000);
       viewHolder.banner.start();
   }else if(holder instanceof ViewHolder){
        ViewHolder holder1=(ViewHolder)holder;
   holder1.tv2.setText(baseBean.getGoods_desc());
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return TYPE_BANNER;
        }else if(position==1){
return TYPE_GRID;
        }
        return 2;
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    static class BannerViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.banner)
        Banner banner;

        BannerViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv2)
        TextView tv2;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
