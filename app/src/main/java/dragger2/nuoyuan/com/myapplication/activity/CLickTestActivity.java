package dragger2.nuoyuan.com.myapplication.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import dragger2.nuoyuan.com.myapplication.HandleClickListener.MyHandlers;
import dragger2.nuoyuan.com.myapplication.HandleClickListener.Presenter;
import dragger2.nuoyuan.com.myapplication.R;
import dragger2.nuoyuan.com.myapplication.bean.Xuser;
import dragger2.nuoyuan.com.myapplication.databinding.ClicklistenerBinding;

public class CLickTestActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ClicklistenerBinding clicklistenerBinding = DataBindingUtil.setContentView(this, R.layout.clicklistener);
        Xuser user = new Xuser("Test", "User");
        Presenter presenter = new Presenter();
        clicklistenerBinding.setClick(presenter);
        clicklistenerBinding.setHandler(new MyHandlers());
        clicklistenerBinding.setUser(user);

    }
}
