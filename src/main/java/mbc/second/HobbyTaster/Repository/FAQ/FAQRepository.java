package mbc.second.HobbyTaster.Repository.FAQ;

import mbc.second.HobbyTaster.Entity.FAQ.FAQEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FAQRepository extends JpaRepository<FAQEntity, Long> {
}
