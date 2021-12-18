package team.appjam.tigris_server.global.sms;

import net.nurigo.java_sdk.exceptions.CoolsmsException;

public interface ShortMessageService {

    void sendSMS(String toNumber, String randomNumber);

}
