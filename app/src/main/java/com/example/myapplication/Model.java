package com.example.myapplication;

public class Model {

    private String task;
    private String str_date;
    //private boolean bool_checkbox;

    public Model(String task,String str_date){
        this.task = task;
        this.str_date=str_date;
    }

    public String getTask() {return this.task; }
    public String getDate() {return this.str_date; }

}
