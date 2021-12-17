package team.appjam.tigris_server.domain.refreshtoken.repository;

import org.springframework.data.repository.CrudRepository;
import team.appjam.tigris_server.domain.refreshtoken.entity.RefreshToken;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
}
