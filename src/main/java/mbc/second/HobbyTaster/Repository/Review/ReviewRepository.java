package mbc.second.HobbyTaster.Repository.Review;

import mbc.second.HobbyTaster.Entity.Review.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {

    List<ReviewEntity> findByCnum(int num);
}
