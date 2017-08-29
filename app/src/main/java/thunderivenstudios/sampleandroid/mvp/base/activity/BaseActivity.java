package thunderivenstudios.sampleandroid.mvp.base.activity;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by thunderiven on 8/28/17.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
    }

    public void setSubtitle(CharSequence subtitle) {}
}
