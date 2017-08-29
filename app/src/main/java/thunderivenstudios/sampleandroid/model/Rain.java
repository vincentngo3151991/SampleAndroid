package thunderivenstudios.sampleandroid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by thunderiven on 8/28/17.
 */

public class Rain extends BaseModel {
    @SerializedName("3h")
    @Expose
    private double mThreeH;

    public double getThreeH() {
        return mThreeH;
    }
}
