package thunderivenstudios.sampleandroid.mvp.base.activity;

import android.os.Bundle;
import android.support.annotation.AnimRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import thunderivenstudios.sampleandroid.R;
import thunderivenstudios.sampleandroid.mvp.base.fragment.BaseFragment;

/**
 * Created by thunderiven on 8/28/17.
 */

public abstract class SingleFragmentActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.title)
    TextView mTitle;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(this.layoutId());
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            fragment = this.createFragment();

            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }

    protected abstract Fragment createFragment();
    protected @LayoutRes
    int layoutId() {
        return R.layout.activity_single_fragment;
    }

    public void replaceFragment(Fragment fragment, boolean addToBackStack) {
        replaceFragment(fragment, addToBackStack, 0, 0);
    }

    public void replaceFragment(Fragment fragment, boolean addToBackStack, @AnimRes int animationEnter, @AnimRes int animationExit) {
        replaceFragment(fragment, addToBackStack, animationEnter, animationExit, 0, 0);
    }

    public void replaceFragment(Fragment fragment, boolean addToBackStack, @AnimRes int animationEnter, @AnimRes int animationExit, @AnimRes int popEnter, @AnimRes int popExit) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        if (animationEnter != 0 && animationExit != 0) {
            if (popEnter != 0 && popExit != 0) {
                fragmentTransaction.setCustomAnimations(animationEnter, animationExit, popEnter, popExit);
            } else {
                fragmentTransaction.setCustomAnimations(animationEnter, animationExit);
            }
        }
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        if (addToBackStack) fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        if (fragment == null || !(fragment instanceof BaseFragment) || !((BaseFragment) fragment).onBackPressed()) {
            super.onBackPressed(); // If the fragment does not handle backPressed, then let the Activity handles it
        }
    }

    public void popBackStack() {
        FragmentManager fm = getSupportFragmentManager();
        if (!fm.popBackStackImmediate()) {
            finish();
        }
    }

    @Override
    public void setTitle(CharSequence title) {
        if (title != null && title.length() > 0) {
            mTitle.setVisibility(View.VISIBLE);
            mTitle.setText(title);
        } else {
            mTitle.setVisibility(View.GONE);
        }
    }
}
