package shop.dto;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import shop.entity.ItemImg;


    @Getter
    @Setter
    public class ItemImgDto {

        private Long id;

        private String itemNm;

        private Integer price;

        private String itemDetail;

        private String repImgYn;
        private static ModelMapper modelMapper = new ModelMapper();

        public static ItemImgDto of(ItemImg itemImg) {
            return modelMapper.map(itemImg, ItemImgDto.class);
        }
    }

