package dragger2.nuoyuan.com.myapplication.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import dragger2.nuoyuan.com.myapplication.R;
import dragger2.nuoyuan.com.myapplication.bean.Xuser;
import dragger2.nuoyuan.com.myapplication.databinding.IncludetestBinding;

/*
1.给控件制定id ，databind会生成对应成员变量
2.只能嵌套一层
<layout>
<data/>
<Linerlayout/>
</layout>
 */
public class IncludeActivity extends AppCompatActivity {


    private IncludetestBinding clicklistenerBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        clicklistenerBinding = DataBindingUtil.setContentView(this, R.layout.includetest);
        Xuser user = new Xuser("我姓杨", "lastName卫超");
        clicklistenerBinding.setUser(user);

        //设置include
    }

    /**
     * 调整嵌套 item
     *
     * @param view
     */
    public void include(View view) {
        Xuser user = new Xuser("我姓王", "lastName杨明");
        clicklistenerBinding.setUser(user);
        clicklistenerBinding.views.innertext.setText("就是要测试这个类");
    }
}
