package mbc.second.HobbyTaster.Repository.Reserve;

import jakarta.transaction.Transactional;
import mbc.second.HobbyTaster.Entity.Class.ClassEntity;
import mbc.second.HobbyTaster.Entity.Member.MemberEntity;
import mbc.second.HobbyTaster.Entity.Reserve.ReserveEntity;
import mbc.second.HobbyTaster.Service.Class.ClassInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReserveRepository extends JpaRepository<ReserveEntity, Long> {
    @Transactional
    @Query(value = "select cpl from cclass where cnum = :cnum",nativeQuery = true)
    Integer findCplByCnum(@Param("cnum") long cnum);

    @Transactional
    @Query(value = "select count(*) from reserve where cnum = :cnum", nativeQuery = true)
    Integer countByCnum(@Param("cnum") long cnum);

    List<ReserveEntity> findByUserId(String userId);

    @Transactional
    @Query(value = "select nickname from member where id = :userId", nativeQuery = true)
    String nicknamefind(@Param("userId") String userId);

    @Transactional
    @Query(value = "select c.*, r.*, m.name as member_name, m.phone as member_phone, m.email as member_email " +
            "from reserve r " +
            "join cclass c on r.cnum = c.cnum " +
            "join member m on r.id = m.id " +
            "where c.cteach = :nickname", nativeQuery = true)
    List<ClassInterface> findState(@Param("nickname") String nickname);
}
