package demo_springjwt.demo.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import demo_springjwt.demo.dto.User;
import demo_springjwt.demo.entity.UserEntity;
import demo_springjwt.demo.exception.ExpiredException;
import demo_springjwt.demo.repository.UserRepository;


public class BaseController {
	@Autowired
	private UserRepository userRepository;
	
	protected Optional<User> getCurrentUser() throws ExpiredException {
		UserEntity userEntity = this.getCurrentUserEntity()
				.orElseThrow(() -> new ExpiredException("Token expired"));
		return Optional.of(User.toDto(userEntity));
	}
	
	protected Optional<UserEntity> getCurrentUserEntity() {
		Authentication userAuthentication = SecurityContextHolder.getContext().getAuthentication();
		if (userAuthentication == null) {
			return Optional.empty();
		}
		String principal = userAuthentication.getName();
		return this.userRepository.findByUsername(principal);
	}
}
