package com.activity.two.app;

import com.activity.two.Smartphone;
import com.activity.two.Telephone;

public class SeatworkTwo {
    public static void main(String[] args) {
        Telephone telephone = new Telephone();
        telephone.call("09123456789");

        Smartphone smartphone = new Smartphone("09123456789", "iOS");
        System.out.println("Created Mobile Phone Number and Operating System");
        System.out.println("Phone Number: " + smartphone.getPhoneNo());
        System.out.println("Operating System: " + smartphone.getOperatingSystem());

        //addContacts
        smartphone.addContact("Hanni", "09123456781");
        smartphone.addContact("Haerin", "09123456782");
        smartphone.addContact("Danielle", "09123456783");
        smartphone.addContact("Minji", "09123456784");
        smartphone.addContact("Hyein", "09123456785");

        //displayContacts
        smartphone.displayContacts();

        //removeContacts
        smartphone.removeContact("Hyein");

        //call randomPhoneNumber
        smartphone.call("09123456789");

        //call savedContact
        smartphone.call("Hanni", "09123456781");
    }
}
