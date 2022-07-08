package demo_springjwt.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo_springjwt.demo.dto.User;
import demo_springjwt.demo.entity.UserEntity;
import demo_springjwt.demo.repository.UserRepository;
import demo_springjwt.demo.security.UserPrincipal;
import demo_springjwt.demo.service.UserService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
    	UserEntity saved = userRepository.saveAndFlush(User.toDomain(user));
        return User.toDto(saved);
    }

    @Override
    public UserPrincipal findByUsername(String username) {
        Optional<UserEntity> userEntity = userRepository.findByUsername(username);
        UserPrincipal userPrincipal = new UserPrincipal();
        if (userEntity.isPresent()) {
            Set<String> authorities = new HashSet<>();
            userPrincipal.setUserId(userEntity.get().getId());
            userPrincipal.setUsername(userEntity.get().getUsername());
            userPrincipal.setPassword(userEntity.get().getPassword());
            if (null != userEntity.get().getRoleEntities()) userEntity.get().getRoleEntities().forEach(r -> {
                authorities.add(r.getName());
            });
            userPrincipal.setAuthorities(authorities);
        }
        return userPrincipal;
    }

	@Override
	public boolean existsByUsername(String username) {
		if(userRepository.existsByUsername(username))
			return true;
		return false;
	}

}
