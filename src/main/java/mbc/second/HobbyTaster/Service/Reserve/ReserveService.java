package mbc.second.HobbyTaster.Service.Reserve;

import mbc.second.HobbyTaster.Entity.Class.ClassEntity;
import mbc.second.HobbyTaster.Entity.Member.MemberEntity;
import mbc.second.HobbyTaster.Entity.Reserve.ReserveEntity;
import mbc.second.HobbyTaster.Service.Class.ClassInterface;

import java.util.List;

public interface ReserveService {

    void reserve_save(long cnum, String userId, String reserveTeach);

    List<ReserveEntity> reserve_out(String userId);

    String findNickname(String userId);

    List<ClassInterface> class_out(String nickname);
}
