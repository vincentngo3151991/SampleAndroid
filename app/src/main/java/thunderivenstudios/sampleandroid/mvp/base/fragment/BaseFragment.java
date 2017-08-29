package thunderivenstudios.sampleandroid.mvp.base.fragment;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashSet;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import thunderivenstudios.sampleandroid.mvp.base.activity.SingleFragmentActivity;
import thunderivenstudios.sampleandroid.mvp.base.presenter.BaseFragmentPresenter;
import thunderivenstudios.sampleandroid.mvp.base.view.BaseFragmentView;

/**
 * Created by thunderiven on 8/28/17.
 */

public abstract class BaseFragment<P extends BaseFragmentPresenter> extends Fragment implements BaseFragmentView {
    protected ProgressDialog mProgressDialog;
    protected P mPresenter;
    protected HashSet<Unbinder> mUnbinder = new HashSet<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.initProgressDialog();
        mPresenter = this.initPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(layoutId(), container, false);
        mUnbinder.add(ButterKnife.bind(this, v));
        return v;
    }

    protected abstract P initPresenter();
    protected abstract @LayoutRes int layoutId();
    public P getPresenter() {
        return mPresenter;
    }

    private void initProgressDialog() {
        mProgressDialog = new ProgressDialog(getActivity());
        mProgressDialog.setCancelable(false);
        mProgressDialog.setIndeterminate(true);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getPresenter().init();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getPresenter().releaseSubscription();
    }

    @Override
    public void onDestroyView() {
        for (Unbinder unbinder : mUnbinder) {
            unbinder.unbind();
        }
        mUnbinder.clear();
        super.onDestroyView();
    }

    public boolean onBackPressed() {
        return false;
    }

    //======================================================
    //region BaseFragmentView
    //======================================================

    @Override
    public void displayMessage(String title, String message, boolean finish) {
        if (getActivity() != null) {
            new AlertDialog.Builder(getActivity())
                    .setTitle(title)
                    .setMessage(message)
                    .setPositiveButton(android.R.string.ok, (dialog, which) -> {
                        dialog.dismiss();
                        if (finish && getActivity() instanceof SingleFragmentActivity) {
                            ((SingleFragmentActivity) getActivity()).popBackStack();
                        }
                    })
                    .setIcon(0)
                    .show();
        }
    }

    @Override
    public void dismissProgressDialog() {
        if (mProgressDialog != null) mProgressDialog.dismiss();
    }

    @Override
    public void displayProgressDialog(String message) {
        if (mProgressDialog != null) {
            mProgressDialog.setMessage(message);
            mProgressDialog.show();
        }
    }

    @Override
    public void popBackStack() {
        if (getActivity() != null && getActivity() instanceof SingleFragmentActivity) {
            ((SingleFragmentActivity) getActivity()).popBackStack();
        }
    }

    @Override
    public void route(Object model) {}

    @Override
    public void setTitle(String title) {
        getActivity().setTitle(title);
    }

    //endregion
}
