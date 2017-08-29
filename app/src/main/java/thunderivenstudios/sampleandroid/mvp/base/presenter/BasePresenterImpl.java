package thunderivenstudios.sampleandroid.mvp.base.presenter;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import thunderivenstudios.sampleandroid.mvp.base.view.BaseView;

/**
 * Created by thunderiven on 8/28/17.
 */

public class BasePresenterImpl<V extends BaseView> implements BasePresenter {
    protected WeakReference<V> mView;
    protected CompositeDisposable mDisposable = new CompositeDisposable();

    public BasePresenterImpl(V view) {
        mView = new WeakReference<>(view);
    }

    protected V getView() {
        if (mView != null) {
            return mView.get();
        }
        return null;
    }

    @Override
    public void init() {}

    @Override
    public void releaseSubscription() {
        if (mDisposable != null && !mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
        mDisposable = new CompositeDisposable();
    }
}
