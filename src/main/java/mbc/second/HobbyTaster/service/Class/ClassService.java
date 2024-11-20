package mbc.second.HobbyTaster.service.Class;

import mbc.second.HobbyTaster.entity.Class.ClassEntity;
import mbc.second.HobbyTaster.entity.MemberEntity;

import java.util.List;
import java.util.Optional;

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



}
