package shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.entity.Member;
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByEmail(String email);
}
