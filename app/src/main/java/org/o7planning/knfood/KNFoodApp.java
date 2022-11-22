package org.o7planning.knfood;

import android.app.Application;

public class KNFoodApp extends Application {
    private static KNFoodApp instance;

    public static KNFoodApp getInstance() {
        if(instance == null) instance = new KNFoodApp();
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
