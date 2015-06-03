package com.andreuvictoria2015.agenda_electronica;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Groups_activity extends ActionBarActivity implements AdapterView.OnItemClickListener {
    private ListView groupList;
    ArrayList<ListItem> listItems = new ArrayList<ListItem>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);


        // load slide menu items
        //agafem els noms dels contactes del parse
        //navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);

        // nav drawer icons from resources
        //agafem les imatges del parse
        TypedArray listIcons = getResources().obtainTypedArray(R.array.list_icons);


        groupList = (ListView) findViewById(R.id.the_list);


        // adding nav drawer items to array
        listItems.add(new ListItem("i", "Group 0", listIcons.getResourceId(0, -1)));
        listItems.add(new ListItem("ii", "Group 1", listIcons.getResourceId(0, -1)));
        listItems.add(new ListItem("iii", "Group 2", listIcons.getResourceId(0, -1)));
        listItems.add(new ListItem("iv", "Group 3", listIcons.getResourceId(0, -1)));
        listItems.add(new ListItem("v", "Group 4", listIcons.getResourceId(0, -1)));
        listItems.add(new ListItem("vi", "Group 5", listIcons.getResourceId(0, -1)));

        // Recycle the typed array
        //navMenuIcons.recycle();

        // setting the nav drawer list adapter
        ListAdapter adapter = new ListAdapter(getApplicationContext(),
                listItems);
        groupList.setAdapter(adapter);
        groupList.setOnItemClickListener(this);

        // enabling action bar app icon and behaving it as toggle button
        /*getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.drawable.ic_drawer, //nav menu toggle icon
                R.string.app_name, // nav drawer open - description for accessibility
                R.string.app_name // nav drawer close - description for accessibility
        ){
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(mTitle);
                // calling onPrepareOptionsMenu() to show action bar icons
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(mDrawerTitle);
                // calling onPrepareOptionsMenu() to hide action bar icons
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
            // on first time display view for first nav item
            displayView(0);
        }*/
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("CONTACTS POSITION", position + "");

        Integer option = getIntent().getIntExtra("option", -1);
        Intent i = null;

        if (option == 1) {
            i = new Intent(Groups_activity.this, AllContacts_activity.class);
            i.putExtra("group", this.listItems.get(position).getTitle());

        }

        if (option == 2) {
            i = new Intent(Groups_activity.this, Group_activity.class);
            i.putExtra("group", this.listItems.get(position).getTitle());

        }
            
        startActivity(i);

    }
}
