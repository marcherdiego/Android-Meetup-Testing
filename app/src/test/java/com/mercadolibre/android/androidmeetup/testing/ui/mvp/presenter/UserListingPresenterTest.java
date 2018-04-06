package com.mercadolibre.android.androidmeetup.testing.ui.mvp.presenter;

import com.mercadolibre.android.androidmeetup.testing.ui.adapters.UsersCardsAdapter;
import com.mercadolibre.android.androidmeetup.testing.ui.mvp.model.UserListingModel;
import com.mercadolibre.android.androidmeetup.testing.ui.mvp.model.UserListingModel.UserListFetchFailedEvent;
import com.mercadolibre.android.androidmeetup.testing.ui.mvp.model.UserListingModel.UserListFetchedSuccessfullyEvent;
import com.mercadolibre.android.androidmeetup.testing.ui.mvp.view.UserListingView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

public class UserListingPresenterTest {

    private UserListingPresenter userListingPresenter;

    @Mock UserListingView view;
    @Mock UserListingModel model;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        userListingPresenter = new UserListingPresenter(view, model);
    }

    @Test
    public void test_onUserListFetchedSuccessfully_shouldHideProgressBar() {
        userListingPresenter.onUserListFetchedSuccessfully(new UserListFetchedSuccessfullyEvent());
        verify(view).hideProgressBar();
    }

    @Test
    public void test_onUserListFetchedSuccessfully_shouldCallGetUserList() {
        userListingPresenter.onUserListFetchedSuccessfully(new UserListFetchedSuccessfullyEvent());
        verify(model).getUserList();
    }

    @Test
    public void test_onUserListFetchedSuccessfully_shouldCallSetUsersCardsAdapter() {
        userListingPresenter.onUserListFetchedSuccessfully(new UserListFetchedSuccessfullyEvent());
        verify(view).setUsersCardsAdapter(any(UsersCardsAdapter.class));
    }

    @Test
    public void test_onUserListFetchFailed_shouldHideProgressBar() {
        userListingPresenter.onUserListFetchFailed(new UserListFetchFailedEvent());
        verify(view).hideProgressBar();
    }

    @Test
    public void test_onResume_shouldCallShowProgressBar() {
        userListingPresenter.onResume();
        verify(view).showProgressBar();
    }

    @Test
    public void test_onResume_shouldCallFetchUserList() {
        userListingPresenter.onResume();
        verify(model).fetchUserList();
    }
}