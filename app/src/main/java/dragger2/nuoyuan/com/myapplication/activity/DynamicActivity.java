package dragger2.nuoyuan.com.myapplication.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import dragger2.nuoyuan.com.myapplication.R;
import dragger2.nuoyuan.com.myapplication.activity.adapter.MyAdapter;
import dragger2.nuoyuan.com.myapplication.databinding.DynamicActivityBinding;

/**
 * Created by weichyang on 2017/4/17.
 */

public class DynamicActivity extends AppCompatActivity {

    private LinearLayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DynamicActivityBinding dynamicActivityBinding = DataBindingUtil.setContentView(this, R.layout.dynamic_activity);

        mRecyclerView = dynamicActivityBinding.recycleListview;
//创建默认的线性LayoutManager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
//如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mRecyclerView.setHasFixedSize(true);
//创建并设置Adapter
        mAdapter = new MyAdapter(getDummyDatas());
        mRecyclerView.setAdapter(mAdapter);

    }


    public String[] getDummyDatas() {

        String[] str = new String[10];
        for (int i = 0; i < 10; i++) {
            str[i] = i + "first Data";
        }
        return str;
    }
}
