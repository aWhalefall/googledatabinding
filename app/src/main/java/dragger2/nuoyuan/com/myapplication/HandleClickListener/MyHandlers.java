package dragger2.nuoyuan.com.myapplication.HandleClickListener;

import android.view.View;
import android.widget.Toast;

import dragger2.nuoyuan.com.myapplication.MyApp;

/**
 * 弹出Toash
 */
public class MyHandlers {
    public void onClickFriend(View view) {
        Toast.makeText(MyApp.context, "dataBinding", 500).show();
    }
}