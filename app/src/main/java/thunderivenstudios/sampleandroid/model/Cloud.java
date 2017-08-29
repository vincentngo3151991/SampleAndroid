package thunderivenstudios.sampleandroid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by thunderiven on 8/28/17.
 */

public class Cloud extends BaseModel {
    @SerializedName("all")
    @Expose
    private double mAll;

    public double getAll() {
        return mAll;
    }
}
