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
    @Query(value = "SELECT * FROM (SELECT * FROM cclass WHERE cat1 = '공예' AND cat2 = '도예' ORDER BY ccnt DESC) WHERE ROWNUM = 1", nativeQuery = true)
    List<ClassInterface> doye_out();

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM (SELECT * FROM cclass WHERE cat1 = '공예' AND cat2 = '인형' ORDER BY ccnt DESC) WHERE ROWNUM = 1", nativeQuery = true)
    List<ClassInterface> doll_out();

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM (SELECT * FROM cclass WHERE cat1 = '공예' AND cat2 = '쥬얼리' ORDER BY ccnt DESC) WHERE ROWNUM = 1", nativeQuery = true)
    List<ClassInterface> jewelle_out();

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM (SELECT * FROM cclass WHERE cat1 = '예술' AND cat2 = '드로잉' ORDER BY ccnt DESC) WHERE ROWNUM = 1", nativeQuery = true)
    List<ClassInterface> drawing_out();

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM (SELECT * FROM cclass WHERE cat1 = '예술' AND cat2 = '사진' ORDER BY ccnt DESC) WHERE ROWNUM = 1", nativeQuery = true)
    List<ClassInterface> picture_out();

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM (SELECT * FROM cclass WHERE cat1 = '예술' AND cat2 = '음악' ORDER BY ccnt DESC) WHERE ROWNUM = 1", nativeQuery = true)
    List<ClassInterface> music_out();

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM (SELECT * FROM cclass WHERE cat1 = '베이킹' AND cat2 = '쿠키' ORDER BY ccnt DESC) WHERE ROWNUM = 1", nativeQuery = true)
    List<ClassInterface> cookie_out();

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM (SELECT * FROM cclass WHERE cat1 = '베이킹' AND cat2 = '케이크' ORDER BY ccnt DESC) WHERE ROWNUM = 1", nativeQuery = true)
    List<ClassInterface> cake_out();

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM (SELECT * FROM cclass WHERE cat1 = '베이킹' AND cat2 = '빵' ORDER BY ccnt DESC) WHERE ROWNUM = 1", nativeQuery = true)
    List<ClassInterface> bread_out();

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM (SELECT * FROM cclass WHERE cat1 = '주류' AND cat2 = '와인' ORDER BY ccnt DESC) WHERE ROWNUM = 1", nativeQuery = true)
    List<ClassInterface> wine_out();

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM (SELECT * FROM cclass WHERE cat1 = '주류' AND cat2 = '맥주' ORDER BY ccnt DESC) WHERE ROWNUM = 1", nativeQuery = true)
    List<ClassInterface> beer_out();

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM (SELECT * FROM cclass WHERE cat1 = '주류' AND cat2 = '전통주' ORDER BY ccnt DESC) WHERE ROWNUM = 1", nativeQuery = true)
    List<ClassInterface> tradition_out();
}
