package mbc.second.HobbyTaster.Repository.Class;

import jakarta.transaction.Transactional;

import mbc.second.HobbyTaster.Entity.Class.ClassEntity;
import mbc.second.HobbyTaster.Service.Class.ClassInterface;
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
    @Query(value = "update cclass set cstate ='진행' where cclass.cnum=:cnum",nativeQuery = true)
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

    // rownum은 데이터 번호를 나눠 구분하는것
    // 내부쿼리 select * from cclass where cat1 = :categories / order by cnum asc == 오름차순 정렬
    // 서브쿼리 select c.*, == 서브쿼리 전체/  ROWNUM as rn == rownum 변수
    //         from ( 내부 쿼리 ) c == 변수명 c로 지정 / where rownum <= :endRow == endRow보다 작거나 같으면.
    // 외부쿼리 select * from ( 서브( 내부 쿼리 )쿼리 ) where rn >= : startRow
    @Transactional
    @Query(value = "select * from " +
            " (select c.*, ROWNUM as rn from " +
            " (select * from cclass where cat1 = :categories ORDER BY cnum ASC) c " +
            " where ROWNUM <= :endRow) " +
            " where rn >= :startRow",
            nativeQuery = true)
    List<ClassEntity> findByCat1WithRowNum(
            @Param("categories") String categories,
            @Param("startRow") int startRow,
            @Param("endRow") int endRow);

    @Transactional
    @Query(value = "SELECT COUNT(*) FROM cclass WHERE cat1 = :categories", nativeQuery = true)
    int countByCat1(@Param("categories") String categories);
}



