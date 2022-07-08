package demo_springjwt.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo_springjwt.demo.entity.TokenEntity;
import demo_springjwt.demo.repository.TokenRepository;
import demo_springjwt.demo.service.TokenService;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    public TokenEntity createToken(TokenEntity tokenEntity) {
        return tokenRepository.saveAndFlush(tokenEntity);
    }

    @Override
    public TokenEntity findByToken(String token) {
        return tokenRepository.findByToken(token);
    }

	@Override
	public void delete(TokenEntity token) {
		this.tokenRepository.delete(token);
	}
}
