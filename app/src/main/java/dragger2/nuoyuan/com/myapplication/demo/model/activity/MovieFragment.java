package dragger2.nuoyuan.com.myapplication.demo.model.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dragger2.nuoyuan.com.myapplication.R;
import dragger2.nuoyuan.com.myapplication.databinding.MovieFragmentBinding;
import dragger2.nuoyuan.com.myapplication.demo.model.viewmodel.MainViewModel;


/**
 * Created by HaohaoChang on 2017/2/11.
 */
public class MovieFragment extends Fragment implements CompletedListener, SwipeRefreshLayout.OnRefreshListener {

    private static String TAG = MovieFragment.class.getSimpleName();
    private MainViewModel viewModel;
    private MovieFragmentBinding movieFragmentBinding;
    private MovieAdapter movieAdapter;

    public static MovieFragment getInstance() {
        return new MovieFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movie_fragment, container, false);
        movieFragmentBinding = MovieFragmentBinding.bind(view);
        initData();
        return view;
    }

    private void initData() {
        movieAdapter = new MovieAdapter();
        movieFragmentBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        movieFragmentBinding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        movieFragmentBinding.recyclerView.setAdapter(movieAdapter);

        movieFragmentBinding.swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark);
        movieFragmentBinding.swipeRefreshLayout.setOnRefreshListener(this);

        viewModel = new MainViewModel(movieAdapter, this);
        movieFragmentBinding.setViewModel(viewModel);

    }

    @Override
    public void onRefresh() {
        movieAdapter.clearItems();
        viewModel.refreshData();
    }

    @Override
    public void onCompleted() {
        if (movieFragmentBinding.swipeRefreshLayout.isRefreshing()) {
            movieFragmentBinding.swipeRefreshLayout.setRefreshing(false);
        }
    }
}
