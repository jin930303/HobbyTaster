package mbc.second.HobbyTaster.repository.Review;

import mbc.second.HobbyTaster.entity.review.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

}
