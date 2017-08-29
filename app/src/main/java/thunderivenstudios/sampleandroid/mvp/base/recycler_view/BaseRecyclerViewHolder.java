package thunderivenstudios.sampleandroid.mvp.base.recycler_view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import thunderivenstudios.sampleandroid.model.BaseModel;
import thunderivenstudios.sampleandroid.mvp.base.presenter.BaseRecyclerViewPresenter;

/**
 * Created by thunderiven on 8/28/17.
 */

public abstract class BaseRecyclerViewHolder<P extends BaseRecyclerViewPresenter> extends RecyclerView.ViewHolder {
    private P mPresenter;

    public BaseRecyclerViewHolder(View itemView, P presenter) {
        super(itemView);
        mPresenter = presenter;
    }

    protected P getPresenter() {
        return mPresenter;
    }

    public void loadData(int position) {}
    public Context getContext() {
        return itemView.getContext();
    }
}
