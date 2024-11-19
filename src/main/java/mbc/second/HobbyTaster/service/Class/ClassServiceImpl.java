package mbc.second.HobbyTaster.service.Class;

import mbc.second.HobbyTaster.entity.Class.ClassEntity;
import mbc.second.HobbyTaster.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    ClassRepository classRepository;


    @Override
    public void cinsert(ClassEntity centity) {
        classRepository.save(centity);
    }

    @Override
    public List<ClassEntity> out() {
        return  classRepository.findAll();
    }

    @Override
    public ClassEntity detail(long cnum) {
        return classRepository.findById(cnum).orElse(null);
    }

    @Override
    public void start(long cnum) {
        classRepository.start(cnum);

    }

    @Override
    public void creturn(long cnum) {
        classRepository.creturn(cnum);
    }

    @Override
    public void cfinish(long cnum) {
        classRepository.cfinish(cnum);
    }

    @Override
    public void cdelete(long cnum) {
        classRepository.deleteById(cnum);
    }

    @Override
    public void readcnt(long cnum) {
        classRepository.readcnt(cnum);
    }
    
    //메인 페이지

    @Override
    public List<ClassInterface> categoryclass(String cat1, String cat2) {
        return classRepository.categoryclass(cat1, cat2);
    }

}

