package thunderivenstudios.sampleandroid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by thunderiven on 8/28/17.
 */

public class Wind extends BaseModel {
    @SerializedName("speed")
    @Expose
    private double mSpeed;
    @SerializedName("deg")
    @Expose
    private double mDeg;

    public double getSpeed() {
        return mSpeed;
    }

    public double getDeg() {
        return mDeg;
    }
}
