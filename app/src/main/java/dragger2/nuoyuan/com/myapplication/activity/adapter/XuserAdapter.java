//package dragger2.nuoyuan.com.myapplication.activity.adapter;
//
//import android.databinding.DataBindingUtil;
//import android.support.annotation.NonNull;
//import android.support.v7.app.AlertController;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import dragger2.nuoyuan.com.myapplication.bean.User;
//
///**
// * Created by weichyang on 2017/4/17.
// */
//
//public class XuserAdapter extends AlertController.RecycleListView.Adapter<XuserAdapter.UserAdapter.UserHolder> {
//
//    /**
//     * Created by rufi on 6/5/15.
//     */
//    private static final int USER_COUNT = 10;
//
//    @NonNull
//    private List<User> mUsers;
//
//    public UserAdapter() {
//        mUsers = new ArrayList<>(10);
//        for (int i = 0; i < USER_COUNT; i++) {
//            User user = new User(Randoms.nextFirstName(), Randoms.nextLastName());
//            mUsers.add(user);
//        }
//    }
//
//    public static class UserHolder extends RecyclerView.ViewHolder {
//        private UserItemBinding mBinding;
//
//        public UserHolder(View itemView) {
//            super(itemView);
//            mBinding = DataBindingUtil.bind(itemView);
//        }
//
//        public void bind(@NonNull User user) {
//            mBinding.setUser(user);
//        }
//    }
//
//    @Override
//    public UserHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
//        View itemView = LayoutInflater.from(viewGroup.getContext())
//                .inflate(R.layout.user_item, viewGroup, false);
//        return new UserHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(UserHolder holder, int position) {
//        holder.bind(mUsers.get(position));
//    }
//
//    @Override
//    public int getItemCount() {
//        return mUsers.size();
//    }
//}
//
