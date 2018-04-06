package com.mercadolibre.android.androidmeetup.testing.ui.mvp.presenter;

import android.support.annotation.NonNull;

import com.mercadolibre.android.androidmeetup.testing.ui.mvp.model.Factorial32BitModel;
import com.mercadolibre.android.androidmeetup.testing.ui.mvp.view.Factorial32BitView;
import com.mercadolibre.android.androidmeetup.testing.ui.mvp.view.Factorial32BitView.FactorialButtonClickEvent;
import com.nerdscorner.mvplib.events.presenter.BaseActivityPresenter;

import org.greenrobot.eventbus.Subscribe;

public class Factorial32BitPresenter extends BaseActivityPresenter<Factorial32BitView, Factorial32BitModel> {
    public Factorial32BitPresenter(@NonNull Factorial32BitView view, @NonNull Factorial32BitModel model) {
        super(view, model);
    }

    @Subscribe
    public void onFactorialButtonClick(FactorialButtonClickEvent event) {
        int input = Integer.valueOf(event.input);
        int result = model.calculateFactorial(input);
        view.showFactorialResult(input, result);
    }
}
