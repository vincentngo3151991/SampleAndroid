package thunderivenstudios.sampleandroid.mvp.weather_list;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import thunderivenstudios.sampleandroid.mvp.base.fragment.BaseRecyclerViewFragment;
import thunderivenstudios.sampleandroid.mvp.base.presenter.BaseRecyclerViewPresenter;
import thunderivenstudios.sampleandroid.mvp.base.recycler_view.BaseRecyclerViewAdapter;

/**
 * Created by thunderiven on 8/28/17.
 */

public class WeatherListFragment extends BaseRecyclerViewFragment<BaseRecyclerViewPresenter, BaseRecyclerViewAdapter> {
    private static final String ZIP_ARGS = "args_zip";

    public static WeatherListFragment newInstance(String zip) {
        Bundle args = new Bundle();
        args.putString(ZIP_ARGS, zip);
        WeatherListFragment fragment = new WeatherListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected BaseRecyclerViewPresenter initPresenter() {
        Bundle args = getArguments();
        return new WeatherListFragmentPresenterImpl(this, args != null ? args.getString(ZIP_ARGS) : "");
    }

    @Override
    protected BaseRecyclerViewAdapter initAdapter() {
        return new WeatherListFragmentAdapter(getPresenter());
    }

    @Override
    protected RecyclerView.LayoutManager initLayoutManager() {
        return new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
    }
}
