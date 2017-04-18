package dragger2.nuoyuan.com.myapplication.bean;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

/**
 * Created by weichyang on 2017/4/17.
 */

public class StaticUser {
    public final ObservableField<String> firstName =
            new ObservableField<>();
    public final ObservableField<String> lastName =
            new ObservableField<>();
    public final ObservableInt age = new ObservableInt();

}
