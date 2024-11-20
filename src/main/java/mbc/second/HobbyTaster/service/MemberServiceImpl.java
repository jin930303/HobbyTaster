
package mbc.second.HobbyTaster.service;

import mbc.second.HobbyTaster.dto.MemberDTO;
import mbc.second.HobbyTaster.entity.MemberEntity;
import mbc.second.HobbyTaster.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

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
    public MemberEntity findbyid(String id) {
        return mr.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found with id: " + id));
    }
}

