package dragger2.nuoyuan.com.myapplication.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;

import dragger2.nuoyuan.com.myapplication.R;
import dragger2.nuoyuan.com.myapplication.bean.Xuser;
import dragger2.nuoyuan.com.myapplication.databinding.TestItemBinding;
import dragger2.nuoyuan.com.myapplication.databinding.ViewStubActivityBinding;

public class ViewStubActivity extends AppCompatActivity {


    private ViewStubActivityBinding viewStubActivityBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewStubActivityBinding = DataBindingUtil.setContentView(this, R.layout.view_stub_activity);
        //viewStubActivityBinding.viewStub.setContainingBinding();
        viewStubActivityBinding.viewStub.setOnInflateListener(new ViewStub.OnInflateListener() {
            @Override
            public void onInflate(ViewStub stub, View inflated) {
                TestItemBinding testItemBinding = DataBindingUtil.bind(inflated);
                Xuser xuser = new Xuser("ViewStubTest", "开始测试LastName");
                testItemBinding.setUser(xuser);
            }
        });

    }

    public void LoadingViewStub(View view) {
        if (!viewStubActivityBinding.viewStub.isInflated()) {
            viewStubActivityBinding.viewStub.getViewStub().inflate();
        }
    }
}
