package thunderivenstudios.sampleandroid.api;

import android.content.Context;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by thunderiven on 8/28/17.
 */

public class ImageLoader {
    public static void configure(Context context) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .build();
        Picasso picasso = new Picasso.Builder(context)
                .downloader(new OkHttp3Downloader(okHttpClient))
                .build();
//        picasso.setLoggingEnabled(true);
        Picasso.setSingletonInstance(picasso);
    }

    public static Picasso with(Context context) {
        return Picasso.with(context);
    }
}
