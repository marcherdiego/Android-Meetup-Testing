package com.mercadolibre.android.androidmeetup.testing.ui.activities;

import android.os.Bundle;

import com.mercadolibre.android.androidmeetup.testing.R;
import com.mercadolibre.android.androidmeetup.testing.ui.mvp.model.UserListingModel;
import com.mercadolibre.android.androidmeetup.testing.ui.mvp.presenter.UserListingPresenter;
import com.mercadolibre.android.androidmeetup.testing.ui.mvp.view.UserListingView;
import com.nerdscorner.mvplib.events.activity.BaseActivity;

public class UserListingActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_listing);

        presenter = new UserListingPresenter(
            new UserListingView(this),
            new UserListingModel()
        );
    }
}
