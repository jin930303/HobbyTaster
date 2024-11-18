package mbc.second.HobbyTaster.repository;

import mbc.second.HobbyTaster.dto.Class.ClassDTO;
import mbc.second.HobbyTaster.entity.Class.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<ClassEntity,Long> {



}
