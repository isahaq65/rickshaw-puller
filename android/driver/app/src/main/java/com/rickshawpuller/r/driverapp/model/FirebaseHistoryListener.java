package com.rickshawpuller.r.driverapp.model;

import com.rickshawpuller.r.driverapp.model.firebase.History;

import java.util.ArrayList;

public interface FirebaseHistoryListener {
    interface GetFirebaseHistoryListener {
        void onFirebaseHistoryRetrieved(ArrayList<History> historyList);
    }
}
