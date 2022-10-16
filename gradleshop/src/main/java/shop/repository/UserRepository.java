package shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.entity.Member;

public interface UserRepository extends JpaRepository<Member, Long> {
    public Member findByEmail(String email);
//    public User findByUsername(String username);
//
//    public User findByProviderId(String providerId);
}
