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
    public List<ClassInterface> doye_out() {
        return classRepository.doye_out();
    }

    @Override
    public List<ClassInterface> doll_out() {
        return classRepository.doll_out();
    }

    @Override
    public List<ClassInterface> jewelle_out() {
        return classRepository.jewelle_out();
    }

    @Override
    public List<ClassInterface> drawing_out() {
        return classRepository.drawing_out();
    }

    @Override
    public List<ClassInterface> picture_out() {
        return classRepository.picture_out();
    }

    @Override
    public List<ClassInterface> music_out() {
        return classRepository.music_out();
    }

    @Override
    public List<ClassInterface> cookie_out() {
        return classRepository.cookie_out();
    }

    @Override
    public List<ClassInterface> cake_out() {
        return classRepository.cake_out();
    }

    @Override
    public List<ClassInterface> bread_out() {
        return classRepository.bread_out();
    }

    @Override
    public List<ClassInterface> wine_out() {
        return classRepository.wine_out();
    }

    @Override
    public List<ClassInterface> beer_out() {
        return classRepository.beer_out();
    }

    @Override
    public List<ClassInterface> tradition_out() {
        return classRepository.tradition_out();
    }

}

