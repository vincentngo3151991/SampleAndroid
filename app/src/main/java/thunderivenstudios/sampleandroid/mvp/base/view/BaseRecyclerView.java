package thunderivenstudios.sampleandroid.mvp.base.view;

/**
 * Created by thunderiven on 8/28/17.
 */

public interface BaseRecyclerView extends BaseFragmentView {
    void reloadData();
    void reloadDataAtPosition(int position);
}
