package shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.entity.ItemImg;

public interface ItemImgRepository extends JpaRepository<ItemImg, Long> {
}
