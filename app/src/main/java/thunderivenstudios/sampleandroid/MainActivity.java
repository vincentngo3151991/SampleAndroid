package thunderivenstudios.sampleandroid;

import android.support.v4.app.Fragment;

import thunderivenstudios.sampleandroid.mvp.base.activity.SingleFragmentActivity;
import thunderivenstudios.sampleandroid.mvp.main.MainFragment;

public class MainActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new MainFragment();
    }
}
