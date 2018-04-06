package com.mercadolibre.android.androidmeetup.testing.ui.mvp.presenter;

import android.content.Intent;

import com.mercadolibre.android.androidmeetup.testing.ui.activities.Factorial32BitActivity;
import com.mercadolibre.android.androidmeetup.testing.ui.activities.MainActivity;
import com.mercadolibre.android.androidmeetup.testing.ui.activities.UserListingActivity;
import com.mercadolibre.android.androidmeetup.testing.ui.mvp.model.MainModel;
import com.mercadolibre.android.androidmeetup.testing.ui.mvp.view.MainView;
import com.mercadolibre.android.androidmeetup.testing.ui.mvp.view.MainView.Factorial32BitsButtonClickEvent;
import com.mercadolibre.android.androidmeetup.testing.ui.mvp.view.MainView.UserListingClickEvent;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowActivity;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricTestRunner.class)
public class MainPresenterTest {

    @Mock MainView view;
    @Mock MainModel model;

    private MainPresenter presenter;
    private MainActivity mainActivity;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        mainActivity = Robolectric.buildActivity(MainActivity.class).create().get();
        when(view.getActivity()).thenReturn(mainActivity);
        presenter = new MainPresenter(view, model);
    }

    @Test
    public void test_onFactorial32BitsButtonClick_shouldOpenFactorial32BitActivity() {
        presenter.onFactorial32BitsButtonClick(new Factorial32BitsButtonClickEvent());
        ShadowActivity shadowActivity = shadowOf(mainActivity);
        Intent startedIntent = shadowActivity.getNextStartedActivity();
        assertThat(startedIntent.getComponent().getClassName(), equalTo(Factorial32BitActivity.class.getName()));
    }

    @Test
    public void test_onUserListingClick_shouldOpenUserListingActivity() {
        presenter.onUserListingClick(new UserListingClickEvent());
        ShadowActivity shadowActivity = shadowOf(mainActivity);
        Intent startedIntent = shadowActivity.getNextStartedActivity();
        assertThat(startedIntent.getComponent().getClassName(), equalTo(UserListingActivity.class.getName()));
    }
}