package com.andreuvictoria2015.agenda_electronica;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity implements ListView.OnItemClickListener {
    private String[] mOptions;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        mOptions = getResources().getStringArray(R.array.nav_drawer_items);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, this.mOptions));
        // Set the list's click listener
        mDrawerList.setOnItemClickListener(this);

        // Enable Local Datastore.
        //Parse.enableLocalDatastore(this);
        //Parse.initialize(this, "C4Iwrdv978eJzKuv6sLakAnNfbscz9BLPhF53gxp", "7hsClDF4Yxy4jZ4wIiivUYF0VaMnDuiXv9zlDTT3");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) {
            Intent i = new Intent(MainActivity.this, AllContacts_activity.class);
            startActivity(i);
        }
        if (position == 1) {
            Intent i = new Intent(MainActivity.this, Groups_activity.class);
            i.putExtra("option", position);
            startActivity(i);
        }
        if (position == 2) {
            Intent i = new Intent(MainActivity.this, Groups_activity.class);
            i.putExtra("option", position);
            startActivity(i);
        }
        if (position == 3) {
            Intent i = new Intent(MainActivity.this, Edit_Contact_activity.class);
            i.putExtra("option", "newContact");
            startActivity(i);
        }
        if (position == 4) {
            Intent i = new Intent(MainActivity.this, Groups_activity.class);
            startActivity(i);
        }
    }
}


