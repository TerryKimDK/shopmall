package controller;

import lombok.RequiredArgsConstructor;
import model.ReviewDTO;
import model.StoreDTO;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import service.SearchService;
import service.StoreService;
import view.review.ReviewList;
import view.search.SearchList;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SearchController {
    private final SearchService searchService;
    private final StoreService storeService;
    private static SearchController instance;

    public void veganSearch(StoreDTO storeDTO){
        System.out.println("controller야"+storeDTO);
        List<StoreDTO> list = searchService.searchList(storeDTO);
        new SearchList(list);
    }

    public static SearchController getInstance() {
        if (instance == null)
            instance = new ClassPathXmlApplicationContext("bean-config.xml").getBean("searchController", SearchController.class);

        return instance;
    }
}
