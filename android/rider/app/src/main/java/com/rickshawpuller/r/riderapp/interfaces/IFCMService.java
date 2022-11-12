package com.rickshawpuller.r.riderapp.interfaces;

import com.rickshawpuller.r.riderapp.common.ConfigApp;
import com.rickshawpuller.r.riderapp.model.fcm.FCMResponse;
import com.rickshawpuller.r.riderapp.model.fcm.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface IFCMService {
    @Headers({
        "Content-Type:application/json",
        "Authorization:key=" + ConfigApp.CLOUD_MESSAGING_SERVER_GEY
    })
    @POST("fcm/send")
    Call<FCMResponse> sendMessage(@Body Sender body);
}
