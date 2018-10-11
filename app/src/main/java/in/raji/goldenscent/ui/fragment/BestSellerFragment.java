package in.raji.goldenscent.ui.fragment;

import in.raji.goldenscent.R;
import in.raji.goldenscent.databinding.FragmentBestSellerBinding;
import in.raji.goldenscent.viewmodel.BestSellerViewModel;

/**
 * Created by Raji on 11/10/2018.
 */
public class BestSellerFragment extends BaseFragment<BestSellerViewModel, FragmentBestSellerBinding> {

    @Override
    protected Class<BestSellerViewModel> getViewModel() {
        return BestSellerViewModel.class;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_best_seller;
    }
}