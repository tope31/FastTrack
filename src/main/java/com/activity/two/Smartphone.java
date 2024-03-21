package com.activity.two;

import java.util.HashMap;
import java.util.Map;

public class Smartphone extends Telephone {
    private String phoneNo;
    private String operatingSystem;
    Map<String, String> contacts = new HashMap<>();

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public Map<String, String> getContacts() {
        return contacts;
    }

    public void setContacts(Map<String, String> contacts) {
        this.contacts = contacts;
    }

    public Smartphone(String phoneNo, String operatingSystem) {
        this.phoneNo = phoneNo;
        this.operatingSystem = operatingSystem;
    }

    public void addContact(String name, String phoneNo) {
        contacts.put(name, phoneNo);
    }

    public void removeContact(String name) {
        contacts.remove(name);
    }

    @Override
    public void call(String phoneNo) {
        if (phoneNo.equals(this.phoneNo)) {
            System.out.println("You cannot call yourself");
        } else {
            super.call(phoneNo);
        }
    }

    public void call(String name, String phoneNo) {
        if (contacts.containsKey(name)) {
            System.out.println("Calling from contacts");
            super.call(phoneNo);
        }
    }

    public void displayContacts() {
        for (String element: contacts.keySet()) {
            System.out.println(element);
        }
    }

}
