package mbc.second.HobbyTaster.dto.Class;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mbc.second.HobbyTaster.entity.Class.ClassEntity;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClassDTO {
    long cnum;
    String cat1;
    String cat2;
    String cname;
    Integer cround;
    String cteach;
    LocalDate cdate;
    String ctime;
    String cminute;
    String address;
    String detailAddress;
    String extraAddress;
    String cadd;
    Integer cpl;
    String cstate;
    Integer ccnt =0;
    String cmimage1;
    String cdimage1;
    Integer cprice;
    String cdtext;

    public void mergeAddress() {
        this.cadd = String.join("", address, detailAddress, extraAddress);
    }

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
                .cprice(cprice)
                .build();
    }
}
