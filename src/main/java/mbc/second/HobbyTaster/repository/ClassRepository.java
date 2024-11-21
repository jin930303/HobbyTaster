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

import java.time.LocalDate;
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

    // 날짜만 검색
    List<ClassEntity> findByCdate(LocalDate cdate);

    // 검색어만 검색 (cname 또는 cteach)
    List<ClassEntity> findByCnameContainingIgnoreCaseOrCteachContainingIgnoreCase(String cnameKeyword, String cteachKeyword);

    // 검색어, 날짜 다중 선택
    List<ClassEntity> findByCdateAndCnameContainingIgnoreCaseOrCteachContainingIgnoreCase(
            LocalDate cdate, String cnameKeyword, String cteachKeyword);
    // 시간만 선택
    List<ClassEntity> findByCtimeContaining(String ctimekeyword);

    // 카테고리 1만 선택
    List<ClassEntity> findByCat1Containing(String cat1);

    // 카테고리 2 선택
    List<ClassEntity> findByCat2Containing(String cat2);
}
