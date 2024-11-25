package mbc.second.HobbyTaster.service.Review;

import mbc.second.HobbyTaster.entity.review.ReviewEntity;

import java.util.List;

public interface ReviewService {

    void saveReview(ReviewEntity review);

    List<ReviewEntity> getReviewsByClassId(long num);
}
