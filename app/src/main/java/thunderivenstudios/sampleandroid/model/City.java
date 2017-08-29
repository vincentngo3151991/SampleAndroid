package thunderivenstudios.sampleandroid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by thunderiven on 8/28/17.
 */

public class City extends BaseModel {
    @SerializedName("id")
    @Expose
    private long mId;
    @SerializedName("name")
    @Expose
    private String mName;
    @SerializedName("country")
    @Expose
    private String mCountry;
    @SerializedName("population")
    @Expose
    private long mPopulation;

    public long getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getCountry() {
        return mCountry;
    }

    public long getPopulation() {
        return mPopulation;
    }
}
