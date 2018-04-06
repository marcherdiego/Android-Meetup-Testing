package com.mercadolibre.android.androidmeetup.testing.ui.mvp.model;

import com.mercadolibre.android.androidmeetup.testing.domain.User;
import com.mercadolibre.android.androidmeetup.testing.ui.mvp.model.UserListingModel.UserListFetchFailedEvent;
import com.mercadolibre.android.androidmeetup.testing.ui.mvp.model.UserListingModel.UserListFetchedSuccessfullyEvent;

import org.greenrobot.eventbus.Subscribe;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertThat;

@RunWith(RobolectricTestRunner.class)
public class UserListingModelTest {

    private UserListingModel userListingModel;

    @Before
    public void setUp() {
        userListingModel = new UserListingModel();
    }

    @Test
    public void test_fetchUserList_shouldLoadListWithThreeDummyItems() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        userListingModel.fetchUserList();
        try {
            countDownLatch.await(4, TimeUnit.SECONDS);
        } catch (InterruptedException ignored) {
            ignored.printStackTrace();
        }
        assertThat(userListingModel.getUserList(), Matchers.<User>hasSize(3));
    }

    @Test
    public void test_fetchUserList_shouldPostUserListFetchedSuccessfullyEvent() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final List<UserListFetchedSuccessfullyEvent> events = new LinkedList<>();
        EventConsumer eventConsumer = new EventConsumer<>(events);
        userListingModel.getBus().register(eventConsumer);
        userListingModel.fetchUserList();
        try {
            countDownLatch.await(4, TimeUnit.SECONDS);
        } catch (InterruptedException ignored) {
            ignored.printStackTrace();
        }
        assertThat(events, Matchers.hasSize(1));
    }

    @Test
    public void test_fetchUserList_shouldPostUserListFetchFailedEvent() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final List<UserListFetchFailedEvent> events = new LinkedList<>();
        EventConsumer eventConsumer = new EventConsumer<>(events);
        userListingModel.getBus().register(eventConsumer);
        userListingModel.fetchUserList();
        try {
            countDownLatch.await(4, TimeUnit.SECONDS);
        } catch (InterruptedException ignored) {
            ignored.printStackTrace();
        }
        assertThat(events, Matchers.hasSize(1));
    }

    @Test
    public void onPause() {
    }

    @Test
    public void getUserList() {
    }

    public static class EventConsumer<T> {
        private List<T> events;

        EventConsumer(List<T> events) {
            this.events = events;
        }

        @Subscribe
        public void onNewEvent(T event) {
            events.add(event);
        }
    }
}