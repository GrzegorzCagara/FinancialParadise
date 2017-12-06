package com.sda.financialparadiseclient.config;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SMSSender {
    private static final String ACCOUNT_SID = "ACed93a6bf77b6fc03c40ff50a172dc3a1";
    private static final String AUTH_TOKEN = "dc5264f9d31646e14c8abbd23dd0a2ea";
    private static final String TWILLO_NUMBER = "+48732483718";

    private static String code;


        public static void sendMessage(String body, String yourPhoneNumber){
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            Message message = Message
                    .creator(new PhoneNumber(yourPhoneNumber), new PhoneNumber(TWILLO_NUMBER),
                            body).create();
        }


}
