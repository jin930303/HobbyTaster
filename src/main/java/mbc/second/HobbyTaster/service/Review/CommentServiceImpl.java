package mbc.second.HobbyTaster.service.Review;

import mbc.second.HobbyTaster.entity.review.CommentEntity;
import mbc.second.HobbyTaster.repository.Review.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentRepository commentRepository;

    @Override
    public void saveComment(Long revnum, String id, String comcontents) {

    }
}
