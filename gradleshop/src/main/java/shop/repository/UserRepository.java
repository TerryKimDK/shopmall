package shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.domain.User;

public interface UserRepository extends JpaRepository<User, String> {
    public User findByEmail(String email);
//    public User findByUsername(String username);
//
//    public User findByProviderId(String providerId);
}
