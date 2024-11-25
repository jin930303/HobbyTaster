package mbc.second.HobbyTaster.service.Member;

import mbc.second.HobbyTaster.dto.Member.MemberDTO;
import mbc.second.HobbyTaster.entity.MemberEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberService {

    void insertm(MemberDTO dto);

    int idcheck(String id);

    int nicknamecheck(String nickname);

    int emailcheck(String fullemail);

    int phonecheck(String fullphone);

    MemberEntity findbyid(String id);

    void deleteinfo(String id);

    List<MemberInterface> infoout(String id);

    void updateinfo(String id, String email, String gender, String name, String nickname, String phone, int auth, String state, String address);

    List<MemberEntity> allmember();

    void updatestate(String id, String state);
}
