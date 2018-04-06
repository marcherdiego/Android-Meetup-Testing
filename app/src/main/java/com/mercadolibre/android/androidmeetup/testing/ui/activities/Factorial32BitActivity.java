package com.mercadolibre.android.androidmeetup.testing.ui.activities;

import android.os.Bundle;

import com.mercadolibre.android.androidmeetup.testing.R;
import com.mercadolibre.android.androidmeetup.testing.ui.mvp.model.Factorial32BitModel;
import com.mercadolibre.android.androidmeetup.testing.ui.mvp.presenter.Factorial32BitPresenter;
import com.mercadolibre.android.androidmeetup.testing.ui.mvp.view.Factorial32BitView;
import com.nerdscorner.mvplib.events.activity.BaseActivity;

public class Factorial32BitActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factorial_32_bit);

        presenter = new Factorial32BitPresenter(
            new Factorial32BitView(this),
            new Factorial32BitModel()
        );
    }
}
