package mbc.second.HobbyTaster.dto.Class;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mbc.second.HobbyTaster.entity.Class.ClassEntity;

import java.sql.Clob;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClassDTO {
    long cnum;
    String cat1;
    String cat2;
    String cname;
    int cround;
    String cteach;
    LocalDate cdate;
    String ctime;
    String cminute;
    String cadd;
    int cpl;
    String cstate;
    int ccnt;
    String cmimage;
    String cdimage;
    String cdtext;

    public ClassEntity centity() {
        return (new ClassEntity(cnum,cat1,cat2,cname,cround,cteach,cdate,ctime,cminute,cadd,cpl,cstate,ccnt,cmimage,cdimage,cdtext));
    }
}
