package team.appjam.tigris_server.domain.user.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import team.appjam.tigris_server.domain.user.entity.User;
import team.appjam.tigris_server.domain.user.repository.UserRepository;
import team.appjam.tigris_server.global.exception.UserNotFoundException;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;

    public User getByUid(String uid) {
        return userRepository.findByUid(uid)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

}
