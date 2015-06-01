package com.andreuvictoria2015.agenda_electronica;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class RadioListAdapter extends BaseAdapter implements RadioGroup.OnCheckedChangeListener {

    private Context context;
    private ArrayList<ListItem> listItems;

    public RadioListAdapter(Context context, ArrayList<ListItem> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.contact_in_group_fragment, null);
        }

        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.image_item);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.name_item);
        TextView txtCount = (TextView) convertView.findViewById(R.id.counter_item);
        RadioGroup radioGroup = (RadioGroup) convertView.findViewById(R.id.radio_group);
        /*RadioButton radioButtonadd = (RadioButton) convertView.findViewById(R.id.radioButton_add);
        RadioButton radioButtonremove = (RadioButton) convertView.findViewById(R.id.radioButton_remove);*/

        imgIcon.setImageResource(listItems.get(position).getIcon());
        txtTitle.setText(listItems.get(position).getTitle());

        // displaying count
        // check whether it set visible or not
        if (listItems.get(position).getCounterVisibility()) {
            txtCount.setText(listItems.get(position).getCount());
        } else {
            // hide the counter view
            txtCount.setVisibility(View.GONE);
        }

        radioGroup.setOnCheckedChangeListener(this);

        return convertView;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {


    }
}