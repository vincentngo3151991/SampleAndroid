package thunderivenstudios.sampleandroid.mvp.base.recycler_view;

import android.support.v7.widget.RecyclerView;

import thunderivenstudios.sampleandroid.mvp.base.presenter.BaseRecyclerViewPresenter;

/**
 * Created by thunderiven on 8/28/17.
 */

public abstract class BaseRecyclerViewAdapter<P extends BaseRecyclerViewPresenter> extends RecyclerView.Adapter<BaseRecyclerViewHolder<P>> {
    private P mPresenter;

    protected BaseRecyclerViewAdapter(P presenter) {
        mPresenter = presenter;
    }

    protected P getPresenter() {
        return mPresenter;
    }

    @Override
    public void onBindViewHolder(BaseRecyclerViewHolder<P> holder, int position) {
        holder.loadData(position);
    }

    @Override
    public int getItemCount() {
        return mPresenter.getNumberOfRow();
    }
}
