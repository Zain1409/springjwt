package demo_springjwt.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import demo_springjwt.demo.entity.TokenEntity;

public interface TokenRepository extends JpaRepository<TokenEntity, Long> {

    TokenEntity findByToken(String token);
}
