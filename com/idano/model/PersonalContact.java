package com.idano.model;

public class PersonalContact extends Contact {
    public PersonalContact(String fName, String lName, String address, String phoneNumber, String email, String birthday){
        super("Personal",fName,lName,address,phoneNumber,email);
        super.addInfo("Birthday",birthday);
    }

    public String getContactInfo(){
        String string = "Personal Contact:\n" + "=================\n";
        for(String key: super.getKeys() ){
            if(key != "Type"){
                string = string + String.format("%s: %s%n",key,super.getInfo(key));
            }
        }
        return string;
    }
}
