package com.andreuvictoria2015.agenda_electronica;


import com.parse.GetCallback;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.io.BufferedInputStream;
import java.io.File;
import java.text.ParseException;

public class Contact {

    String contact_id, contact_name, contact_group;
    Integer contact_number;
    java.io.File contact_image;

    public Contact() {}

    public Contact(String id, String name, Integer number, java.io.File image, String group) {
        this.contact_id = id;
        this.contact_name = name;
        this.contact_number = number;
        this.contact_group = group;
        this.contact_image = image;

    }

    public String getContact_id() {
        return contact_id;
    }


    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String new_name) {
        this.contact_name = new_name;

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Contact");
        // Retrieve the object by id
        query.getInBackground(this.contact_id, new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject contact, com.parse.ParseException e) {
                if (e == null) {
                    // Now let's update it with some new data. In this case, only cheatMode and score
                    // will get sent to the Parse Cloud. playerName hasn't changed.
                    contact.put("contact_name", contact_name);
                    contact.saveInBackground();
                }
            }
        });

    }

    public String getContact_group() {
        return contact_group;
    }

    public void setContact_group(String new_group) {
        this.contact_group = new_group;
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Contact");
        // Retrieve the object by id
        query.getInBackground(this.contact_id, new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject contact, com.parse.ParseException e) {
                if (e == null) {
                    // Now let's update it with some new data. In this case, only cheatMode and score
                    // will get sent to the Parse Cloud. playerName hasn't changed.
                    contact.put("id_group", contact_group);
                    contact.saveInBackground();
                }
            }
        });
    }

    public Integer getContact_number() {
        return contact_number;
    }

    public void setContact_number(Integer new_number) {
        this.contact_number = new_number;

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Contact");
        // Retrieve the object by id
        query.getInBackground(this.contact_id, new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject contact, com.parse.ParseException e) {
                if (e == null) {
                    // Now let's update it with some new data. In this case, only cheatMode and score
                    // will get sent to the Parse Cloud. playerName hasn't changed.
                    contact.put("contact_number", contact_number);
                    contact.saveInBackground();
                }
            }
        });


    }

    public File getContact_image() {
        return contact_image;
    }

    /*public void setContact_image(java.io.File new_image) {
        this.contact_image = new_image;com.parse.ParseException
        final ParseFile image_file = new ParseFile("image.png", contact_image.getPath());
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Contact");
        // Retrieve the object by id
        query.getInBackground(this.contact_id, new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject contact, com.parse.ParseException e) {
                if (e == null) {
                    // Now let's update it with some new data. In this case, only cheatMode and score
                    // will get sent to the Parse Cloud. playerName hasn't changed.

                    contact.put("contact_image", image_file);
                    contact.saveInBackground();
                }
            }
        });

    }*/
}


