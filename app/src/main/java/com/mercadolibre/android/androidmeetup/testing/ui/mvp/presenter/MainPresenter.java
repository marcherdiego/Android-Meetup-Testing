package com.mercadolibre.android.androidmeetup.testing.ui.mvp.presenter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.mercadolibre.android.androidmeetup.testing.ui.activities.Factorial32BitActivity;
import com.mercadolibre.android.androidmeetup.testing.ui.mvp.model.MainModel;
import com.mercadolibre.android.androidmeetup.testing.ui.mvp.view.MainView;
import com.mercadolibre.android.androidmeetup.testing.ui.mvp.view.MainView.Factorial32BitsButtonClickEvent;
import com.nerdscorner.mvplib.events.presenter.BaseActivityPresenter;

import org.greenrobot.eventbus.Subscribe;

public class MainPresenter extends BaseActivityPresenter<MainView, MainModel> {
    public MainPresenter(@NonNull MainView view, @NonNull MainModel model) {
        super(view, model);
    }

    @Subscribe
    public void onFactorial32BitsButtonClick(Factorial32BitsButtonClickEvent event) {
        Activity activity = view.getActivity();
        if (activity == null) {
            return;
        }
        activity.startActivity(new Intent(activity, Factorial32BitActivity.class));
    }
}
