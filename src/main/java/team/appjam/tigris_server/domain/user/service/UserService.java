package team.appjam.tigris_server.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.appjam.tigris_server.domain.user.api.dto.request.CheckDuplicateRequest;
import team.appjam.tigris_server.domain.user.api.dto.request.JoinRequest;
import team.appjam.tigris_server.domain.user.api.dto.request.LoginRequest;
import team.appjam.tigris_server.domain.user.api.dto.response.UserInfoResponse;
import team.appjam.tigris_server.domain.user.entity.User;
import team.appjam.tigris_server.domain.user.facade.UserFacade;
import team.appjam.tigris_server.domain.user.repository.UserRepository;
import team.appjam.tigris_server.domain.user.exception.InvalidPasswordException;
import team.appjam.tigris_server.domain.user.exception.UserAlreadyExistsException;
import team.appjam.tigris_server.global.security.jwt.JwtTokenProvider;
import team.appjam.tigris_server.global.security.jwt.dto.TokenResponse;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserFacade userFacade;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider tokenProvider;

    @Transactional
    public void join(JoinRequest joinRequest) {
        if(userRepository.findByUidOrPhoneNumberOrBirthDay(
                joinRequest.getUid(),
                joinRequest.getPhoneNumber(),
                joinRequest.getBirthDay()
        ).isPresent()) {
            throw UserAlreadyExistsException.EXCEPTION;
        }

        userRepository.save(
                User.builder()
                        .name(joinRequest.getName())
                        .phoneNumber(joinRequest.getPhoneNumber())
                        .birthDay(joinRequest.getBirthDay())
                        .gender(joinRequest.getGender())
                        .nationality(joinRequest.getNationality())
                        .location(joinRequest.getLocation())
                        .uid(joinRequest.getUid())
                        .password(passwordEncoder.encode(joinRequest.getPassword()))
                        .build()
        );

    }

    @Transactional
    public TokenResponse login(LoginRequest loginRequest) {
        return Optional.of(userFacade.getByUid(loginRequest.getUid()))
                .filter(
                        user -> passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())
                )
                .map(
                        user -> tokenProvider.generateToken(loginRequest.getUid(), "user")
                )
                .orElseThrow(() -> InvalidPasswordException.EXCEPTION);
    }

    @Transactional(readOnly = true)
    public UserInfoResponse getMyInfo() {
        User user = userFacade.getCurrentUser();

        return new UserInfoResponse(user);
    }

    public void checkDuplicationUid(CheckDuplicateRequest checkDuplicateRequest) {

        if(userRepository.findByUid(checkDuplicateRequest.getUid()).isPresent())
            throw UserAlreadyExistsException.EXCEPTION;

    }

}
