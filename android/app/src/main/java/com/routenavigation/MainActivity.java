package com.routenavigation;

import android.os.Bundle;

import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        registerPlugin(NavigationPlugin.class);
        super.onCreate(savedInstanceState);
    }

}
