package team.appjam.tigris_server.domain.authcode.service;


import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Service;
import team.appjam.tigris_server.domain.authcode.entity.AuthCode;
import team.appjam.tigris_server.domain.authcode.exception.InvalidAuthCodeException;
import team.appjam.tigris_server.domain.authcode.repository.AuthCodeRepository;
import team.appjam.tigris_server.domain.user.api.dto.request.SendAuthCodeRequest;
import team.appjam.tigris_server.domain.user.api.dto.request.VerifyAuthCodeRequest;
import team.appjam.tigris_server.global.sms.ShortMessageService;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthCodeService {

    private final AuthCodeRepository authCodeRepository;
    private final ShortMessageService shortMessageService;


    public void sendAuthCode(SendAuthCodeRequest authCodeRequest) {
        String random = RandomStringUtils.randomNumeric(6);

        Optional<AuthCode> authCode = authCodeRepository.findByPhoneNumber(authCodeRequest.getPhoneNumber());
        if (authCode.isPresent()){
            authCodeRepository.save(authCode.get().setCode(random));
        }else {
            authCodeRepository.save(
                    AuthCode.builder()
                            .code(random)
                            .phoneNumber(authCodeRequest.getPhoneNumber())
                            .expiration(1800L)
                            .build()
            );
        }
        shortMessageService.sendSMS(authCodeRequest.getPhoneNumber().toString(), random);
    }

    public void verifyAuthCode(VerifyAuthCodeRequest authCodeRequest) {

        if (!authCodeRequest.getCode().equals(authCodeRepository.findByPhoneNumber(authCodeRequest.getPhoneNumber()))) {
            throw new InvalidAuthCodeException();
        }

    }
}
