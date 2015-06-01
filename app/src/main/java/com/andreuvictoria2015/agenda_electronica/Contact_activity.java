package com.andreuvictoria2015.agenda_electronica;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Contact_activity extends ActionBarActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_layout);

        if (getIntent().getStringExtra("name") != null){
            //recuperar informacio del parse

            ImageView picture = (ImageView) findViewById(R.id.image_user);
            TextView name_text = (TextView) findViewById(R.id.name_person);
            TextView tel_text = (TextView) findViewById(R.id.tel_person);
            TextView group_text = (TextView) findViewById(R.id.group_person);



        }

        Button edit_button = (Button) findViewById(R.id.button_edit);

        edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Contact_activity.this, Edit_Contact_activity.class);
                startActivity(i);
            }
        });
    }
}
