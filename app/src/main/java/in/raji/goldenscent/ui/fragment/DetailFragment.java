package in.raji.goldenscent.ui.fragment;

import in.raji.goldenscent.R;
import in.raji.goldenscent.databinding.FragmentDetailBinding;
import in.raji.goldenscent.viewmodel.DetailViewModel;

/**
 * Created by Raji on 10/10/2018.
 */
public class DetailFragment extends BaseFragment<DetailViewModel,FragmentDetailBinding> {
    @Override
    protected Class getViewModel() {
        return DetailViewModel.class;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_detail;
    }
}
