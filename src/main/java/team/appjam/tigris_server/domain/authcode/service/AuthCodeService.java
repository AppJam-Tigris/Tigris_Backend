package team.appjam.tigris_server.domain.authcode.service;


import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Service;
import team.appjam.tigris_server.domain.authcode.entity.AuthCode;
import team.appjam.tigris_server.domain.authcode.exception.AuthCodeNotFoundException;
import team.appjam.tigris_server.domain.authcode.exception.InvalidAuthCodeException;
import team.appjam.tigris_server.domain.authcode.repository.AuthCodeRepository;
import team.appjam.tigris_server.domain.user.api.dto.request.SendAuthCodeRequest;
import team.appjam.tigris_server.global.sms.ShortMessageService;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthCodeService {

    private final AuthCodeRepository authCodeRepository;
    private final ShortMessageService shortMessageService;

    public void sendAuthCode(SendAuthCodeRequest authCodeRequest) {
        String random = RandomStringUtils.randomNumeric(6);

        Optional<AuthCode> authCode = authCodeRepository.findById(authCodeRequest.getPhoneNumber());

        if (authCode.isPresent()) {
            authCode
                    .map(code -> code.setCode(random))
                    .map(authCodeRepository::save);
        } else {
            authCodeRepository.save(
                    AuthCode.builder()
                            .code(random)
                            .phoneNumber(authCodeRequest.getPhoneNumber())
                            .expiration(1800L)
                            .build()
            );
        }
        shortMessageService.sendSMS(authCodeRequest.getPhoneNumber(), random);
    }

    public void verifyAuthCode(String phoneNumber, String code) {

        AuthCode authCode = authCodeRepository.findById(phoneNumber)
                .orElseThrow(() -> AuthCodeNotFoundException.EXCEPTION);

        if (!code.equals(authCode.getCode())) {
            throw InvalidAuthCodeException.EXCEPTION;
        }

    }

}
