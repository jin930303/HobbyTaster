package mbc.second.HobbyTaster.entity.Class;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
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


}
