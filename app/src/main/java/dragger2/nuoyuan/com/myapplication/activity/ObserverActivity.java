package dragger2.nuoyuan.com.myapplication.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayMap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import dragger2.nuoyuan.com.myapplication.R;
import dragger2.nuoyuan.com.myapplication.bean.AnnoTationUser;
import dragger2.nuoyuan.com.myapplication.bean.StaticUser;
import dragger2.nuoyuan.com.myapplication.databinding.OberserTestBinding;

public class ObserverActivity extends AppCompatActivity {

    public AnnoTationUser anoUser = new AnnoTationUser();
    public StaticUser staticUser = new StaticUser();
    public OberserTestBinding binding;

    ObservableArrayMap<String, Object> user = new ObservableArrayMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.oberser_test);

        defaultValue();


    }

    private void defaultValue() {
        anoUser.setFirstName("杨");
        anoUser.setLastName("xxx");
        binding.setUser(anoUser);


        staticUser.firstName.set("杨家");
        staticUser.lastName.set("xxx");
        staticUser.age.set(27);

        binding.setStaticuser(staticUser);


        user.put("firstName", "Google");
        user.put("lastName", "Inc.");
        user.put("age", 17);
        binding.setUserMAP(user);
    }

    private void setOtherName() {
        anoUser.setFirstName("wang");
        anoUser.setLastName("xxx");
        binding.setUser(anoUser);


        staticUser.firstName.set("王家");
        staticUser.lastName.set("xxx");
        staticUser.age.set(25);

        binding.setStaticuser(staticUser);


        user.put("firstName", "诺远");
        user.put("lastName", "NY");
        user.put("age", 2);
        binding.setUserMAP(user);
    }


    public void setOtherName(View view) {
        setOtherName();
    }

    public void setDefaultName(View view) {
        defaultValue();
    }
}
