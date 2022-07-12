package demo_springjwt.demo.dto;

import java.util.List;
import java.util.stream.Collectors;

import demo_springjwt.demo.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	private Long id;
	private String username;
	private String password;
	private boolean deleted;
	private List<Role> roles;
	
	public static User toDto(UserEntity enity) {
		User user = new User();
		user.setId(enity.getId());
		user.setUsername(enity.getUsername());
		user.setPassword(enity.getPassword());
		user.setDeleted(enity.isDeleted());
		user.setRoles(enity.getRoleEntities() != null ? enity.getRoleEntities().stream().map(Role::toDto).collect(Collectors.toList()) : null);
		return user;
	}
	
	public static UserEntity toDomain(User dto) {
		UserEntity user = new UserEntity();
		user.setId(dto.getId());
		user.setUsername(dto.getUsername());
		user.setPassword(dto.getPassword());
		user.setRoleEntities(dto.getRoles() != null ? dto.getRoles().stream().map(Role::toDomain).collect(Collectors.toList()) : null);
		return user;
	}
}
