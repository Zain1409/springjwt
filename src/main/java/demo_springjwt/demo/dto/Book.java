package demo_springjwt.demo.dto;

import demo_springjwt.demo.entity.BookEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
	private Long id;
	
	private String name;
	
	private String path;
	
	public static Book toDto(BookEntity entity) {
		Book result = new Book();
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setPath(entity.getPath());
		return result;
	}
	
	public static BookEntity toDomain(Book dto) {
		BookEntity result = new BookEntity();
		result.setId(dto.getId());
		result.setName(dto.getName());
		result.setPath(dto.getPath());
		return result;
	}
}
