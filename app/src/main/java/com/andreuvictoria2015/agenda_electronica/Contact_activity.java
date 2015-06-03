package com.andreuvictoria2015.agenda_electronica;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class Contact_activity extends ActionBarActivity {

    ImageView picture;
    TextView name_text;
    TextView tel_text;
    TextView group_text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_layout);

        picture = (ImageView) findViewById(R.id.image_user);
        name_text = (TextView) findViewById(R.id.name_contact);
        tel_text = (TextView) findViewById(R.id.tel_contact);
        group_text = (TextView) findViewById(R.id.group_contact);

        if (getIntent().getStringExtra("id") != null){
            //recuperar informacio del parse
            ParseQuery<ParseObject> query = ParseQuery.getQuery("Contact");
            query.getInBackground(getIntent().getStringExtra("id"), new GetCallback<ParseObject>() {
                public void done(ParseObject object, ParseException e) {
                    if (e == null) {
                        // object will be your game score
                        name_text.setText(object.get("contact_name").toString());
                        tel_text.setText(object.get("contact_number").toString());

                        if (object.get("id_group") != null) {
                            String aux;
                            aux = object.get("id_group").toString();

                            ParseQuery<ParseObject> query1 = ParseQuery.getQuery("Group");
                            query1.getInBackground(aux, new GetCallback<ParseObject>() {
                                @Override
                                public void done(ParseObject parseObject, ParseException e) {
                                    group_text.setText(parseObject.get("group_name").toString());
                                }
                            });
                        }

                    } else {
                        // something went wrong
                    }
                }
            });

        }

        Button edit_button = (Button) findViewById(R.id.button_edit);

        edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Contact_activity.this, Edit_Contact_activity.class);
                i.putExtra("option", getIntent().getStringExtra("id"));
                i.putExtra("name", name_text.getText());
                i.putExtra("tel", tel_text.getText());
                i.putExtra("group", group_text.getText());
                startActivity(i);
            }
        });
    }
}
