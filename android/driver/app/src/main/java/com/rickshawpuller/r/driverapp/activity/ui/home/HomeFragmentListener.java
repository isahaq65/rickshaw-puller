package com.rickshawpuller.r.driverapp.activity.ui.home;

import com.rickshawpuller.r.driverapp.message.Errors;

public interface HomeFragmentListener {
    public interface ShowMessageListener {
        void showErrorMessage(Errors error);
    }
}
