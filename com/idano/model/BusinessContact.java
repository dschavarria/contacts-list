package com.idano.model;

public class BusinessContact extends Contact {
    public BusinessContact(String fName, String lName, String address, String phoneNumber, String email, String jobTitle, String organization){
        super("Business",fName,lName,address,phoneNumber,email);
        super.addInfo("Job Title",jobTitle);
        super.addInfo("Organization",organization);
    }

    public String getContactInfo(){
        String string = "Business Contact:\n" + "=================\n";
        for(String key: super.getKeys() ){
            if(key != "Type"){
                string = string + String.format("%s: %s%n",key,super.getInfo(key));
            }
        }
        return string;
    }
}
