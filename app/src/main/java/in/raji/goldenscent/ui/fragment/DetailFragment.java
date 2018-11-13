package in.raji.goldenscent.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;

import in.raji.goldenscent.R;
import in.raji.goldenscent.databinding.FragmentDetailBinding;
import in.raji.goldenscent.ui.Utility;
import in.raji.goldenscent.ui.adapter.ExpandableListAdapter;
import in.raji.goldenscent.viewmodel.DetailViewModel;

/**
 * Created by Raji on 10/10/2018.
 */
public class DetailFragment extends BaseFragment<DetailViewModel, FragmentDetailBinding> {
    @Override
    protected Class getViewModel() {
        return DetailViewModel.class;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_detail;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        dataBinding.expandableList.setAdapter(new ExpandableListAdapter(viewModel.getItems()));

        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;

        dataBinding.expandableList.setIndicatorBoundsRelative(width - Utility.convertDp_to_Px(getContext(),250), width - Utility.convertDp_to_Px(getContext(),10));

        dataBinding.expandableList.expandGroup(0);

        View headerView = getLayoutInflater().inflate(R.layout.list_header, null);
        dataBinding.expandableList.addHeaderView(headerView);

    }


}
