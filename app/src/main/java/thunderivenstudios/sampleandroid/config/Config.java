package thunderivenstudios.sampleandroid.config;

/**
 * Created by thunderiven on 8/28/17.
 */

public final class Config {
    public static final String API_KEY = "06eddad5bed8b4469e1bf52f9efdc4ca";
    public static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";

    public static String iconUrl(String icon) {
        return "https://openweathermap.org/img/w/" + icon + ".png";
    }
}
