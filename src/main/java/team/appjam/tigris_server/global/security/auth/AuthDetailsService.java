package team.appjam.tigris_server.global.security.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import team.appjam.tigris_server.domain.user.exception.UserNotFoundException;
import team.appjam.tigris_server.domain.user.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class AuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException {
        return new AuthDetails(
                userRepository.findByUid(uid)
                        .orElseThrow(() -> UserNotFoundException.EXCEPTION)
        );
    }

}
