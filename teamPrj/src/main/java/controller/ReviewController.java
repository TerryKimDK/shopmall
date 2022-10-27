package controller;

import lombok.RequiredArgsConstructor;
import model.ReviewDTO;
import model.StoreDTO;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import service.ReviewService;
import service.StoreService;
import view.review.ReviewDetail;
import view.review.ReviewList;
import view.review.Write;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;
    private final StoreService storeService;

    public void reviewList() {
        int storeID = 1;
        List<ReviewDTO> list = reviewService.list(storeID);
        new ReviewList(list);
    }


    public void Write(int storeID) {
        StoreDTO store = storeService.getStore(storeID);
        new Write(store);
    }

    public int write(ReviewDTO review) {
        return reviewService.write(review);
    }

    public void reviewDetail(int reviewID){
        ReviewDTO review = reviewService.getReview(reviewID);
        StoreDTO store = storeService.getStore(review.getStore_id());
        new ReviewDetail(review,store);
    }

    public int modify(ReviewDTO review) {
        return reviewService.modify(review);
    }

    public int delete(ReviewDTO review) {
        return reviewService.delete(review);
    }

    private static ReviewController instance;

    public static ReviewController getInstance() {
        if (instance == null)
            instance = new ClassPathXmlApplicationContext("bean-config.xml").getBean("reviewController", ReviewController.class);

        return instance;
    }
}
