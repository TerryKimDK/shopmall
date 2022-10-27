package shop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import shop.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}