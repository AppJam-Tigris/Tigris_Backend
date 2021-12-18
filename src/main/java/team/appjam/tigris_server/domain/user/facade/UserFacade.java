package team.appjam.tigris_server.domain.user.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import team.appjam.tigris_server.domain.user.entity.User;
import team.appjam.tigris_server.domain.user.repository.UserRepository;
import team.appjam.tigris_server.global.exception.AuthenticationNotFoundException;
import team.appjam.tigris_server.domain.user.exception.UserNotFoundException;
import team.appjam.tigris_server.global.security.auth.AuthDetails;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;

    public User getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(!(principal instanceof AuthDetails))
            throw AuthenticationNotFoundException.EXCEPTION;

        return ((AuthDetails) principal).getUser();
    }

    public User getByUid(String uid) {
        return userRepository.findByUid(uid)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

}
