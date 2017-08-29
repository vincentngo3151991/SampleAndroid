package thunderivenstudios.sampleandroid.mvp.base.presenter;

import thunderivenstudios.sampleandroid.model.BaseModel;
import thunderivenstudios.sampleandroid.mvp.base.view.BaseRecyclerView;

/**
 * Created by thunderiven on 8/28/17.
 */

public class BaseRecyclerViewPresenterImpl <V extends BaseRecyclerView> extends BaseFragmentPresenterImpl<V> implements BaseRecyclerViewPresenter {
    public BaseRecyclerViewPresenterImpl(V view) {
        super(view);
    }

    @Override
    public int getNumberOfRow() {
        return 0;
    }

    @Override
    public BaseModel getModelAtPosition(int section, int row) {
        return null;
    }

    @Override
    public void reloadData() {
        if (getView() != null) {
            getView().dismissProgressDialog();
            getView().reloadData();
        }
    }

    @Override
    public void loadMore(int page) {

    }

    @Override
    public int getViewHolderViewType(int position) {
        return 0;
    }
}
