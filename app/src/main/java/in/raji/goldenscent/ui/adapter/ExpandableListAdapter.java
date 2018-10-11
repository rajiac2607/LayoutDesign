package in.raji.goldenscent.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import in.raji.goldenscent.R;
import in.raji.goldenscent.model.ChildItemModel;
import in.raji.goldenscent.model.ParentItemModel;

/**
 * Created by Raji on 11/10/2018.
 */
public class ExpandableListAdapter extends BaseExpandableListAdapter {
    ArrayList<ParentItemModel> parentList;
    Context context;

    public ExpandableListAdapter(Context context, ArrayList<ParentItemModel> parentList) {
        this.parentList = parentList;
        this.context = context;
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
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.expandable_list_parent_item, null);
        }

        TextView textView = convertView.findViewById(R.id.title);
        textView.setText(parentList.get(groupPosition).getTitle());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.expandable_list_child_item, null);


        }
        GridView gridView = convertView.findViewById(R.id.gridView);
        gridView.setAdapter(new GridAdapter(context, parentList.get(groupPosition).getChildren()));

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    class GridAdapter extends BaseAdapter {
        ArrayList<ChildItemModel> children;
        Context context;

        public GridAdapter(Context context, ArrayList<ChildItemModel> children) {
            this.context = context;
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
            if (convertView == null) {
                LayoutInflater layoutInflater = (LayoutInflater) this.context.
                        getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = layoutInflater.inflate(R.layout.grid_item, null);


            }
            ((TextView) convertView.findViewById(R.id.text)).setText(children.get(position).getTitle());
            ((ImageView) convertView.findViewById(R.id.image)).setImageResource(children.get(position).getImgResource());

            return convertView;
        }
    }
}