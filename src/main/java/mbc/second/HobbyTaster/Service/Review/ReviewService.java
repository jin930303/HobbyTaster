package mbc.second.HobbyTaster.Service.Review;

import mbc.second.HobbyTaster.Entity.Review.ReviewEntity;

import java.util.List;

public interface ReviewService {

    void saveReview(ReviewEntity review);

    List<ReviewEntity> getReviewsByClassId(long num);
}
