package dragger2.nuoyuan.com.myapplication.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import dragger2.nuoyuan.com.myapplication.R;
import dragger2.nuoyuan.com.myapplication.bean.Xuser;
import dragger2.nuoyuan.com.myapplication.databinding.TestdataactivityBinding;
import dragger2.nuoyuan.com.myapplication.listview.TestListView;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TestdataactivityBinding testdataactivityBinding = DataBindingUtil.setContentView(this, R.layout.testdataactivity);
        Xuser user = new Xuser("Test", "User");
        testdataactivityBinding.setUser(user);
        listView = testdataactivityBinding.litView;

        List arrayList = new ArrayList();

        for (int i = 0; i < 4; i++) {
            try {
                arrayList.add(user.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        listView.setAdapter(new TestListView(arrayList, MainActivity.this));

    }

}

//这些是ormSqlite 的 无视

// public void creatdb(View view) {
//        DatabaseHelper.getHelper(getApplicationContext());
//    }
//
//    public void add(View view) {
//        TestUtils testUtils = new TestUtils();
//        try {
//            String name = editText.getText().toString();
//            testUtils.testAddStudent(name.isEmpty() ? "无名" : name);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void deleName(View view) {
//        StudentDao studentDao = new StudentDao(MyApp.context);
//        try {
//            String name = editText.getText().toString();
//            int result = studentDao.deleteByName(name.isEmpty() ? "无名" : name);
//            Toast.makeText(this, result + "", 1000).show();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 查询学生成绩
//     *
//     * @param view
//     */
//    public void query(View view) {
//        TestUtils testUtils = new TestUtils();
//        try {
//            TextView textView = (TextView) findViewById(R.id.result);
//            textView.setText(testUtils.querystudentDao());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
