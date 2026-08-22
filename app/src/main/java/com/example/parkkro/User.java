package com.example.parkkro;

public class User {

    String Type,Time,Slot,Name,VNumber,RPT,PhoneNumber;
    public User(){
        //FireBase ke liye
    }


    public User(String type, String time,String slot, String name, String vNumber,String rpt, String phonenumber) {
        Type = type;
        Time = time;
        Slot = slot;
        Name = name;
        VNumber = vNumber;
        RPT = rpt;
        PhoneNumber = phonenumber;

    }

    public String getType() {
        return Type;
    }

    public String getTime() {
        return Time;
    }

    public String getSlot() {
        return Slot;
    }

    public String getName() {
        return Name;
    }

    public String getVNumber() {
        return VNumber;
    }

    public String getRPT(){return RPT;}

    public String getPhoneNumber(){return PhoneNumber;}


}
