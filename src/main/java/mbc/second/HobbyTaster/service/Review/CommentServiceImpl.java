package mbc.second.HobbyTaster.service.Review;

import mbc.second.HobbyTaster.entity.review.CommentEntity;
import mbc.second.HobbyTaster.repository.Review.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentRepository commentRepository;


    @Override
    public List<CommentEntity> getCommentsByReview(Long revnum) {
        return commentRepository.findByRevnum(revnum);
    }

    @Override
    public CommentEntity  saveComment(Long revnum, String id, String comcontents) {
        CommentEntity comment = CommentEntity.builder()
                .revnum(revnum)
                .id(id)
                .comcontents(comcontents)
                .comdate(LocalDate.now())
                .build();
        return commentRepository.save(comment); // 댓글 저장
    }

}
