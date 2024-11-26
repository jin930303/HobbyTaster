package mbc.second.HobbyTaster.service.Review;


import mbc.second.HobbyTaster.entity.review.CommentEntity;

import java.util.List;

public interface CommentService {

    List<CommentEntity> getCommentsByReview(Long revnum);

    CommentEntity saveComment(Long revnum, String id, String comcontents);


}
