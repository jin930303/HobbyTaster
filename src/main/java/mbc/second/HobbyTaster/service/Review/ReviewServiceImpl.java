package mbc.second.HobbyTaster.service.Review;

import mbc.second.HobbyTaster.entity.review.ReviewEntity;
import mbc.second.HobbyTaster.repository.Review.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements  ReviewService{

    @Autowired
    ReviewRepository reviewRepository;


    @Override
    public void saveReview(ReviewEntity review) {
        reviewRepository.save(review);
    }

    @Override
    public List<ReviewEntity> getReviewsByClassId(long num) {
        return reviewRepository.findByCnum((int) num);
    }
}
