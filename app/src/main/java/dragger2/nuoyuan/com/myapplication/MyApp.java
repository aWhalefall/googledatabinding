package dragger2.nuoyuan.com.myapplication;

import android.app.Application;
import android.content.Context;

/**
 * Created by weichyang on 2017/4/13.
 */

public class MyApp extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context getInstance() {
        return context;
    }
}
