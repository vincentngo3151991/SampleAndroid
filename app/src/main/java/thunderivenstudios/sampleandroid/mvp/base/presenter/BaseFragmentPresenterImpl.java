package thunderivenstudios.sampleandroid.mvp.base.presenter;

import android.support.annotation.IdRes;

import thunderivenstudios.sampleandroid.mvp.base.view.BaseFragmentView;

/**
 * Created by thunderiven on 8/28/17.
 */

public class BaseFragmentPresenterImpl<V extends BaseFragmentView> extends BasePresenterImpl<V> implements BaseFragmentPresenter {
    public BaseFragmentPresenterImpl(V view) {
        super(view);
    }

    protected void displayError(Throwable throwable) {
        displayMessage("Error", throwable.getMessage());
    }

    protected void displayMessage(String title, String message) {
        if (getView() != null) {
            getView().dismissProgressDialog();
            getView().displayMessage(title, message);
        }
    }

    protected void route(Object model) {
        if (getView() != null) {
            getView().route(model);
        }
    }

    //======================================================
    //region BaseFragmentPresenter
    //======================================================
    @Override
    public void onTextChanged(@IdRes int viewId, int position, String text) {}

    @Override
    public void onViewClicked(@IdRes int viewId, int position) {}
    //endregion
}
