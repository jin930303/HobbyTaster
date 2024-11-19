package mbc.second.HobbyTaster.dto.Class;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mbc.second.HobbyTaster.entity.Class.ClassEntity;
import org.springframework.web.multipart.MultipartFile;

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
    String cmimage1;
    String cdimage1;

    String cdtext;

    public ClassEntity centity() {
        return ClassEntity.builder()
                .cnum(cnum)
                .cat1(cat1)
                .cat2(cat2)
                .cname(cname)
                .cround(cround)
                .cteach(cteach)
                .cdate(cdate)
                .ctime(ctime)
                .cminute(cminute)
                .cadd(cadd)
                .cpl(cpl)
                .cstate(cstate)
                .ccnt(ccnt)
                .cmimage(cmimage1)
                .cdimage(cdimage1)
                .cdtext(cdtext)
                .build();
    }
}
