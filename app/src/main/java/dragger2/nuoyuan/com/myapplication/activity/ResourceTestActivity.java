package dragger2.nuoyuan.com.myapplication.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import dragger2.nuoyuan.com.myapplication.R;
import dragger2.nuoyuan.com.myapplication.databinding.ResourceTestBinding;

public class ResourceTestActivity extends AppCompatActivity {

    public String var1 = "firstName";
    public String var2 = "lastName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ResourceTestBinding binding = DataBindingUtil.setContentView(this, R.layout.resource_test);

        binding.setLarge(true);

        binding.setFirstName("中国");
        binding.setLastName("人民银行");

        binding.setBananaCount(2);
        binding.setOrangeCount(1);
        binding.setOrangeCount(10);

    }
}
