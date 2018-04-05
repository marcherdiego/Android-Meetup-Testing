package com.mercadolibre.android.androidmeetup_testing;

import android.os.Bundle;

import com.mercadolibre.android.androidmeetup_testing.mvp.model.MainModel;
import com.mercadolibre.android.androidmeetup_testing.mvp.presenter.MainPresenter;
import com.mercadolibre.android.androidmeetup_testing.mvp.view.MainView;
import com.nerdscorner.mvplib.events.activity.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(
            new MainView(this),
            new MainModel()
        );
    }
}
