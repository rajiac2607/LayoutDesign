package in.raji.goldenscent.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import in.raji.goldenscent.R;
import in.raji.goldenscent.databinding.FragmentMasterBinding;
import in.raji.goldenscent.ui.adapter.MasterRecyclerViewAdapter;
import in.raji.goldenscent.viewmodel.MasterViewModel;

/**
 * Created by Raji on 10/10/2018.
 */
public class MasterFragment extends BaseFragment<MasterViewModel,FragmentMasterBinding> {
    @Override
    protected Class getViewModel() {
        return MasterViewModel.class;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_master;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        dataBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        dataBinding.recyclerView.getLayoutManager().scrollToPosition(0);

        dataBinding.recyclerView.setAdapter(new MasterRecyclerViewAdapter(viewModel.getModelArrayList()));
    }
}
