package team.appjam.tigris_server.domain.authcode.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.appjam.tigris_server.domain.authcode.dto.SendAuthCodeRequest;
import team.appjam.tigris_server.domain.authcode.dto.VerifyAuthCodeRequest;
import team.appjam.tigris_server.domain.authcode.repository.AuthCodeRepository;

@RequiredArgsConstructor
@Service
public class AuthCodeService {

    private final AuthCodeRepository authCodeRepository;

    public void sendAuthCode(SendAuthCodeRequest authCodeRequest) {

    }

    public void verifyAuthCode(VerifyAuthCodeRequest authCodeRequest) {

    }

}
