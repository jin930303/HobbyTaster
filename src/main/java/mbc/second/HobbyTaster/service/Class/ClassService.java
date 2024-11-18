package mbc.second.HobbyTaster.service.Class;

import mbc.second.HobbyTaster.entity.Class.ClassEntity;

import java.util.List;

public interface ClassService {


    void cinsert(ClassEntity centity);

    List<ClassEntity> out();
}
