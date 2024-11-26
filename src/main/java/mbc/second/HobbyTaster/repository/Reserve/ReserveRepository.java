package mbc.second.HobbyTaster.repository.Reserve;

import mbc.second.HobbyTaster.entity.Reserve.ReserveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReserveRepository extends JpaRepository<ReserveEntity, Long> {
}
