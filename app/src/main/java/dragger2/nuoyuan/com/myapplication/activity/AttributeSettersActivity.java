package dragger2.nuoyuan.com.myapplication.activity;

import android.app.Activity;
import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableBoolean;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import dragger2.nuoyuan.com.myapplication.R;
import dragger2.nuoyuan.com.myapplication.databinding.AttrsetActivityBinding;

/**
 * Created by weichyang on 2017/4/17.
 */

public class AttributeSettersActivity extends AppCompatActivity {

    private ObservableBoolean mIsError = new ObservableBoolean();

    private AttrsetActivityBinding attrsetActivityBinding;

    public static Activity activity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        attrsetActivityBinding = DataBindingUtil.setContentView(this, R.layout.attrset_activity);
        setActivity(this);

        /**
         * 转换demo
         */
        setError();
    }

    private void setError() {
        mIsError.set(true);
        attrsetActivityBinding.setIsError(mIsError);
    }

    @BindingAdapter({"imageUrl", "error"})
    public static void loadImage(ImageView view, String url, Drawable error) {
        Glide.with(activity).load(url).into(view);
    }

    public void loading(View view) {
        Toast.makeText(AttributeSettersActivity.this, "Come on", Toast.LENGTH_SHORT).show();
        attrsetActivityBinding.setImageUrl("http://tse4.mm.bing.net/th?id=OIP.MKt6WVLkDWmz5ZKgzujUcwEsEs&w=204&h=201&c=7&qlt=90&o=4&dpr=1.1&pid=1.7");
    }

    public void setActivity(AttributeSettersActivity activity) {
        this.activity = activity;
    }

    @BindingConversion
    public static ColorDrawable convertColorToDrawable(int color) {
        return new ColorDrawable(color);
    }

    public void toggleIsError(View view) {
        mIsError.set(!mIsError.get());
    }
}
