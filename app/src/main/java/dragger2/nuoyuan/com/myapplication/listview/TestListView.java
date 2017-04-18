package dragger2.nuoyuan.com.myapplication.listview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import dragger2.nuoyuan.com.myapplication.R;
import dragger2.nuoyuan.com.myapplication.bean.Xuser;
import dragger2.nuoyuan.com.myapplication.databinding.TestItemBinding;

/**
 * Created by weichyang on 2017/4/14.
 */

public class TestListView extends BaseAdapter {

    public List<Xuser> arrayList = new ArrayList<>();

    public Context context;

    public TestListView(List arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TestItemBinding testItemBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.test_item, null, false);
        Xuser xuser = arrayList.get(position);
        testItemBinding.setUser(xuser);
        return testItemBinding.getRoot();
    }
}
