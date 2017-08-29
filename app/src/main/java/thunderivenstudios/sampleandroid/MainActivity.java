package thunderivenstudios.sampleandroid;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import thunderivenstudios.sampleandroid.mvp.base.activity.SingleFragmentActivity;
import thunderivenstudios.sampleandroid.mvp.main.MainFragment;

public class MainActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new MainFragment();
    }
}
