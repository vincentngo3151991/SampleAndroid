package thunderivenstudios.sampleandroid.mvp.weather_list;

import java.util.Locale;

import thunderivenstudios.sampleandroid.api.weather.WeatherRequest;
import thunderivenstudios.sampleandroid.model.BaseModel;
import thunderivenstudios.sampleandroid.model.City;
import thunderivenstudios.sampleandroid.model.Weathers;
import thunderivenstudios.sampleandroid.mvp.base.presenter.BaseRecyclerViewPresenterImpl;
import thunderivenstudios.sampleandroid.mvp.base.view.BaseRecyclerView;

/**
 * Created by thunderiven on 8/28/17.
 */

class WeatherListFragmentPresenterImpl extends BaseRecyclerViewPresenterImpl<BaseRecyclerView> {
    private Weathers mWeathers;
    private String mZip;
    WeatherListFragmentPresenterImpl(BaseRecyclerView view, String zip) {
        super(view);
        mZip = zip;
    }

    @Override
    public void init() {
        mDisposable.add(
                WeatherRequest.getWeather(mZip)
                        .filter(weathers -> weathers != null)
                        .subscribe(weathers -> {
                            if ("200".equalsIgnoreCase(weathers.getCode())) {
                                mWeathers = weathers;
                                reloadData();
                                City city = weathers.getCity();
                                if (city != null && getView() != null) {
                                    getView().setTitle(String.format(Locale.US, "%s, %s", city.getName(), city.getCountry()));
                                }
                            } else {
                                getView().displayMessage("error", weathers.getMessage(), true);
                            }
                        }, this::displayError)
        );
    }

    @SuppressWarnings("ThrowableResultOfMethodCallIgnored")
    @Override
    protected void displayError(Throwable throwable) {
        displayMessage("Error", decodedError(throwable).getLocalizedMessage(), true);
    }

    @Override
    public int getNumberOfRow() {
        return mWeathers != null ? mWeathers.getWeathers().size() : 0;
    }

    @Override
    public BaseModel getModelAtPosition(int section, int row) {
        return mWeathers != null ? mWeathers.getWeathers().get(row) : null;
    }
}
