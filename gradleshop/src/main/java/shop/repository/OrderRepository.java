package shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
