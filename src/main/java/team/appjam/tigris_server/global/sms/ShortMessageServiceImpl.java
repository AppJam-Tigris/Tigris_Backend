package team.appjam.tigris_server.global.sms;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import team.appjam.tigris_server.global.error.GlobalExceptionHandler;

import java.util.HashMap;


/**
 * 다음 로직은, 전화번호 인증 로직을 구현한 코드입니다. Auth Signup에서 인증 방법의 변경으로 인해 현재 사용되지는 않으나, 혹시나 있을지 모르는 기능 확장을 위해 남겨둡니다.
 */

@Service
@Slf4j
@RequiredArgsConstructor
public class ShortMessageServiceImpl implements ShortMessageService {

    private final GlobalExceptionHandler globalExceptionHandler;

    @Value("${coolsms.devHee.apikey}")
    private String apiKey;

    @Value("${coolsms.devHee.apisecret}")
    private String apiSecret;

    @Value("${coolsms.devHee.fromnumber}")
    private String fromNumber;



    @Override
    public void sendSMS(String toNumber, String randomNumber) {

        Message coolsms = new Message(apiKey, apiSecret);

        HashMap<String, String> params = new HashMap<String, String>();
        params.put("to", toNumber);
        params.put("from", fromNumber);
        params.put("type", "CoVin");
        params.put("text", "[CoVin]\n 인증번호는 " + randomNumber + " 를 입력하세요.");
        params.put("app_version", "demo app 1.3"); // application name and version

        JSONObject obj = null;
        try {
            obj = (JSONObject) coolsms.send(params);
        } catch (CoolsmsException e) {
            globalExceptionHandler.coolSMSExceptoin(e);
        }
    }
}
