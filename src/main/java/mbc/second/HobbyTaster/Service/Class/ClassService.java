package mbc.second.HobbyTaster.Service.Class;

import mbc.second.HobbyTaster.Entity.Class.ClassEntity;

import java.time.LocalDate;
import java.util.List;

public interface ClassService {

    void cinsert(ClassEntity centity);

    List<ClassEntity> out();

    ClassEntity detail(long cnum);

    void start(long cnum);

    void creturn(long cnum);

    void cfinish(long cnum);

    void cdelete(long cnum);

    void readcnt(long cnum);

    // 메인 페이지
    List<ClassInterface> categoryclass(String cat1, String cat2);

    // 메인 검색
    List<ClassEntity> findByCnameAndCteach(String totSearch);

    List<ClassEntity> findByCdate(LocalDate totDay);

    List<ClassEntity> findByCnameOrCteachAndCdate(String totSearch, LocalDate totDay);

    List<ClassEntity> findByCtime(String time);

    List<ClassEntity> findByCat1(String cat1);

    List<ClassEntity> findByCat2(String cat2);

    List<ClassEntity> category_product(String categories, int startRow, int endRow);

    int countByCategory(String categories);

    ClassEntity cfind(long cnum);

    void cupdate(ClassEntity centity);
}
