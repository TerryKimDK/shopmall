package shop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import shop.dto.ItemSearchDto;
import shop.dto.MainItemDto;
import shop.entity.Item;

public interface ItemRepositoryCustom {
    Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable);
    Page<MainItemDto> getMainItemPage(ItemSearchDto itemSearchDto, Pageable pageable);
}
