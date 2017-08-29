package thunderivenstudios.sampleandroid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by thunderiven on 8/28/17.
 */

public class BaseModel implements Serializable{
    @SerializedName("cod")
    @Expose
    private String mCode;
    @SerializedName("message")
    @Expose
    private String mMessage;

    public String getCode() {
        return mCode;
    }

    public String getMessage() {
        return mMessage;
    }
}
