package mbc.second.HobbyTaster.Repository.Review;

import mbc.second.HobbyTaster.Entity.Review.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    List<CommentEntity> findByRevnum(@Param("revnum") Long revnum);
}
