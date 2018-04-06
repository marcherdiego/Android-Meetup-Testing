package com.mercadolibre.android.androidmeetup.testing.ui.mvp.presenter;

import android.support.annotation.NonNull;

import com.mercadolibre.android.androidmeetup.testing.ui.adapters.UsersCardsAdapter;
import com.mercadolibre.android.androidmeetup.testing.ui.mvp.model.UserListingModel;
import com.mercadolibre.android.androidmeetup.testing.ui.mvp.model.UserListingModel.UserListFetchFailedEvent;
import com.mercadolibre.android.androidmeetup.testing.ui.mvp.model.UserListingModel.UserListFetchedSuccessfullyEvent;
import com.mercadolibre.android.androidmeetup.testing.ui.mvp.view.UserListingView;
import com.nerdscorner.mvplib.events.presenter.BaseActivityPresenter;

import org.greenrobot.eventbus.Subscribe;

public class UserListingPresenter extends BaseActivityPresenter<UserListingView, UserListingModel> {
    public UserListingPresenter(@NonNull UserListingView view, @NonNull UserListingModel model) {
        super(view, model);
    }

    @Subscribe
    public void onUserListFetchedSuccessfully(UserListFetchedSuccessfullyEvent event) {
        view.setUsersCardsAdapter(new UsersCardsAdapter(model.getUserList()));
        view.hideProgressBar();
    }

    @Subscribe
    public void onUserListFetchFailed(UserListFetchFailedEvent event) {
        view.hideProgressBar();
    }

    @Override
    public void onResume() {
        super.onResume();
        view.showProgressBar();
        model.fetchUserList();
    }
}
