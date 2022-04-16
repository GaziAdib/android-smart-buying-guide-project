package com.example.anabi.finalyearproject1try.FirebasePushNotification;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class GettingDeviceTokenService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {

        String deviceToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("DEVICE TOKEN", deviceToken);

    }
}
