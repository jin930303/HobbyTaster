package mbc.second.HobbyTaster.entity.Class;

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
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "cnum")
    long cnum;

    @Column
    String cat1;

    @Column
    String cat2;

    @Column
    String cname;

    @Column
    int cround;

    @Column
    String cteach;

    @Column
    LocalDate cdate;

    @Column
    String ctime;

    @Column
    String cminute;

    @Column

    String cadd;

    @Column
    int cpl;

    @Column
    String cstate;

    @Column
    int ccnt;

    @Column
    String cmimage;

    @Column
    String cdimage;

    @Column
    String cdtext;

    @Column
    long cprice;

    @Builder
    public ClassEntity(long cnum, String cat1, String cat2, String cname, int cround, String cteach, LocalDate cdate, String ctime, String cminute, String cadd, int cpl, String cstate, int ccnt, String cmimage, String cdimage, String cdtext, int cprice) {
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