package mbc.second.HobbyTaster.repository;

import mbc.second.HobbyTaster.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, String> {
    MemberEntity findOneById(String id);
}
