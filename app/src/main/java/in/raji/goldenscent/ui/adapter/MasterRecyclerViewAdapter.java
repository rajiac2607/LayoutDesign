package in.raji.goldenscent.ui.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import in.raji.goldenscent.R;
import in.raji.goldenscent.databinding.ListItemMasterBinding;
import in.raji.goldenscent.model.MasterItemModel;

/**
 * Created by Raji on 11/10/2018.
 */
public class MasterRecyclerViewAdapter extends RecyclerView.Adapter<MasterRecyclerViewAdapter.MasterViewHolder> {
    private ArrayList<MasterItemModel> items;

    public MasterRecyclerViewAdapter(ArrayList<MasterItemModel> items) {
        this.items = items;
    }

    class MasterViewHolder extends RecyclerView.ViewHolder {
        private final ListItemMasterBinding listItemBinding;

        public MasterViewHolder(@NonNull ListItemMasterBinding listItemBinding) {
            super(listItemBinding.getRoot());
            this.listItemBinding = listItemBinding;

        }
        void bind(MasterItemModel itemModel) {
            listItemBinding.setModel(itemModel);

        }
    }

    @NonNull
    @Override
    public MasterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemMasterBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.list_item_master, parent, false);
        return new MasterViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MasterViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
