package thunderivenstudios.sampleandroid.mvp.base.presenter;

import android.support.annotation.IdRes;

/**
 * Created by thunderiven on 8/28/17.
 */

public interface BaseFragmentPresenter extends BasePresenter {
    void onTextChanged(@IdRes int viewId, int position, String text);
    void onViewClicked(@IdRes int viewId, int position);
}
