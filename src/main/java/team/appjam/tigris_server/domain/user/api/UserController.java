package team.appjam.tigris_server.domain.user.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import team.appjam.tigris_server.domain.user.api.dto.request.*;
import team.appjam.tigris_server.domain.authcode.service.AuthCodeService;
import team.appjam.tigris_server.domain.user.api.dto.response.UserInfoResponse;
import team.appjam.tigris_server.domain.user.service.UserService;
import team.appjam.tigris_server.global.security.jwt.dto.TokenResponse;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final AuthCodeService authCodeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void join(@RequestBody @Valid JoinRequest joinRequest) {
        userService.join(joinRequest);
    }

    @PostMapping("/auth")
    public TokenResponse login(@RequestBody @Valid LoginRequest loginRequest) {
        return userService.login(loginRequest);
    }

    @PostMapping("/phone")
    public void send(@RequestBody @Valid SendAuthCodeRequest authCodeRequest) {
        authCodeService.sendAuthCode(authCodeRequest);
    }

    @PutMapping("/phone")
    public void verify(@RequestBody @Valid VerifyAuthCodeRequest authCodeRequest) {
        authCodeService.verifyAuthCode(authCodeRequest);
    }

    @GetMapping
    public UserInfoResponse getMyInfo() {
        return userService.getMyInfo();
    }

    @PostMapping("/duplicate")
    public void checkDuplicateUid(@RequestBody @Valid CheckDuplicateRequest checkDuplicateRequest) {
        userService.checkDuplicationUid(checkDuplicateRequest);
    }

}
