package thunderivenstudios.sampleandroid.mvp.base.view;

/**
 * Created by thunderiven on 8/28/17.
 */

public interface BaseFragmentView extends BaseView {
    void displayMessage(String title, String message, boolean finish);
    void displayProgressDialog(String message);
    void dismissProgressDialog();
    void popBackStack();
    void route(Object model);
    void setTitle(String Title);
}
