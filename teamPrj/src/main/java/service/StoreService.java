package service;

import lombok.RequiredArgsConstructor;
import model.StoreDTO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final SessionFactory factory;
    public StoreDTO getStore(int storeID) {return factory.getInstance().selectOne("StoreMapper.getStore",storeID);}
    public int create(StoreDTO store){return factory.getInstance().insert("StoreMapper.create", store);}

}
