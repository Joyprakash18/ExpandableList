package com.example.joyprakash.expandablelist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.joyprakash.expandablelist.R;
import com.example.joyprakash.expandablelist.response.FilterListModel;
import com.example.joyprakash.expandablelist.response.FilterSubListModel;

import java.util.ArrayList;
import java.util.List;

public class FilterListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<FilterListModel> filterGroupLists = new ArrayList<>();
    private List<FilterSubListModel> filterChildLists = new ArrayList<>();

    public FilterListAdapter(Context context, List<FilterListModel> filterGroupLists) {
        this.context = context;
        this.filterGroupLists = filterGroupLists;
    }

    @Override
    public int getGroupCount() {
        return filterGroupLists.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        filterChildLists = filterGroupLists.get(groupPosition).getSubItemList();
        if (filterChildLists != null) {
            return filterChildLists.size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getGroup(int groupPosition) {
        return filterGroupLists.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return filterGroupLists.get(groupPosition).getSubItemList().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ParentHolder parentHolder = null;
        FilterListModel drawerGroupList = (FilterListModel) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater userInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = userInflater.inflate(R.layout.filter_child, null);
            convertView.setHorizontalScrollBarEnabled(true);
            parentHolder = new ParentHolder(convertView);
            convertView.setTag(parentHolder);
        } else {
            parentHolder = (ParentHolder) convertView.getTag();
        }
        parentHolder.categoryName.setText("    " + drawerGroupList.getTitle());
        if (isExpanded) {
//            if(drawerGroupList.getExpandMoreImage()!=null){
//                parentHolder.indicator.setVisibility(View.VISIBLE);
//                GlideConnector.getInstance().loadImageDirectly(context.getApplicationContext(), drawerGroupList.getExpandLessImage(), parentHolder.indicator);

            parentHolder.categoryName.setBackgroundResource(R.color.colorWhite);
            if (drawerGroupList.getSubItemList()!=null){
                parentHolder.indicator.setImageResource(R.drawable.ic_expand_less);
                parentHolder.indicator.setVisibility(View.VISIBLE);
            }
            else {
                parentHolder.indicator.setVisibility(View.GONE);

            }
//                parentHolder.indicator.setBackgroundResource(R.color.colorGray);
//            }else {
//                parentHolder.indicator.setVisibility(View.GONE);
//            }
        } else {
//            if(drawerGroupList.getExpandLessImage()!=null){
//                parentHolder.indicator.setVisibility(View.VISIBLE);
//                GlideConnector.getInstance().loadImageDirectly(context.getApplicationContext(), drawerGroupList.getExpandMoreImage(), parentHolder.indicator);
            if (drawerGroupList.getSubItemList()!=null){
                parentHolder.indicator.setVisibility(View.VISIBLE);
                parentHolder.indicator.setImageResource(R.drawable.ic_expand_more);}else {
                parentHolder.indicator.setVisibility(View.GONE);

            }

            parentHolder.categoryName.setBackgroundResource(R.color.colorWhite);
//                parentHolder.indicator.setBackgroundResource(R.color.colorWhite);
//            }else {
//            }
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildHolder childHolder = null;
        FilterSubListModel drawerChildList = (FilterSubListModel) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.filter_sub_child, parent, false);
            childHolder = new ChildHolder(convertView);
            convertView.setTag(childHolder);
        } else {
            childHolder = (ChildHolder) convertView.getTag();
        }
        childHolder.subCategoryTitle.setText(drawerChildList.getItem().trim());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void onGroupExpanded(int groupPosition) {
    }

    @Override
    public void onGroupCollapsed(int groupPosition) {
    }

    @Override
    public long getCombinedChildId(long groupId, long childId) {
        return 0;
    }

    @Override
    public long getCombinedGroupId(long groupId) {
        return 0;
    }

    private static class ParentHolder {
        private TextView categoryName;
        private ImageView indicator;
        private LinearLayout categotyBVackground;

        ParentHolder(View view) {
            categoryName = (TextView) view.findViewById(R.id.main_category);
            indicator = (ImageView) view.findViewById(R.id.image_indicator);
//            indicator = (ImageView) view.findViewById(R.id.image_indicator);
        }
    }

    private static class ChildHolder {
        private TextView subCategoryTitle;
        private CheckBox checkBox;
        ChildHolder(View convertView) {
            subCategoryTitle = (TextView) convertView.findViewById(R.id.sub_category_title);
            checkBox = convertView.findViewById(R.id.checkbox);
        }
    }
}
