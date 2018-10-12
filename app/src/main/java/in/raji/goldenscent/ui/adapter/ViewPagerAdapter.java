package in.raji.goldenscent.ui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import in.raji.goldenscent.R;
import in.raji.goldenscent.databinding.ItemPropertiesBinding;
import in.raji.goldenscent.model.PropertiesModel;
import in.raji.goldenscent.ui.ItemDecorator;

/**
 * Created by Raji on 11/10/2018.
 */
public class ViewPagerAdapter extends PagerAdapter {
    ArrayList<PropertiesModel> models;
    Context context;

    public ViewPagerAdapter(ArrayList<PropertiesModel> models,
                            Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size() / 3;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object view) {
        container.removeView((View) view);
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View viewLayout = inflater.inflate(R.layout.fragment_master, null);
        ArrayList<PropertiesModel> subList = new ArrayList<>();
        subList.addAll(models.subList(position * 3, position * 3 + 3));
        RecyclerView recyclerView = ((RecyclerView) viewLayout.findViewById(R.id.recyclerView));
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new RecyclerViewAdapter(subList));
        recyclerView.addItemDecoration(new ItemDecorator(context));
//
        container.addView(viewLayout);
        return viewLayout;


    }

    @Override
    public float getPageWidth(int position) {
        if (position == 0) {
            return 0.9f;
        }
        return 1f;
    }

    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.PropertiesViewHolder> {

        ArrayList<PropertiesModel> models;

        public RecyclerViewAdapter(ArrayList<PropertiesModel> models) {
            this.models = models;
        }

        class PropertiesViewHolder extends RecyclerView.ViewHolder {
            ItemPropertiesBinding binding;

            public PropertiesViewHolder(@NonNull ItemPropertiesBinding binding) {
                super(binding.getRoot());
                this.binding = binding;
            }

            void bind(PropertiesModel itemModel) {
                binding.setModel(itemModel);
                if (itemModel.isOnOffer()) {
                    binding.originalPrice.setPaintFlags(binding.originalPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    binding.originalPrice.setTextColor(context.getResources().getColor(android.R.color.darker_gray));
                }

            }
        }

        @NonNull
        @Override
        public PropertiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            ItemPropertiesBinding binding =
                    DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_properties, parent, false);
            return new PropertiesViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull PropertiesViewHolder holder, int position) {
            holder.bind(models.get(position));

        }


        @Override
        public int getItemCount() {
            return models.size();
        }
    }
}
