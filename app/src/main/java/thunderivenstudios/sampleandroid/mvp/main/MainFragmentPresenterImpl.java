package thunderivenstudios.sampleandroid.mvp.main;

import android.support.annotation.IdRes;

import thunderivenstudios.sampleandroid.mvp.base.presenter.BaseFragmentPresenterImpl;

/**
 * Created by thunderiven on 8/28/17.
 */

class MainFragmentPresenterImpl extends BaseFragmentPresenterImpl<MainFragmentView> {
    private String mZip = "";

    MainFragmentPresenterImpl(MainFragmentView view) {
        super(view);
    }

    @Override
    public void onTextChanged(@IdRes int viewId, int position, String text) {
        mZip = text;
    }

    @Override
    public void onViewClicked(@IdRes int viewId, int position) {
        if (getView() != null) {
            getView().openWeatherList(mZip);
        }
    }
}
