package com.mercadolibre.android.androidmeetup.testing.ui.mvp.view;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;

import com.mercadolibre.android.androidmeetup.testing.R;
import com.nerdscorner.mvplib.events.activity.BaseActivity;
import com.nerdscorner.mvplib.events.view.BaseActivityView;

public class MainView extends BaseActivityView {

    public MainView(@NonNull BaseActivity activity) {
        super(activity);

        activity
            .findViewById(R.id.factorial_32_bits)
            .setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    bus.post(new Factorial32BitsButtonClickEvent());
                }
            });

        activity
            .findViewById(R.id.user_listing)
            .setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    bus.post(new UserListingClickEvent());
                }
            });
    }

    public static class Factorial32BitsButtonClickEvent {
    }

    public static class UserListingClickEvent {
    }
}
