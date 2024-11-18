package mbc.second.HobbyTaster.service;

import mbc.second.HobbyTaster.entity.MemberEntity;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {
    void insertm(MemberEntity me);
}
