package thunderivenstudios.sampleandroid.mvp.weather_list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import thunderivenstudios.sampleandroid.R;
import thunderivenstudios.sampleandroid.api.ImageLoader;
import thunderivenstudios.sampleandroid.config.Config;
import thunderivenstudios.sampleandroid.model.Weather;
import thunderivenstudios.sampleandroid.model.WeatherInfo;
import thunderivenstudios.sampleandroid.model.WeatherMain;
import thunderivenstudios.sampleandroid.mvp.base.presenter.BaseRecyclerViewPresenter;
import thunderivenstudios.sampleandroid.mvp.base.recycler_view.BaseRecyclerViewHolder;

/**
 * Created by thunderiven on 8/28/17.
 */

 class WeatherListFragmentViewHolder extends BaseRecyclerViewHolder<BaseRecyclerViewPresenter> {
    @BindView(R.id.date)
    TextView mDate;
    @BindView(R.id.description)
    TextView mDescription;
    @BindView(R.id.high)
    TextView mHigh;
    @BindView(R.id.low)
    TextView mLow;
    @BindView(R.id.thumbnail)
    ImageView mThumbnail;
    private WeatherListFragmentViewHolder(View itemView, BaseRecyclerViewPresenter presenter) {
        super(itemView, presenter);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void loadData(int position) {
        Weather weather = (Weather)getPresenter().getModelAtPosition(0, position);
        if (weather != null) {
            mDate.setText(weather.getDateText());
            WeatherMain main = weather.getMain();
            if (main != null) {
                mHigh.setText(getContext().getString(R.string.high_string, main.getTempMax()));
                mLow.setText(getContext().getString(R.string.low_string, main.getTempMin()));
            }
            if (weather.getWeathers().size() < 1) return;
            WeatherInfo info = weather.getWeathers().get(0);
            if (info != null) {
                mDescription.setText(info.getDescription());
                ImageLoader.with(getContext())
                        .load(Config.iconUrl(info.getIcon()))
                        .fit()
                        .centerInside()
                        .into(mThumbnail);
            }
        }
    }

    static WeatherListFragmentViewHolder newInstance(ViewGroup parent, BaseRecyclerViewPresenter presenter) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vh_weather_list, parent, false);
        return new WeatherListFragmentViewHolder(v, presenter);
    }
}
