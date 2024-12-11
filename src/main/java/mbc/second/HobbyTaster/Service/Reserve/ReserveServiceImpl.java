package mbc.second.HobbyTaster.Service.Reserve;

import mbc.second.HobbyTaster.DTO.Reserve.ReserveDTO;
import mbc.second.HobbyTaster.Entity.Member.MemberEntity;
import mbc.second.HobbyTaster.Entity.Reserve.ReserveEntity;
import mbc.second.HobbyTaster.Repository.Reserve.ReserveRepository;
import mbc.second.HobbyTaster.Service.Class.ClassInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReserveServiceImpl implements ReserveService {
    @Autowired
    ReserveRepository repository;

    @Override
    public String reserve_save(long cnum, String userId, String reserveTeach) {
        // cpl(모집인원) 찾기
        Integer cpl = repository.findCplByCnum(cnum);

        Integer countreserve = repository.countByCnum(cnum);

        if(countreserve >= cpl) {
            return "예약인원이 가득 찼습니다.";
        }
        else {
            ReserveDTO dto = new ReserveDTO();
            dto.setCnum(cnum);
            dto.setId(userId);
            dto.setResstate("진행중");
            dto.setNickname(reserveTeach);

            ReserveEntity entity = dto.entity();
            repository.save(entity);

            return "예약이 완료되었습니다.";
        }
    }

    @Override
    public List<ReserveEntity> reserve_out(String userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public String findNickname(String userId) {
        return repository.nicknamefind(userId);
    }

    @Override
    public List<ClassInterface> class_out(String nickname) {
        return repository.findState(nickname);
    }

    @Override
    public List<MemberEntity> finByUser(String nickname) {
        return repository.finduserId(nickname);
    }
}
