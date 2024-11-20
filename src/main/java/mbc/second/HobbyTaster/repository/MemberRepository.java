package mbc.second.HobbyTaster.repository;

import mbc.second.HobbyTaster.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, String> {
    MemberEntity findOneById(String id);

    @Query(value = "select count(m.id) from member m where m.id=:id", nativeQuery = true)
    int idcheck(@Param("id") String id);

    @Query(value = "select count(m.nickname) from member m where m.nickname=:nickname", nativeQuery = true)
    int nicknamecheck(@Param("nickname") String nickname);

    @Query(value = "select count(m.email) from member m where m.email=:fullemail", nativeQuery = true)
    int emailcheck(@Param("fullemail") String fullemail);

    @Query(value = "select count(m.phone) from member m where m.phone=:fullphone", nativeQuery = true)
    int phonecheck(@Param("fullphone") String fullphone);
}
