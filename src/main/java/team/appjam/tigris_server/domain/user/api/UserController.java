package team.appjam.tigris_server.domain.user.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import team.appjam.tigris_server.domain.user.api.dto.JoinRequest;
import team.appjam.tigris_server.domain.user.api.dto.LoginRequest;
import team.appjam.tigris_server.domain.user.service.UserService;
import team.appjam.tigris_server.global.security.jwt.dto.TokenResponse;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void join(@RequestBody JoinRequest joinRequest) {
        userService.join(joinRequest);
    }

    @PostMapping("/auth")
    public TokenResponse login(@RequestBody LoginRequest loginRequest) {
        return userService.login(loginRequest);
    }

}
