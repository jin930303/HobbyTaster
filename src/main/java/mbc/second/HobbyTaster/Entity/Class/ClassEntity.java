package mbc.second.HobbyTaster.Entity.Class;

import jakarta.persistence.*;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
@Table(name = "cclass")
@SequenceGenerator(name = "cnum",sequenceName = "cnum_seq",allocationSize =1,initialValue = 10000)
public class ClassEntity {
    @Id @Column @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "cnum") long cnum;
    @Column String cat1;
    @Column String cat2;
    @Column String cname;
    @Column Integer cround;
    @Column String cteach;
    @Column LocalDate cdate;
    @Column String ctime;
    @Column String cminute;
    @Column String cadd;
    @Column Integer cpl;
    @Column String cstate;
    @Column(nullable = false) Integer ccnt = 0;
    @Column String cmimage;
    @Column String cdimage;
    @Column String cdtext;
    @Column Integer cprice;

    @Builder
    public ClassEntity(long cnum, String cat1, String cat2, String cname, Integer cround, String cteach, LocalDate cdate, String ctime, String cminute, String cadd, Integer cpl, String cstate, Integer ccnt, String cmimage, String cdimage, String cdtext, Integer cprice) {
        this.cnum = cnum;
        this.cat1 = cat1;
        this.cat2 = cat2;
        this.cname = cname;
        this.cround = cround;
        this.cteach = cteach;
        this.cdate = cdate;
        this.ctime = ctime;
        this.cminute = cminute;
        this.cadd = cadd;
        this.cpl = cpl;
        this.cstate = cstate;
        this.ccnt = ccnt;
        this.cmimage = cmimage;
        this.cdimage = cdimage;
        this.cdtext = cdtext;
        this.cprice = cprice;
    }
}