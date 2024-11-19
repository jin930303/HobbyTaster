package mbc.second.HobbyTaster.repository;

import jakarta.transaction.Transactional;
import mbc.second.HobbyTaster.dto.Class.ClassDTO;
import mbc.second.HobbyTaster.entity.Class.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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


}
