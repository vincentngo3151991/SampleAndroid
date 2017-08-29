package thunderivenstudios.sampleandroid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by thunderiven on 8/28/17.
 */

public class WeatherInfo extends BaseModel {
    @SerializedName("id")
    @Expose
    private long mId;
    @SerializedName("main")
    @Expose
    private String mMain;
    @SerializedName("description")
    @Expose
    private String mDescription;
    @SerializedName("icon")
    @Expose
    private String mIcon;

    public long getId() {
        return mId;
    }

    public String getMain() {
        return mMain;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getIcon() {
        return mIcon;
    }
}
