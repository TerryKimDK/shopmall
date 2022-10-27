package service;

import lombok.RequiredArgsConstructor;
import model.ReviewDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final SessionFactory factory;

    public List<ReviewDTO> list(int storeID) { return factory.getInstance().selectList("ReviewMapper.list", storeID); }
    public ReviewDTO getReview(int reviewID) { return factory.getInstance().selectOne("ReviewMapper.getReview",reviewID); }
    public int write(ReviewDTO review) { return factory.getInstance().insert("ReviewMapper.write", review); }
    public int modify(ReviewDTO review){ return factory.getInstance().update("ReviewMapper.modify",review);}
    public int delete(ReviewDTO review){ return factory.getInstance().delete("ReviewMapper.delete",review); }
}
