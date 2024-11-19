package mbc.second.HobbyTaster.service.Class;

import mbc.second.HobbyTaster.entity.Class.ClassEntity;

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
    List<ClassInterface> doye_out();
    List<ClassInterface> doll_out();
    List<ClassInterface> jewelle_out();
    List<ClassInterface> drawing_out();
    List<ClassInterface> picture_out();
    List<ClassInterface> music_out();
    List<ClassInterface> cookie_out();
    List<ClassInterface> cake_out();
    List<ClassInterface> bread_out();
    List<ClassInterface> wine_out();
    List<ClassInterface> beer_out();
    List<ClassInterface> tradition_out();
}
