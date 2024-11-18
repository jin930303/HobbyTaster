package mbc.second.HobbyTaster.service.Class;

import mbc.second.HobbyTaster.dto.Class.ClassDTO;
import mbc.second.HobbyTaster.entity.Class.ClassEntity;
import mbc.second.HobbyTaster.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    ClassRepository classRepository;


    @Override
    public void cinsert(ClassEntity centity) {
        classRepository.save(centity);
    }
}
