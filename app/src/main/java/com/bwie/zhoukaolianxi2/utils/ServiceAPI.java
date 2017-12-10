package com.bwie.zhoukaolianxi2.utils;

import com.bwie.zhoukaolianxi2.bean.BaseBean;
import com.bwie.zhoukaolianxi2.bean.MyBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by lenovo on 2017/12/9.
 */

public interface ServiceAPI {
    @GET(UtilsURL.TAGS_URL)
    Flowable<MyBean> bean();
    @GET("v5/goods/{o}?pdduid=3470667255")
    Flowable<BaseBean> basebean(@Path("o") String cid);
}
