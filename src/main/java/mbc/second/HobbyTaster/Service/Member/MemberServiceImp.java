package mbc.second.HobbyTaster.Service.Member;

import mbc.second.HobbyTaster.DTO.Member.MemberDTO;
import mbc.second.HobbyTaster.Entity.Member.MemberEntity;
import mbc.second.HobbyTaster.Repository.Member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return mr.findById(id).orElse(null);
    }

    @Override
    public void deleteinfo(String id) {
        mr.deleteById(id);
    }

    @Override
    public List<MemberInterface> infoout(String id) {
        return mr.myinfo(id);
    }

    @Override
    public void updateinfo(String id, String email, String gender, String name, String nickname, String phone, int auth, String state, String address) {
        mr.updateinfo(id, email, gender, name, nickname, phone, auth,state, address);
    }

    @Override
    public List<MemberEntity> allmember() {
        return mr.findAll();
    }

    @Override
    public void updatestate(String id, String state) {
        mr.updatestate(id, state);
    }

    @Override
    public String findidemail(String fullemail) {
        return mr.findidemail(fullemail);
    }

    @Override
    public String findidphone(String fullphone) {
        return mr.findidphone(fullphone);
    }

    @Override
    public int pwcheck(String id, String fullemail, String fullphone) {
        return mr.pwcheck(id,fullemail, fullphone);
    }

    @Override
    public void pwupdate(String id, String pw) {
        String pwbcryt=bCryptPasswordEncoder.encode(pw);
        mr.pwupdate(id, pwbcryt);
    }

}
