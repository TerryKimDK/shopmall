package shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import shop.dto.ItemFormDto;
import shop.entity.Item;
import shop.entity.ItemImg;
import shop.repository.ItemImgRepository;
import shop.repository.ItemRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {
    private final ItemRepository itemRepository;
    private final ItemImgService itemImgService;

    // 상품 등록
    public Long saveItem(ItemFormDto itemFormDto,
                         List<MultipartFile> itemImgFileList) throws Exception {

        // 상품 등록 (1번)
        Item item = itemFormDto.createItem();
        itemRepository.save(item);

        // 이미지 등록(2번, 순서중요)
        for (int i = 0; i < itemImgFileList.size(); i++) {
            ItemImg itemimg = new ItemImg();
            itemimg.setItem(item);
            if (i == 0) {
                itemimg.setRepImgYn("Y");
            } else {
                itemimg.setRepImgYn("N");
            }
            itemImgService.saveItemImg(itemimg, itemImgFileList.get(i));
        }
        return item.getId();

    }

}
