package mbc.second.HobbyTaster.Service.Review;


import mbc.second.HobbyTaster.Entity.Review.CommentEntity;

import java.util.List;

public interface CommentService {

    List<CommentEntity> getCommentsByReview(Long revnum);

    CommentEntity saveComment(Long revnum, String id, String comcontents);


}
