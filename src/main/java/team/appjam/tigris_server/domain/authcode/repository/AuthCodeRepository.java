package team.appjam.tigris_server.domain.authcode.repository;

import org.springframework.data.repository.CrudRepository;
import team.appjam.tigris_server.domain.authcode.entity.AuthCode;

import java.util.Optional;

public interface AuthCodeRepository extends CrudRepository<AuthCode, Integer> {
    Optional<AuthCode> findByPhoneNumber(String phoneNum);
}
