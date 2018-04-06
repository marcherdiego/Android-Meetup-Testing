package com.mercadolibre.android.androidmeetup.testing.ui.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mercadolibre.android.androidmeetup.testing.R;
import com.mercadolibre.android.androidmeetup.testing.domain.User;
import com.mercadolibre.android.androidmeetup.testing.ui.adapters.UsersCardsAdapter.UserViewHolder;

import java.util.List;

public class UsersCardsAdapter extends RecyclerView.Adapter<UserViewHolder> {
    private List<User> users;

    public UsersCardsAdapter(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = users.get(position);
        holder.userImage.setImageResource(R.drawable.ic_launcher_background);
        holder.userName.setText(user.getName());
        holder.userEmail.setText(user.getEmail());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {
        ImageView userImage;
        TextView userName;
        TextView userEmail;

        public UserViewHolder(View itemView) {
            super(itemView);
            userImage = itemView.findViewById(R.id.user_image);
            userName = itemView.findViewById(R.id.user_name);
            userEmail = itemView.findViewById(R.id.user_email);
        }
    }
}
