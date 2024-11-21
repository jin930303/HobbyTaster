package mbc.second.HobbyTaster.service.Member;

import mbc.second.HobbyTaster.dto.Member.MemberDTO;
import mbc.second.HobbyTaster.entity.MemberEntity;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {

    void insertm(MemberDTO dto);

    int idcheck(String id);

    int nicknamecheck(String nickname);

    int emailcheck(String fullemail);

    int phonecheck(String fullphone);

    MemberEntity findbyid(String id);
}
