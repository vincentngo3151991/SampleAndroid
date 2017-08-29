package thunderivenstudios.sampleandroid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by thunderiven on 8/28/17.
 */

public class Error extends Throwable {
    @SerializedName("cod")
    @Expose
    String code;
    @SerializedName("message")
    @Expose
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getLocalizedMessage() {
        return getMessage();
    }

    public String getCode() {
        return code;
    }
}
