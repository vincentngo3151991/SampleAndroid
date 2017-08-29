package thunderivenstudios.sampleandroid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thunderiven on 8/28/17.
 */

public class Weathers extends BaseModel {

    @SerializedName("list")
    @Expose
    private List<Weather> mWeathers = new ArrayList<>();
    @SerializedName("city")
    @Expose
    private City mCity;

    public List<Weather> getWeathers() {
        return mWeathers;
    }

    public City getCity() {
        return mCity;
    }
}
