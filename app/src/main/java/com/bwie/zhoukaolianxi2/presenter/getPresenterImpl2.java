package com.bwie.zhoukaolianxi2.presenter;

import com.bwie.zhoukaolianxi2.bean.BaseBean;
import com.bwie.zhoukaolianxi2.model.getModel2;
import com.bwie.zhoukaolianxi2.model.getModelImpl2;
import com.bwie.zhoukaolianxi2.utils.Finish2;
import com.bwie.zhoukaolianxi2.view.getView;
import com.bwie.zhoukaolianxi2.view.getView2;

/**
 * Created by lenovo on 2017/12/9.
 */

public class getPresenterImpl2 implements getPresenter2,Finish2{
    private final getModel2 model2;
    getView2 view;

    public getPresenterImpl2(getView2 view) {
        this.view = view;
         model2=new getModelImpl2();
    }

    @Override
    public void guanlian2(String cid) {
         model2.getData(this,view.cid());
    }

    @Override
    public void onFinish(BaseBean baseBean) {
       view.ShowData2(baseBean);
    }
}
