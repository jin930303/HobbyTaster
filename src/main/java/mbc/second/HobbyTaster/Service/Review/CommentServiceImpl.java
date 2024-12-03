package mbc.second.HobbyTaster.Service.Review;

import mbc.second.HobbyTaster.Entity.Review.CommentEntity;
import mbc.second.HobbyTaster.Repository.Review.CommentRepository;
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
