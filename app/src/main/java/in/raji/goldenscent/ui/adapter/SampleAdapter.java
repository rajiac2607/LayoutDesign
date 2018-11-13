package in.raji.goldenscent.ui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import in.raji.goldenscent.R;
import in.raji.goldenscent.databinding.FragmentMasterBinding;
import in.raji.goldenscent.model.ChildItemModel;

/**
 * Created by Raji on 13/11/2018.
 */
public class SampleAdapter extends RecyclerView.Adapter<SampleAdapter.MasterViewHolder> {
    private ArrayList<ArrayList<ChildItemModel>> items;
    Context context;

    public SampleAdapter(ArrayList<ArrayList<ChildItemModel>> items,Context c) {
        this.items = items;
        this.context=c;
    }

    class MasterViewHolder extends RecyclerView.ViewHolder {
        private final FragmentMasterBinding listItemBinding;

        public MasterViewHolder(@NonNull FragmentMasterBinding listItemBinding) {
            super(listItemBinding.getRoot());
            this.listItemBinding = listItemBinding;


        }

        void bind(ArrayList<ChildItemModel> itemModel) {
            listItemBinding.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            listItemBinding.recyclerView.setAdapter(new MasterRecyclerViewAdapter(itemModel));

        }
    }

    @NonNull
    @Override
    public SampleAdapter.MasterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FragmentMasterBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.fragment_master, parent, false);
        return new SampleAdapter.MasterViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SampleAdapter.MasterViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


}
