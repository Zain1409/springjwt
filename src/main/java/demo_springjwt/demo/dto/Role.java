package demo_springjwt.demo.dto;

import demo_springjwt.demo.entity.RoleEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Role {
	private Long id;
	private String name;
	
	public static Role toDto(RoleEntity entity) {
		Role role = new Role();
		role.setId(entity.getId());
		role.setName(entity.getName());
		return role;
	}
	
	public static RoleEntity toDomain(Role dto) {
		RoleEntity role = new RoleEntity();
		role.setId(dto.getId());
		role.setName(dto.getName());
		return role;
	}
}
