package demo_springjwt.demo.service;

import demo_springjwt.demo.entity.TokenEntity;

public interface TokenService {

    TokenEntity createToken(TokenEntity tokenEntity);

    TokenEntity findByToken(String token);
    
    void delete(TokenEntity token);
}
