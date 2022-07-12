package demo_springjwt.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo_springjwt.demo.entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long>{
	Optional<BookEntity> findById(Long id);
}
