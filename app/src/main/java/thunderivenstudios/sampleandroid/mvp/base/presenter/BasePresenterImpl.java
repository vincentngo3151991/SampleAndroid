package thunderivenstudios.sampleandroid.mvp.base.presenter;

import java.lang.annotation.Annotation;
import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.HttpException;
import thunderivenstudios.sampleandroid.api.RetrofitFactory;
import thunderivenstudios.sampleandroid.config.Config;
import thunderivenstudios.sampleandroid.model.Error;
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

    protected Throwable decodedError(Throwable throwable) {
        if (throwable instanceof HttpException) {
            try {
                Converter<ResponseBody, Error> errorConverter =
                        RetrofitFactory.getRetrofit(Config.BASE_URL).responseBodyConverter(Error.class, new Annotation[0]);
                return errorConverter.convert(((HttpException)throwable).response().errorBody());
            } catch (Exception e) {
                return throwable;
            }
        }
        return throwable;
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
