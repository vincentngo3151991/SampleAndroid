package thunderivenstudios.sampleandroid.mvp.base.presenter;

import thunderivenstudios.sampleandroid.model.BaseModel;

/**
 * Created by thunderiven on 8/28/17.
 */

public interface BaseRecyclerViewPresenter extends BaseFragmentPresenter {
    int getNumberOfRow();
    BaseModel getModelAtPosition(int section, int row);
    void reloadData();
    void loadMore(int page);
    int getViewHolderViewType(int position);
}
