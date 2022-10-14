package controller;

import lombok.RequiredArgsConstructor;
import model.ReviewDTO;
import org.springframework.stereotype.Controller;
import view.ReviewView;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class ReviewController {

    public void ReviewView() {
        new ReviewView();
    }

    public List<ReviewDTO> ReviewList(){
        List<ReviewDTO> list = new ArrayList<>();

        return list;
    }

    public void ReviewWrite(){

    }

}
