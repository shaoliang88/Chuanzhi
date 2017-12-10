package com.bwie.zhoukaolianxi2.model;

import com.bwie.zhoukaolianxi2.bean.BaseBean;
import com.bwie.zhoukaolianxi2.utils.Finish2;
import com.bwie.zhoukaolianxi2.utils.ServiceAPI;
import com.bwie.zhoukaolianxi2.utils.UtilsURL;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lenovo on 2017/12/9.
 */

public class getModelImpl2 implements getModel2{
    @Override
    public void getData(final Finish2 finish2, String cid) {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(UtilsURL.HOST_URL2)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ServiceAPI serviceAPI = retrofit.create(ServiceAPI.class);
        Flowable<BaseBean> basebean = serviceAPI.basebean(cid);
        basebean.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BaseBean>() {
                    @Override
                    public void accept(BaseBean baseBean) throws Exception {
                        finish2.onFinish(baseBean);
                    }
                });
    }
}
