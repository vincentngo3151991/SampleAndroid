package thunderivenstudios.sampleandroid.mvp.weather_list;

import android.view.ViewGroup;

import thunderivenstudios.sampleandroid.mvp.base.presenter.BaseRecyclerViewPresenter;
import thunderivenstudios.sampleandroid.mvp.base.recycler_view.BaseRecyclerViewAdapter;
import thunderivenstudios.sampleandroid.mvp.base.recycler_view.BaseRecyclerViewHolder;

/**
 * Created by thunderiven on 8/28/17.
 */

class WeatherListFragmentAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewPresenter> {
    WeatherListFragmentAdapter(BaseRecyclerViewPresenter presenter) {
        super(presenter);
    }

    @Override
    public BaseRecyclerViewHolder<BaseRecyclerViewPresenter> onCreateViewHolder(ViewGroup parent, int viewType) {
        return WeatherListFragmentViewHolder.newInstance(parent, getPresenter());
    }
}
