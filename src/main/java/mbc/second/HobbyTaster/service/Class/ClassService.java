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
}
