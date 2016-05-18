package com.idano.model;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by daniel on 7/8/15.
 */
public abstract class Contact{

    private Map<String, String> mContactInfo;

    public Contact(String type, String fName, String lName, String address, String phoneNumber, String email){
        Map<String,String> contactInfo = new LinkedHashMap<>();

        contactInfo.put("Type",type);
        contactInfo.put("First Name",fName);
        contactInfo.put("Last Name",lName);
        contactInfo.put("Address",address);
        contactInfo.put("Phone Number",phoneNumber);
        contactInfo.put("Email",email);

        mContactInfo = contactInfo;
    }

    protected void addInfo(String key, String value){
        mContactInfo.put(key,value);
    }

    protected String getInfo(String key){
        return mContactInfo.get(key);
    }

    protected Set<String> getKeys(){
        Set<String> keys = new LinkedHashSet<>();
        keys = mContactInfo.keySet();
        return keys;
    }

    public abstract String getContactInfo();
}
