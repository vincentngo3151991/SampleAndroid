package thunderivenstudios.sampleandroid.mvp.main;

import thunderivenstudios.sampleandroid.mvp.base.view.BaseFragmentView;

/**
 * Created by thunderiven on 8/28/17.
 */

interface MainFragmentView extends BaseFragmentView {
    void openWeatherList(String zip);
}
