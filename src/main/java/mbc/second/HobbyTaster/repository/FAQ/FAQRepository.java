package mbc.second.HobbyTaster.repository.FAQ;

import mbc.second.HobbyTaster.entity.FAQ.FAQEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FAQRepository extends JpaRepository<FAQEntity, Long> {
}
