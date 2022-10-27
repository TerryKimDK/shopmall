package controller;

import lombok.RequiredArgsConstructor;
import model.StoreDTO;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import service.StoreService;
import view.store.Create;

@Controller
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    public StoreDTO getStore(int storeID){
        StoreDTO store = storeService.getStore(storeID);
        return store;
    }
    public void Create(){new Create();}
    public int create(StoreDTO store){return storeService.create(store);}


    private static StoreController instance;

    public static StoreController getInstance() {
        if (instance == null)
            instance = new ClassPathXmlApplicationContext("bean-config.xml").getBean("storeController", StoreController.class);

        return instance;
    }

}
