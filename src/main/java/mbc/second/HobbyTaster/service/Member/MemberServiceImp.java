package mbc.second.HobbyTaster.service.Member;

import mbc.second.HobbyTaster.dto.Member.MemberDTO;
import mbc.second.HobbyTaster.entity.MemberEntity;
import mbc.second.HobbyTaster.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImp implements MemberService {

    @Autowired
    MemberRepository mr;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void insertm(MemberDTO dto) {
        MemberEntity me=dto.entity(bCryptPasswordEncoder);
        mr.save(me);
    }

    @Override
    public int idcheck(String id) {
        return mr.idcheck(id);
    }

    @Override
    public int nicknamecheck(String nickname) {
        return mr.nicknamecheck(nickname);
    }

    @Override
    public int emailcheck(String fullemail) {
        return mr.emailcheck(fullemail);
    }

    @Override
    public int phonecheck(String fullphone) {
        return mr.phonecheck(fullphone);
    }

    @Override
    public MemberEntity findbyid(String id) {
        return mr.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found with id: " + id));
    }

}
