package com.bwie.zhoukaolianxi2.presenter;

import com.bwie.zhoukaolianxi2.bean.MyBean;
import com.bwie.zhoukaolianxi2.model.getModel;
import com.bwie.zhoukaolianxi2.model.getModelImpl;
import com.bwie.zhoukaolianxi2.utils.Finish;
import com.bwie.zhoukaolianxi2.view.getView;

/**
 * Created by lenovo on 2017/12/9.
 */

public class getPresenterImpl implements getPresenter,Finish{
    private final getModel m;
    getView view;

    public getPresenterImpl(getView view) {
        this.view = view;
         m=new getModelImpl();
    }

    @Override
    public void guanlian() {
        m.getData(this);
    }

    @Override
    public void onfinish(MyBean bean) {
      view.ShowData(bean);
    }
}
