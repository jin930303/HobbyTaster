package mbc.second.HobbyTaster.Service.Reserve;

import mbc.second.HobbyTaster.DTO.Reserve.ReserveDTO;
import mbc.second.HobbyTaster.Entity.Class.ClassEntity;
import mbc.second.HobbyTaster.Entity.Reserve.ReserveEntity;
import mbc.second.HobbyTaster.Repository.Class.ClassRepository;
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
    public void reserve_save(long cnum, String userId, String reserveTeach) {
        ReserveDTO dto = new ReserveDTO();
        dto.setCnum(cnum);
        dto.setId(userId);
        dto.setResstate("진행중");
        dto.setNickname(reserveTeach);

        ReserveEntity entity = dto.entity();

       repository.save(entity);
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
}
