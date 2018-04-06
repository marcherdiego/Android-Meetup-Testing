package com.mercadolibre.android.androidmeetup.testing.ui.mvp.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.mercadolibre.android.androidmeetup.testing.R;
import com.mercadolibre.android.androidmeetup.testing.ui.adapters.UsersCardsAdapter;
import com.nerdscorner.mvplib.events.activity.BaseActivity;
import com.nerdscorner.mvplib.events.view.BaseActivityView;

public class UserListingView extends BaseActivityView {

    private RecyclerView userList;
    private ProgressBar progressBar;

    public UserListingView(@NonNull BaseActivity activity) {
        super(activity);

        progressBar = activity.findViewById(R.id.progress_bar);
        userList = activity.findViewById(R.id.list);
        userList.setLayoutManager(new LinearLayoutManager(activity));
    }

    public void setUsersCardsAdapter(UsersCardsAdapter adapter) {
        userList.setAdapter(adapter);
    }

    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    public void hideProgressBar() {
        progressBar.setVisibility(View.INVISIBLE);
    }
}
