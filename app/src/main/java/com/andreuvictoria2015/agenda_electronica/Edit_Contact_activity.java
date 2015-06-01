package com.andreuvictoria2015.agenda_electronica;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Edit_Contact_activity extends ActionBarActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_edit_layout);

        EditText name_edit = (EditText) findViewById(R.id.name_person);
        EditText tel_edit = (EditText) findViewById(R.id.tel_person);
        EditText group_edit = (EditText) findViewById(R.id.group_person);
        Button save_button = (Button) findViewById(R.id.button_save);


        if(getIntent().getStringExtra("option").equals("newContact")){

        } else{

        }



        final String new_name, new_tel, new_group;
        new_name = name_edit.getText().toString();
        new_tel = tel_edit.getText().toString();
        new_group = group_edit.getText().toString();

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if ( ! new_name.equals("") && ! new_group.equals("") && ! new_tel.equals("x")) {

                    // COMPROVAR GRUPS
                    // GUARDAR AL PARSE
                    finish();

                }

            }
        });

    }
}
