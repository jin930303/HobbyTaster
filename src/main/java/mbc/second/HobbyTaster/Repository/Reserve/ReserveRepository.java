package mbc.second.HobbyTaster.Repository.Reserve;

import mbc.second.HobbyTaster.Entity.Reserve.ReserveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReserveRepository extends JpaRepository<ReserveEntity, Long> {
}
