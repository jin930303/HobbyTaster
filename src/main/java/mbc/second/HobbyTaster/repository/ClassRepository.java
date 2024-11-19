package mbc.second.HobbyTaster.repository;

import jakarta.transaction.Transactional;
import mbc.second.HobbyTaster.dto.Class.ClassDTO;
import mbc.second.HobbyTaster.entity.Class.ClassEntity;
import mbc.second.HobbyTaster.service.Class.ClassInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<ClassEntity,Long> {

    @Modifying
    @Transactional
    @Query(value = "update cclass set cstate ='시작' where cclass.cnum=:cnum",nativeQuery = true)
    void start(@Param("cnum") long cnum);

    @Transactional
    @Modifying
    @Query(value = "update cclass set cstate ='반려' where cclass.cnum=:cnum",nativeQuery = true)
    void creturn(@Param("cnum")long cnum);

    @Transactional
    @Modifying
    @Query(value = "update cclass set cstate ='종료' where cclass.cnum=:cnum",nativeQuery = true)
    void cfinish(@Param("cnum") long cnum);


    @Transactional
    @Modifying
    @Query(value = "update cclass set ccnt = ccnt+1 where cclass.cnum=:cnum", nativeQuery = true)
    void readcnt(@Param("cnum") long cnum);

    // 메인 페이지

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM (SELECT * FROM cclass WHERE cat1 = :cat1 AND cat2 = :cat2 ORDER BY ccnt DESC) WHERE ROWNUM = 1", nativeQuery = true)
    List<ClassInterface> categoryclass(@Param("cat1") String cat1,@Param("cat2") String cat2);
}
