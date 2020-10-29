package com.morimoku.systemoverlayexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Map;

public class LoginActivityAdapter extends RecyclerView.Adapter<LoginActivityAdapter.LoginViewHolder> {

    Context context;
    ArrayList<String> menu = new ArrayList<>();

    public LoginActivityAdapter(Context context) {
        this.context = context;

    }




    @NonNull
    @Override
    public LoginViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        menu.add("Hamburger");
        menu.add("Chicken");
        menu.add("water");


        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.login_user_adapter, parent, false);



        return new LoginViewHolder(view);

    }
    @Override
    public void onBindViewHolder(@NonNull final LoginViewHolder holder, final int position) {
        holder.userName.setText(menu.get(position));
        holder.userName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServiceExample serviceExample = new ServiceExample();
                serviceExample.changeText();
            }
        });


    }
    @Override
    public int getItemCount() {
        return 3;
    }

    public class LoginViewHolder extends RecyclerView.ViewHolder {

        public final TextView userName;
        public final ImageView iVPicture;
        public final LinearLayout linearLayout;

        public LoginViewHolder(@NonNull View itemView) {
            super(itemView);

            userName = itemView.findViewById(R.id.tv_user_login);
            iVPicture= itemView.findViewById(R.id.iV_user_login);
            linearLayout = itemView.findViewById(R.id.layout_user);
        }
    }
}