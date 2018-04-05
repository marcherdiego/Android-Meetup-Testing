package com.mercadolibre.android.androidmeetup.testing.ui.activities;

import android.os.Bundle;

import com.mercadolibre.android.androidmeetup.R;
import com.mercadolibre.android.androidmeetup.testing.ui.mvp.model.MainModel;
import com.mercadolibre.android.androidmeetup.testing.ui.mvp.presenter.MainPresenter;
import com.mercadolibre.android.androidmeetup.testing.ui.mvp.view.MainView;
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
