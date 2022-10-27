package model;

import lombok.Data;
@Data
public class StoreDTO {

    private int store_id, capacity;
    private Float lat, lon;
    private String vegan, imagePath, name, detail, address, contact, open, close, category;

}
