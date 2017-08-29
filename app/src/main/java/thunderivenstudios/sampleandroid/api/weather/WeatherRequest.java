package thunderivenstudios.sampleandroid.api.weather;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.schedulers.ScheduledRunnable;
import io.reactivex.schedulers.Schedulers;
import thunderivenstudios.sampleandroid.api.RetrofitFactory;
import thunderivenstudios.sampleandroid.config.Config;
import thunderivenstudios.sampleandroid.model.Weathers;

/**
 * Created by thunderiven on 8/28/17.
 */

public class WeatherRequest {
    public Observable<Weathers> getWeather(String zip) {
        return RetrofitFactory.getRetrofit(Config.BASE_URL)
                .create(WeatherService.class)
                .getWeather("metric", zip, Config.API_KEY)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
