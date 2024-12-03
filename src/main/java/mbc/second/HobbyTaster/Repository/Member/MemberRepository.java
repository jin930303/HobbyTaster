package mbc.second.HobbyTaster.Repository.Member;

import mbc.second.HobbyTaster.Entity.Member.MemberEntity;
import mbc.second.HobbyTaster.Service.Member.MemberInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional
    @Query(value = "select m.id, m.pw, m.nickname, m.name, m.gender, m.email, m.phone, m.address, m.auth, m.state " +
            "from member m where m.id=:id", nativeQuery = true)
    List<MemberInterface> myinfo(@Param("id") String id);

    @Transactional
    @Modifying
    @Query(value = "update member m set m.email=:email, m.gender=:gender, m.name=:name, m.nickname=:nickname, " +
            "m.phone=:phone, m.auth=:auth, m.state=:state, m.address=:address where m.id=:id", nativeQuery = true)
    void updateinfo(@Param("id") String id,
                    @Param("email") String email,
                    @Param("gender") String gender,
                    @Param("name") String name,
                    @Param("nickname") String nickname,
                    @Param("phone") String phone,
                    @Param("auth") int auth,
                    @Param("state") String state,
                    @Param("address") String address);

    @Transactional
    @Modifying
    @Query(value = "update member m set m.state=:state where m.id=:id", nativeQuery = true)
    void updatestate(@Param("id") String id, @Param("state") String state);

    @Query(value = "select count(m.id) from member m where m.id=:id and m.email=:fullemail and m.phone=:fullphone", nativeQuery = true)
    int pwcheck(@Param("id") String id, @Param("fullemail") String fullemail, @Param("fullphone") String fullphone);

    @Transactional
    @Modifying
    @Query(value = "update member m set m.pw=:pwbcryt where m.id=:id", nativeQuery = true)
    void pwupdate(@Param("id") String id, @Param("pwbcryt") String pwbcryt);

    @Query(value = "select m.id from member m where m.email=:fullemail", nativeQuery = true)
    String findidemail(@Param("fullemail") String fullemail);

    @Query(value = "select m.id from member m where m.phone=:fullphone", nativeQuery = true)
    String findidphone(@Param("fullphone") String fullphone);
}
