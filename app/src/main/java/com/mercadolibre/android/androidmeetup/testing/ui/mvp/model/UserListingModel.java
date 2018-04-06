package com.mercadolibre.android.androidmeetup.testing.ui.mvp.model;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import com.mercadolibre.android.androidmeetup.testing.domain.User;
import com.nerdscorner.mvplib.events.model.BaseModel;

import java.util.LinkedList;
import java.util.List;

public class UserListingModel extends BaseModel {
    private List<User> userList;
    private AsyncTask<Void, Void, Boolean> userFetchTask;

    public UserListingModel() {
        userList = new LinkedList<>();
    }

    public void fetchUserList() {
        executeUserListApiCall(new UserListCallback() {
            @Override
            public void onSuccess(List<User> userListResult) {
                userList.clear();
                userList.addAll(userListResult);
                bus.post(new UserListFetchedSuccessfullyEvent());
            }

            @Override
            public void onFail() {
                bus.post(new UserListFetchFailedEvent());
            }
        });
    }

    @SuppressLint("StaticFieldLeak")
    private void executeUserListApiCall(final UserListCallback callback) {
        userFetchTask = new AsyncTask<Void, Void, Boolean>() {
            private List<User> userList = new LinkedList<>();

            @Override
            protected Boolean doInBackground(Void... voids) {
                try {
                    Thread.sleep(3000L);

                    //Fake load response
                    userList.add(new User("Diego Marcher", "diego.marcher@mercadolibre.com", ""));
                    userList.add(new User("Nahuel Barrios", "nahuel.narrios@mercadolibre.com", ""));
                    userList.add(new User("Juan Ignacio Molina", "juan.ignacio.molina@mercadolibre.com", ""));
                    return true;
                } catch (InterruptedException ignored) {
                }
                return false;
            }

            @Override
            protected void onPostExecute(Boolean success) {
                if (success) {
                    callback.onSuccess(userList);
                } else {
                    callback.onFail();
                }
            }
        };
        userFetchTask.execute();
    }

    @Override
    public void onPause() {
        userFetchTask.cancel(true);
    }

    public List<User> getUserList() {
        return userList;
    }

    interface UserListCallback {
        void onSuccess(List<User> userListResult);

        void onFail();
    }

    public static class UserListFetchedSuccessfullyEvent {
    }

    public static class UserListFetchFailedEvent {
    }
}
