package thunderivenstudios.sampleandroid.application;

import android.app.Application;

import thunderivenstudios.sampleandroid.api.ImageLoader;

/**
 * Created by thunderiven on 8/28/17.
 */

public class SampleApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoader.configure(this);
    }
}
