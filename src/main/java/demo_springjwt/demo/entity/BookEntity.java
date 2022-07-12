package demo_springjwt.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_book")
@Getter
@Setter
public class BookEntity extends BaseEntity{
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private String path;
}
