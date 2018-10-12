package in.raji.goldenscent.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import in.raji.goldenscent.R;
import in.raji.goldenscent.databinding.FragmentBestSellerBinding;
import in.raji.goldenscent.ui.adapter.ViewPagerAdapter;
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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        dataBinding.viewpager.setAdapter(new ViewPagerAdapter(viewModel.getPropertiesModels(), getActivity().getApplicationContext()));

    }
}