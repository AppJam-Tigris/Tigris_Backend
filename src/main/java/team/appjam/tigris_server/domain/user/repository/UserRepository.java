package team.appjam.tigris_server.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.appjam.tigris_server.domain.user.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUid(String uid);
    Optional<User> findByUidOrPhoneNumberOrBirthDay(String uid, String phoneNumber, Integer birthDay);
}
