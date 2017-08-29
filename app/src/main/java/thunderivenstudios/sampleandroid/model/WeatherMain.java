package thunderivenstudios.sampleandroid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by thunderiven on 8/28/17.
 */

public class WeatherMain extends BaseModel {
    @SerializedName("temp")
    @Expose
    private double mTemp;
    @SerializedName("temp_min")
    @Expose
    private double mTempMin;
    @SerializedName("temp_max")
    @Expose
    private double mTempMax;
    @SerializedName("pressure")
    @Expose
    private double mPressure;
    @SerializedName("sea_level")
    @Expose
    private double mSeaLevel;
    @SerializedName("grnd_level")
    @Expose
    private double mGroundLevel;
    @SerializedName("humidity")
    @Expose
    private double mHumidity;
    @SerializedName("temp_kf")
    @Expose
    private double mTempKF;

    public double getTemp() {
        return mTemp;
    }

    public double getTempMin() {
        return mTempMin;
    }

    public double getTempMax() {
        return mTempMax;
    }

    public double getPressure() {
        return mPressure;
    }

    public double getSeaLevel() {
        return mSeaLevel;
    }

    public double getGroundLevel() {
        return mGroundLevel;
    }

    public double getHumidity() {
        return mHumidity;
    }

    public double getTempKF() {
        return mTempKF;
    }
}
