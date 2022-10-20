package shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;
import shop.dto.ItemFormDto;
import shop.dto.ItemImgDto;
import shop.dto.ItemSearchDto;
import shop.dto.MainItemDto;
import shop.entity.Item;
import shop.entity.ItemImg;
import shop.repository.ItemImgRepository;
import shop.repository.ItemRepository;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {
    private final ItemRepository itemRepository;
    private final ItemImgService itemImgService;
    private final ItemImgRepository itemImgRepository;

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

//    }
    // 상품 관리 페이지 상품 목록 조회
    @Transactional(readOnly = true)
    public Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable) {
        return itemRepository.getAdminItemPage(itemSearchDto, pageable);
    }
    @Transactional(readOnly = true)
    public ItemFormDto getItemDetail(Long itemId){
        // 상품 이미지 엔티티들을 itemImgDto 객체로 변환하여 itemImgDtoList 에 담음
        List<ItemImg> itemImgList = itemImgRepository.findByItemIdOrderByIdAsc(itemId);
        List<ItemImgDto> itemImgDtoList = new ArrayList<>();

        for (ItemImg itemImg : itemImgList) {
            ItemImgDto itemImgDto = ItemImgDto.of(itemImg);
            itemImgDtoList.add(itemImgDto);
        }

        // 상품 엔티티를 ItemFormDto 객체로 변환하고 itemImgDtoList 멤버변수를 초기화
        Item item = itemRepository.findById(itemId).orElseThrow(EntityNotFoundException::new);
        ItemFormDto itemFormDto = ItemFormDto.of(item);
        itemFormDto.setItemImgDtoList(itemImgDtoList);
        return itemFormDto;
    }
    // 상품 수정
    public Long updateItem(ItemFormDto itemFormDto, List<MultipartFile> itemImgFileList) throws IOException {

        // 상품 수정
        Item item = itemRepository.findById(itemFormDto.getId()).orElseThrow(EntityNotFoundException::new);
        item.updateItem(itemFormDto);

        // 상품 이미지 수정
        List<Long> itemImgIds = itemFormDto.getItemImgIds();
        for (int i = 0; i < itemImgFileList.size(); i++) {
            itemImgService.updateItemImg(itemImgIds.get(i), itemImgFileList.get(i));
        }

        return item.getId();
    }
    // 메인 페이지 상품 목록 조회
    @Transactional(readOnly = true)
    public Page<MainItemDto> getMainItemPage(ItemSearchDto itemSearchDto, Pageable pageable){
        return itemRepository.getMainItemPage(itemSearchDto, pageable);
    }

}
