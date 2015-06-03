package com.andreuvictoria2015.agenda_electronica;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Group_activity extends ActionBarActivity {

    private ListView contactsList;
    private ArrayList<ListItem> listItems = new ArrayList<ListItem>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_layout);

        TypedArray listIcons = getResources().obtainTypedArray(R.array.list_icons);


        contactsList = (ListView) findViewById(R.id.the_list);
        Button save_button = (Button) findViewById(R.id.button_save);

        //ArrayList<ListItem> listItems = new ArrayList<ListItem>();


        // adding nav drawer items to array

        //funcio recuperar del parse i cal tenir en compte que caldra filtrar
        listItems.add(new ListItem("i", "Person 0", listIcons.getResourceId(0, -1)));
        listItems.add(new ListItem("ii", "Person 1", listIcons.getResourceId(0, -1)));
        listItems.add(new ListItem("iii", "Person 2", listIcons.getResourceId(0, -1)));
        listItems.add(new ListItem("iv", "Person 3", listIcons.getResourceId(0, -1)));
        listItems.add(new ListItem("v", "Person 4", listIcons.getResourceId(0, -1)));
        listItems.add(new ListItem("vi", "Person 5", listIcons.getResourceId(0, -1)));


        // Recycle the typed array
        //navMenuIcons.recycle();

        // setting the nav drawer list adapter
        RadioListAdapter adapter = new RadioListAdapter(getApplicationContext(),
                listItems);
        contactsList.setAdapter(adapter);

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    // COMPROVAR les noves assignacions
                    // GUARDAR AL PARSE
                    finish();

            }
        });

    }


}
