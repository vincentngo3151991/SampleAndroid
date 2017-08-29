package thunderivenstudios.sampleandroid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thunderiven on 8/28/17.
 */

public class Weathers extends BaseModel {
    @SerializedName("cod")
    @Expose
    private String mCode;
    @SerializedName("list")
    @Expose
    private List<Weather> mWeathers = new ArrayList<>();
    @SerializedName("city")
    @Expose
    private City mCity;
    @SerializedName("message")
    @Expose
    private String mMessage;

    public String getCode() {
        return mCode;
    }

    public List<Weather> getWeathers() {
        return mWeathers;
    }

    public City getCity() {
        return mCity;
    }

    public String getMessage() {
        return mMessage;
    }
}
