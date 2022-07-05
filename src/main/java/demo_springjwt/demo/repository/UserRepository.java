package demo_springjwt.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import demo_springjwt.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
