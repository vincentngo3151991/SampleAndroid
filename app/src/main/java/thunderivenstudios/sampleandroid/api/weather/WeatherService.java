package thunderivenstudios.sampleandroid.api.weather;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import thunderivenstudios.sampleandroid.model.Weathers;

/**
 * Created by thunderiven on 8/28/17.
 */

interface WeatherService {
    @GET("forecast")
    Observable<Weathers> getWeather(@Query("units") String unit, @Query("zip") String zip, @Query("appid") String apiKey);
}
