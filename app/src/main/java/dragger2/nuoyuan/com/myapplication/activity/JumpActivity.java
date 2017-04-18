package dragger2.nuoyuan.com.myapplication.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import dragger2.nuoyuan.com.myapplication.HandleClickListener.JumpHandler;
import dragger2.nuoyuan.com.myapplication.HandleClickListener.MyHandlers;
import dragger2.nuoyuan.com.myapplication.R;
import dragger2.nuoyuan.com.myapplication.databinding.JumpActivityBinding;

/**
 *
 *
 */

public class JumpActivity extends AppCompatActivity {


    public int index = 0;
    private JumpActivityBinding jumpActivityBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        jumpActivityBinding = DataBindingUtil.setContentView(this, R.layout.jump_activity);
        jumpActivityBinding.setJump(new JumpHandler());
        jumpActivityBinding.setContext(this);
        jumpActivityBinding.setIndex(index);
        jumpActivityBinding.setHandlers(new MyHandlers());
    }

    public void openIncludes(View view) {
        startActivity(new Intent(this, IncludeActivity.class));
    }

    public void openCollections(View view) {
        startActivity(new Intent(this, ListDataBindingTestActivity.class));
    }


    public void openResources(View view) {
        startActivity(new Intent(this, ResourceTestActivity.class));
    }

    public void openObservable(View view) {
        startActivity(new Intent(this, ObserverActivity.class));
    }


    public void openViewStub(View view) {
        startActivity(new Intent(this, ViewStubActivity.class));
    }

    public void openDynamicVariables(View view) {
        startActivity(new Intent(this, DynamicActivity.class));
    }

    public void openAttributeSetters(View view) {
        startActivity(new Intent(this, AttributeSettersActivity.class));
    }
}
