package mbc.second.HobbyTaster.service.Class;

import mbc.second.HobbyTaster.entity.Class.ClassEntity;
import mbc.second.HobbyTaster.repository.Class.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    //메인 검색
    /*
        Containing: 부분 일치 검색.
        IgnoreCase: 대소문자 무시.
        And, Or: 논리 조건 연결.
    */
    // 검색어만 입력
    @Override
    public List<ClassEntity> findByCnameAndCteach(String totSearch) {
        return classRepository.findByCnameContainingIgnoreCaseOrCteachContainingIgnoreCase(totSearch, totSearch);
    }
    // 날짜만 선택
    @Override
    public List<ClassEntity> findByCdate(LocalDate totDay) {
        return classRepository.findByCdate(totDay);
    }
    // 검색어, 날짜 다중 선택
    @Override
    public List<ClassEntity> findByCnameOrCteachAndCdate(String totSearch, LocalDate totDay) {
        return classRepository.findByCdateAndCnameContainingIgnoreCaseOrCteachContainingIgnoreCase(totDay, totSearch, totSearch);
    }
    // 소요시간 선택
    @Override
    public List<ClassEntity> findByCtime(String time) {
        return classRepository.findByCtimeContaining(time);
    }

    // 카테고리 1만 선택
    @Override
    public List<ClassEntity> findByCat1(String cat1) {
        return classRepository.findByCat1Containing(cat1);
    }

    // 카테고리 2 선택
    @Override
    public List<ClassEntity> findByCat2(String cat2) {
        return classRepository.findByCat2Containing(cat2);
    }


    // 카테고리별 리스트 출력 ( PRODEUCT )
    @Override
    public List<ClassEntity> category_product(String categories) {
        return findByCat1(categories);
    }

}

