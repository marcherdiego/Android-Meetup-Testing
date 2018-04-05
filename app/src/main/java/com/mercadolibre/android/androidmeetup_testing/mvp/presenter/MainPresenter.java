package com.mercadolibre.android.androidmeetup_testing.mvp.presenter;

import android.support.annotation.NonNull;

import com.mercadolibre.android.androidmeetup_testing.mvp.model.MainModel;
import com.mercadolibre.android.androidmeetup_testing.mvp.view.MainView;
import com.nerdscorner.mvplib.events.presenter.BaseActivityPresenter;

public class MainPresenter extends BaseActivityPresenter<MainView, MainModel> {
    public MainPresenter(@NonNull MainView view, @NonNull MainModel model) {
        super(view, model);
    }
}
