package team.appjam.tigris_server.domain.authcode.repository;

import org.springframework.data.repository.CrudRepository;
import team.appjam.tigris_server.domain.authcode.entity.AuthCode;

public interface AuthCodeRepository extends CrudRepository<AuthCode, String> {
}
