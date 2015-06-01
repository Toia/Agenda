package com.andreuvictoria2015.agenda_electronica;


public class ListItem {

    private String title;
    private int icon;
    private String count = "0";
    private boolean isCounterVisible = false;  // boolean to set visiblity of the counter


    public ListItem(){}

    public ListItem(String title, int icon){
        this.title = title;
        this.icon = icon;
    }

    public ListItem(String title, int icon, boolean isCounterVisible, String count){
        this.title = title;
        this.icon = icon;
        this.isCounterVisible = isCounterVisible;
        this.count = count;
    }

    public String getTitle(){
        return this.title;
    }

    public int getIcon(){
        return this.icon;
    }

    public String getCount(){
        return this.count;
    }

    public boolean getCounterVisibility(){
        return this.isCounterVisible;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setIcon(int icon){
        this.icon = icon;
    }

    public void setCount(String count){
        this.count = count;
    }

    public void setCounterVisibility(boolean isCounterVisible){
        this.isCounterVisible = isCounterVisible;
    }
}
