package thunderivenstudios.sampleandroid.mvp.base.fragment;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import thunderivenstudios.sampleandroid.R;
import thunderivenstudios.sampleandroid.mvp.base.presenter.BaseRecyclerViewPresenter;
import thunderivenstudios.sampleandroid.mvp.base.recycler_view.BaseRecyclerViewAdapter;
import thunderivenstudios.sampleandroid.mvp.base.view.BaseRecyclerView;

/**
 * Created by thunderiven on 8/28/17.
 */

public abstract class BaseRecyclerViewFragment<P extends BaseRecyclerViewPresenter, A extends BaseRecyclerViewAdapter> extends BaseFragment<P> implements BaseRecyclerView{
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    private A mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = initAdapter();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnbinder.add(ButterKnife.bind(this, view));
        initRecyclerView();
    }

    void initRecyclerView() {
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.LayoutManager layoutManager = initLayoutManager();
        mRecyclerView.setLayoutManager(layoutManager);
    }

    protected @LayoutRes
    int layoutId() {
        return R.layout.fragment_recycler_view;
    }
    protected abstract A initAdapter();
    protected abstract RecyclerView.LayoutManager initLayoutManager();
    protected A getAdapter() {
        return mAdapter;
    }
    protected RecyclerView getRecyclerView() {
        return mRecyclerView;
    }
    //====================================================
    //region BaseRecyclerView
    //====================================================
    @Override
    public void reloadData() {
        if (getAdapter() != null && getRecyclerView() != null) {
            getRecyclerView().post(() -> getAdapter().notifyDataSetChanged());
        }
    }

    @Override
    public void reloadDataAtPosition(int position) {
        if (getAdapter() != null && getRecyclerView() != null) {
            getRecyclerView().post(() -> getAdapter().notifyItemChanged(position));
        }
    }
    //endregion
}
