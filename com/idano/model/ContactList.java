package com.idano.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class ContactList{
    private Map<String,Contact> mContactsMap;
    private Map<Integer, String> mContactsMenu;

    public ContactList(){
        mContactsMap = new TreeMap<>();
    }

    public boolean isEmpty(){
        return mContactsMap.isEmpty();
    }

    public void add(Contact contact){
        mContactsMap.put(contact.getInfo("Last Name")+", "+contact.getInfo("First Name"),contact);
    }

    public String getContactDetails(int index){
        return mContactsMap.get(mContactsMenu.get(index)).getContactInfo();
    }

    public Map<Integer,String> getContactNames(){
        mContactsMenu = null;
        mContactsMenu = new LinkedHashMap<>();
        int counter = 1;
        for (String name : mContactsMap.keySet())
        {
            mContactsMenu.put(counter, name);
            counter++;
        }
        return mContactsMenu;
    }
}
