package in.raji.goldenscent.ui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;

import java.util.ArrayList;

import in.raji.goldenscent.R;
import in.raji.goldenscent.databinding.ExpandableListChildItemBinding;
import in.raji.goldenscent.databinding.ExpandableListParentItemBinding;
import in.raji.goldenscent.databinding.GridItemBinding;
import in.raji.goldenscent.model.ChildItemModel;
import in.raji.goldenscent.model.ParentItemModel;

/**
 * Created by Raji on 11/10/2018.
 */
public class ExpandableListAdapter extends BaseExpandableListAdapter {
    ArrayList<ParentItemModel> parentList;
    Context context;

    public ExpandableListAdapter(ArrayList<ParentItemModel> parentList) {
        this.parentList = parentList;
    }

    @Override
    public int getGroupCount() {
        return parentList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return parentList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return parentList.get(groupPosition).getChildren();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ExpandableListParentItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.expandable_list_parent_item, parent, false);

        if (convertView == null) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.expandable_list_parent_item, parent, false);
            convertView = binding.getRoot();
        }
        binding.setModel(parentList.get(groupPosition));
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ExpandableListChildItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.expandable_list_child_item, parent, false);

        if (convertView == null)
            convertView = binding.getRoot();

        binding.gridView.setAdapter(new GridAdapter(parentList.get(groupPosition).getChildren()));

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    class GridAdapter extends BaseAdapter {
        ArrayList<ChildItemModel> children;

        public GridAdapter(ArrayList<ChildItemModel> children) {
            this.children = children;
        }

        @Override
        public int getCount() {
            return children.size();
        }

        @Override
        public Object getItem(int position) {
            return children.get(position);
        }

        @Override
        public long getItemId(int position) {
            return children.get(position).hashCode();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            GridItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.grid_item, parent, false);

            if (convertView == null)
                convertView = binding.getRoot();
            binding.setModel(children.get(position));

            return convertView;
        }
    }
}