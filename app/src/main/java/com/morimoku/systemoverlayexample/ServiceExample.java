package com.morimoku.systemoverlayexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

interface InterPass{
    void changeText();

}

public class ServiceExample extends Service implements InterPass {
    WindowManager windowManager;
    Context context;
    View view;
    RecyclerView recyclerView;
    ImageView finger,bold;
    TextView textView;


    @Override
    public void onCreate() {
        super.onCreate();
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        context = getApplicationContext();
        windowManager = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        view = layoutInflater.inflate(R.layout.activity_service_example, null);//This null could be the reason why it would get a null point exception.

        recyclerView = view.findViewById(R.id.recyclerView_name);
        finger = view.findViewById(R.id.imageView);
        bold = view.findViewById(R.id.imageView2);
        textView = view.findViewById(R.id.textView);


        final LoginActivityAdapter loginActivityAdapter = new LoginActivityAdapter(this);
        LinearLayoutManager linearLayout = new LinearLayoutManager(getApplicationContext());


        WindowManager.LayoutParams params = null;
        params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,//window that would be displayed over activity window
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,//sysytem would not get the user input from keyboard
                PixelFormat.OPAQUE);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayout);
        recyclerView.setAdapter(loginActivityAdapter);
        windowManager.addView(view, params);


    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void changeText() {
        textView.setText("you have clicked it congrats!!");

    }
}