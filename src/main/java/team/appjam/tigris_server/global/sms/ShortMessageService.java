package team.appjam.tigris_server.global.sms;

public interface ShortMessageService {

    String sendSMS(String toNumber, String randomNumber);

}
