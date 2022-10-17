package controller;

import lombok.RequiredArgsConstructor;
import model.ReviewDTO;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import view.ReviewView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReviewController {

    public void reviewView() {
        List<ReviewDTO> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ReviewDTO review = new ReviewDTO();
            review.setReview_id(i);
            review.setStore_id(i);
            review.setId("id " + i);
            review.setTitle("title" + i);
            review.setContent("content " + i);

            list.add(review);
        }
        System.out.println(list.get(0).getTitle());
        System.out.println(list.get(1).getTitle());
        new ReviewView(list);
    }

    public void reviewWrite() {

    }

    private static ReviewController instance;

    public static ReviewController getInstance() {
        if (instance == null)
            instance = new ClassPathXmlApplicationContext("bean-config.xml").getBean("reviewController", ReviewController.class);

        return instance;
    }

}
