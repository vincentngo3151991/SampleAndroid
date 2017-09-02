package thunderivenstudios.sampleandroid.mvp.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import thunderivenstudios.sampleandroid.R;
import thunderivenstudios.sampleandroid.mvp.base.activity.SingleFragmentActivity;
import thunderivenstudios.sampleandroid.mvp.base.fragment.BaseFragment;
import thunderivenstudios.sampleandroid.mvp.base.presenter.BaseFragmentPresenter;
import thunderivenstudios.sampleandroid.mvp.weather_list.WeatherListFragment;

/**
 * Created by thunderiven on 8/28/17.
 */

public class MainFragment extends BaseFragment<BaseFragmentPresenter> implements MainFragmentView{
    @BindView(R.id.zip_code)
    EditText mZipCodeET;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnbinder.add(ButterKnife.bind(this, view));
        mZipCodeET.setOnKeyListener((view1, i, keyEvent) -> {
            if (keyEvent.getAction() == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER) {
                onSearchClicked(view1);
                return true;
            }
            return false;
        });
    }

    @OnTextChanged(R.id.zip_code)
    void onTextChanged(CharSequence text) {
        getPresenter().onTextChanged(0,0, text.toString());
    }

    @OnClick(R.id.search)
    void onSearchClicked(View v) {
        getPresenter().onViewClicked(v.getId(), 0);
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public void onResume() {
        super.onResume();
        setTitle("forecast");
    }

    @Override
    protected BaseFragmentPresenter initPresenter() {
        return new MainFragmentPresenterImpl(this);
    }

    @Override
    public void openWeatherList(String zip) {
        if (getActivity() instanceof SingleFragmentActivity) {
            ((SingleFragmentActivity) getActivity()).replaceFragmentWithAnimation(WeatherListFragment.newInstance(zip), true);
        }
    }
}
