package com.sda.financialparadiseclient.config;

import java.util.HashMap;

public class SMSConfiguration {

    public static HashMap<String, String> getPhoneNumbers() {
        HashMap<String, String> phoneNumbers = new HashMap<>();
        phoneNumbers.put("rafafafa", "+48888760776");
        phoneNumbers.put("moler", "+48737460483");
        phoneNumbers.put("filip", "+48665020506");

        return phoneNumbers;
    }
}
