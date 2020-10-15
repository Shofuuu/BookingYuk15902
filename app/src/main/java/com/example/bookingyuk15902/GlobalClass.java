package com.example.bookingyuk15902;

import android.app.Application;

public class GlobalClass extends Application {
    private String valueEmail;
    private String valueName;
    private String valueTelp;

    synchronized public void setValueEmail(String value){valueEmail = value;}
    synchronized public void setValueName(String value){valueName = value;}
    synchronized public void setValueTelp(String value){valueTelp = value;}

    synchronized public String getValueEmail(){return valueEmail;}
    synchronized public String getValueName(){return valueName;}
    synchronized public String getValueTelp(){return valueTelp;}
}
