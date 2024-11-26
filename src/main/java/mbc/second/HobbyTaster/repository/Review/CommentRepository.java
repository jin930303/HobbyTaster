package mbc.second.HobbyTaster.repository.Review;

import mbc.second.HobbyTaster.entity.review.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    List<CommentEntity> findByRevnum(@Param("revnum") Long revnum);
}
