package dragger2.nuoyuan.com.myapplication.HandleClickListener;

import android.content.Intent;

import dragger2.nuoyuan.com.myapplication.activity.CLickTestActivity;
import dragger2.nuoyuan.com.myapplication.activity.DynamicActivity;
import dragger2.nuoyuan.com.myapplication.activity.IncludeActivity;
import dragger2.nuoyuan.com.myapplication.activity.JumpActivity;
import dragger2.nuoyuan.com.myapplication.activity.ObserverActivity;
import dragger2.nuoyuan.com.myapplication.activity.ResourceTestActivity;
import dragger2.nuoyuan.com.myapplication.activity.TestJumpActivity;
import dragger2.nuoyuan.com.myapplication.activity.ViewStubActivity;

/**
 * 弹出Toash
 */
public class JumpHandler {

    public void jump(JumpActivity view, int index) {
        Class clazz = null;
        switch (index) {
            case 0:
                clazz = TestJumpActivity.class;
                break;
            case 1:
                clazz = CLickTestActivity.class;
                break;
            case 2:
                clazz = DynamicActivity.class;
                break;
            case 3:
                clazz = ObserverActivity.class;
                break;
            case 4:
                clazz = ViewStubActivity.class;
                break;
            case 5:
                clazz = ResourceTestActivity.class;
                break;
            case 6:
                clazz = JumpActivity.class;
                break;
            case 7:
                clazz = IncludeActivity.class;
                break;
            default:
                clazz = JumpActivity.class;
                break;
        }
        view.startActivity(new Intent(view, clazz));
    }
}
