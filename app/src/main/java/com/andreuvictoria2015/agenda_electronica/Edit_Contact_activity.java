package com.andreuvictoria2015.agenda_electronica;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class Edit_Contact_activity extends ActionBarActivity {

    EditText name_edit;
    EditText tel_edit;
    TextView group_edit;
    Button save_button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_edit_layout);

        name_edit = (EditText) findViewById(R.id.name_contact);
        tel_edit = (EditText) findViewById(R.id.tel_contact);
        group_edit = (TextView) findViewById(R.id.group_contact);
        save_button = (Button) findViewById(R.id.button_save);

        Log.d("ERROR EDIT CONTACT", getIntent().getStringExtra("option"));

        if (! getIntent().getStringExtra("option").equals("newContact")){
            name_edit.setText(getIntent().getStringExtra("name"));
            tel_edit.setText(getIntent().getStringExtra("tel"));
            Log.d("DDDDDDDDDDDDDDDDDDD", getIntent().getStringExtra("group"));
            group_edit.setText(getIntent().getStringExtra("group"));

        }

        final String new_name, new_tel, new_group;
        new_name = name_edit.getText().toString();
        new_tel = tel_edit.getText().toString();

        //group_edit.setText(R.string.Name_group_default);
        String cacatua = " de xocolata";
        cacatua = "nnj";


        if (! getIntent().getStringExtra("option").equals("newContact")){

        }

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if ( ! new_name.equals("") && ! new_tel.equals("")) {

                    // COMPROVAR GRUPS
                    // GUARDAR AL PARSE
                    if(getIntent().getStringExtra("option").equals("newContact")){
                        ParseObject new_contact = new ParseObject("Contact");

                        new_contact.put("contact_name", name_edit.getText().toString());
                        new_contact.put("contact_number", Integer.parseInt(tel_edit.getText().toString()));
                        new_contact.saveInBackground();

                    }else{

                        ParseQuery<ParseObject> query = ParseQuery.getQuery("Contact");
                        query.getInBackground(getIntent().getStringExtra("option"), new GetCallback<ParseObject>() {
                            public void done(ParseObject object, ParseException e) {
                                if (e == null) {
                                    // object will be your game score
                                    object.put("contact_name", name_edit.getText().toString());
                                    object.put("contact_number", tel_edit.getText().toString());
                                    object.saveInBackground();

                                } else {
                                    // something went wrong
                                }
                            }
                        });

                    }

                    Intent i = new Intent(Edit_Contact_activity.this, Contact_activity.class);
                    i.putExtra("id", getIntent().getStringExtra("option"));
                    startActivity(i);
                    finish();

                }

            }
        });

    }
}
