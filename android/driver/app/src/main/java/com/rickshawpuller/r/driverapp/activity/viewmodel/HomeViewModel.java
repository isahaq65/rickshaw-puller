package com.rickshawpuller.r.driverapp.activity.viewmodel;

import android.app.Activity;
import android.content.Intent;

import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseAuth;
import com.rickshawpuller.r.driverapp.activity.LoginActivity;

public class HomeViewModel extends ViewModel {

    public HomeViewModel() {

    }

    public void signOut(Activity activity) {
        FirebaseAuth.getInstance().signOut();
        Intent intent=new Intent(activity, LoginActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }
}
