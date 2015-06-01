package com.andreuvictoria2015.agenda_electronica;

import com.parse.GetCallback;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.io.BufferedInputStream;
import java.io.File;
import java.text.ParseException;

import java.io.File;

public class Group {


    String group_id,group_name;
    java.io.File group_image;

    public Group() {}

    public Group(String id, String name, java.io.File image) {
        this.group_id = id;
        this.group_name = name;
        this.group_image = image;

    }

    public String getGroup_id() {
        return group_id;
    }


    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String new_name) {
        this.group_name = new_name;

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Group");
        // Retrieve the object by id
        query.getInBackground(this.group_id, new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject contact, com.parse.ParseException e) {
                if (e == null) {
                    // Now let's update it with some new data. In this case, only cheatMode and score
                    // will get sent to the Parse Cloud. playerName hasn't changed.
                    contact.put("group_name", group_name);
                    contact.saveInBackground();
                }
            }
        });

    }


    public File getGroup_image() {
        return group_image;
    }

/*public void setContact_image(java.io.File new_image) {
    this.group_image = new_image;com.parse.ParseException
    final ParseFile image_file = new ParseFile("image.png", group_image.getPath());
    ParseQuery<ParseObject> query = ParseQuery.getQuery("Group");
    // Retrieve the object by id
    query.getInBackground(this.group_id, new GetCallback<ParseObject>() {
        @Override
        public void done(ParseObject contact, com.parse.ParseException e) {
            if (e == null) {
                // Now let's update it with some new data. In this case, only cheatMode and score
                // will get sent to the Parse Cloud. playerName hasn't changed.

                contact.put("group_image", image_file);
                contact.saveInBackground();
            }
        }
    });

  }*/
}
