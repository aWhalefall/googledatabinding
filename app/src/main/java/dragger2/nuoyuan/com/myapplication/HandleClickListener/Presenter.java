package dragger2.nuoyuan.com.myapplication.HandleClickListener;

import android.content.Context;
import android.widget.Toast;

import dragger2.nuoyuan.com.myapplication.MyApp;
import dragger2.nuoyuan.com.myapplication.bean.Xuser;

public class Presenter {
    public void onSaveClick(Xuser task) {

        Toast.makeText(MyApp.context, task.getFirstName(), 500).show();

    }

    public void onSaveClick(Context context) {

        Toast.makeText(MyApp.context, "dddddd", 500).show();

    }
}