package dragger2.nuoyuan.com.myapplication.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dragger2.nuoyuan.com.myapplication.R;
import dragger2.nuoyuan.com.myapplication.databinding.ListDatabindActivityBinding;

public class ListDataBindingTestActivity extends AppCompatActivity {

    public String var1 = "firstName";
    public String var2 = "lastName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListDatabindActivityBinding databindTest = DataBindingUtil.setContentView(this, R.layout.list_databind_activity);
        List testList = new ArrayList();
        testList.add("我是list1数据");
        testList.add("我是list2数据");
        databindTest.setList(testList);


        SparseArray sparseArray = new SparseArray<>(2);
        sparseArray.put(0, "sparseArray1");
        sparseArray.put(1, "sparseArray2");
        databindTest.setSparse(sparseArray);

        Map<String, String> map = new HashMap<>();
        map.put(var1, "人民银行");
        map.put(var2, "人民银行2");
        databindTest.setMap(map);

        databindTest.setIndex(0); //设置布局里面index角标
        databindTest.setKey(var1);//设置布局里面的key 值

    }
}
