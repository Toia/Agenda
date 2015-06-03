package com.andreuvictoria2015.agenda_electronica;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseException;

import java.util.ArrayList;
import java.util.List;

public class AllContacts_activity extends ActionBarActivity implements AdapterView.OnItemClickListener {

    private ListView contactsList;
    private ArrayList<ListItem> listItems = new ArrayList<ListItem>();
    TypedArray listIcons;
    ListAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);


         // load slide menu items
        //agafem els noms dels contactes del parse
        //navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);

        // nav drawer icons from resources
        //agafem les imatges del parse
        listIcons = getResources().obtainTypedArray(R.array.list_icons);


        contactsList = (ListView) findViewById(R.id.the_list);

        //ArrayList<ListItem> listItems = new ArrayList<ListItem>();


        // adding nav drawer items to array

        //funcio recuperar del parse i cal tenir en compte que caldra filtrar
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Contact");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> allContactsList, ParseException e) {
                ParseObject object;
                if (e == null) {
                    for (int i = 0; i < allContactsList.size(); i++) {
                        object = (ParseObject) allContactsList.get(i);
                        listItems.add(new ListItem(object.getObjectId(),
                                object.get("contact_name").toString(), listIcons.getResourceId(0, -1)));
                    }
                    adapter = new ListAdapter(getApplicationContext(), listItems);
                    contactsList.setAdapter(adapter);

                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });


        // Recycle the typed array
        //navMenuIcons.recycle();

        // setting the nav drawer list adapter
        contactsList.setOnItemClickListener(this);

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

        Intent i = new Intent(AllContacts_activity.this, Contact_activity.class);
        i.putExtra("id", this.listItems.get(position).getId());
        startActivity(i);

    }
}
