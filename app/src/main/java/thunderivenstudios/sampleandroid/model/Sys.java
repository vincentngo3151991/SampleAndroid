package thunderivenstudios.sampleandroid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.Streams;

/**
 * Created by thunderiven on 8/28/17.
 */

public class Sys extends BaseModel {
   @SerializedName("type")
    @Expose
    private int mType;
    @SerializedName("id")
    @Expose
    private long mId;
    @SerializedName("message")
    @Expose
    private double mMessage;
    @SerializedName("country")
    @Expose
    private String mCountry;
    @SerializedName("sunrise")
    @Expose
    private long mSunrise;
    @SerializedName("sunset")
    @Expose
    private long mSunset;

    public int getType() {
        return mType;
    }

    public long getId() {
        return mId;
    }

    public double getMessage() {
        return mMessage;
    }

    public String getCountry() {
        return mCountry;
    }

    public long getSunrise() {
        return mSunrise;
    }

    public long getSunset() {
        return mSunset;
    }
}
