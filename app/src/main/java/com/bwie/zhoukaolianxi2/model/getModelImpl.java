package com.bwie.zhoukaolianxi2.model;

import com.bwie.zhoukaolianxi2.bean.MyBean;
import com.bwie.zhoukaolianxi2.utils.Finish;
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

public class getModelImpl implements getModel{
    @Override
    public void getData(final Finish finish) {
        Retrofit retrofit=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(UtilsURL.HOST_URL)
                .build();
        ServiceAPI serviceAPI = retrofit.create(ServiceAPI.class);
        Flowable<MyBean> bean = serviceAPI.bean();
        bean.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MyBean>() {
                    @Override
                    public void accept(MyBean bean) throws Exception {
                        finish.onfinish(bean);
                    }
                });
    }
}
