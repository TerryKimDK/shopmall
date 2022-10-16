package shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
