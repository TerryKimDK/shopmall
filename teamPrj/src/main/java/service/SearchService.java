package service;

import lombok.RequiredArgsConstructor;
import model.ReviewDTO;
import model.StoreDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final SessionFactory factory;

    public List<StoreDTO> searchList(StoreDTO vegan) {
        System.out.println("SERVICE + " + vegan);
        return factory.getInstance().selectList("SearchMapper.list", vegan); } // .뒤에가 id , 뒤에가 parameter
}
