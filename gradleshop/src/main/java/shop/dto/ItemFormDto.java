package shop.dto;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;
import shop.entity.Item;
import shop.constant.ItemSellStatus;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
@Getter @Setter
public class ItemFormDto {
    private Long id;

    @NotBlank(message = "상품명은 필수 입력 값입니다.")
    private String itemName;

    @NotNull(message = "가격은 필수 입력 값입니다.")
    private Integer price;

    @NotBlank(message = "이름은 필수 입력 값입니다.")
    private String itemDetail;

    @NotNull(message = "재고는 필수 입력 값입니다.")
    private Integer stock;

    private ItemSellStatus itemSellStatus;

    // 상품 수정 시 사용되는 멤버변수들
    private List<ItemImgDto> itemImgDtoList = new ArrayList<>();

    private List<Long> itemImgIds = new ArrayList<>();

    private static ModelMapper modelMapper = new ModelMapper();

    //DTO -> Entity
    public Item createItem() {
        return modelMapper.map(this, Item.class);
    }
    // Entity -> Dto
    public static ItemFormDto of(Item item){
        return modelMapper.map(item,ItemFormDto.class);
    }


}
