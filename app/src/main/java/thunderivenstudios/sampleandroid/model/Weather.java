package thunderivenstudios.sampleandroid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thunderiven on 8/28/17.
 */

public class Weather extends BaseModel {
    @SerializedName("dt")
    @Expose
    private long dt;
    @SerializedName("main")
    @Expose
    private WeatherMain mMain;
    @SerializedName("weather")
    @Expose
    private List<WeatherInfo> mWeathers = new ArrayList<>();
    @SerializedName("clouds")
    @Expose
    private Cloud mCloud;
    @SerializedName("rain")
    @Expose
    private Rain mRain;
    @SerializedName("wind")
    @Expose
    private Wind mWind;
    @SerializedName("name")
    @Expose
    private String mName;
    @SerializedName("sys")
    @Expose
    private Sys mSys;
    @SerializedName("dt_txt")
    @Expose
    private String mDateText;

    public long getDt() {
        return dt;
    }

    public WeatherMain getMain() {
        return mMain;
    }

    public List<WeatherInfo> getWeathers() {
        return mWeathers;
    }

    public Cloud getCloud() {
        return mCloud;
    }

    public Rain getRain() {
        return mRain;
    }

    public Wind getWind() {
        return mWind;
    }

    public String getName() {
        return mName;
    }

    public Sys getSys() {
        return mSys;
    }

    public String getDateText() {
        return mDateText;
    }
}
