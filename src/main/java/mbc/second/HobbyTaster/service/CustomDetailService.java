package mbc.second.HobbyTaster.service;

import mbc.second.HobbyTaster.entity.MemberEntity;
import mbc.second.HobbyTaster.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class CustomDetailService implements UserDetailsService {
    //회원정보를 담은 인터페이스를 상속받음

    private MemberRepository memberRepository;

    @Autowired
    public CustomDetailService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String id) {//회원정보를 담는

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        //GrantedAuthority: 현재 사용자의 권한 admin or user를 role로 표시(role=역할)

        MemberEntity memberEntity = memberRepository.findOneById(id);
        //findOneById의 정보를 가져와서 user에 담음

        if (memberEntity != null) {
            grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
            // USER 라는 역할을 넣어준다. SimpleGrantedAuthority는 GrantedAuthority를 상속받은 클래스,
            // role를 USER로 설정(역할을 user로 설정)
            return new User(memberEntity.getId(), memberEntity.getPw(), grantedAuthorities);
        }
        else {
            throw new UsernameNotFoundException("can not find User : " + id);
        }
    }

}
