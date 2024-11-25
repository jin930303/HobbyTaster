package mbc.second.HobbyTaster.entity.review;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;



@Entity
@NoArgsConstructor
@SequenceGenerator(name = "revnum",sequenceName = "revnum_seq",initialValue = 1,allocationSize = 1)
@Table(name = "review")
@Getter
public class ReviewEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "revnum")
    long revnum;

    @Column
    Integer resnum;

    @Column
    Integer cnum;

    @Column
    String id;

    @Column
    String nickname;

    @Column
    String title;

    @Column
    String contents;

    @Column
    String image1;

    @Column
    String image2;

    @Column
    String image3;

    @Column
    LocalDate revdate;

    @Column
    Integer revstar;

    @Builder
    public ReviewEntity(long revnum, Integer resnum, Integer cnum, String id, String nickname, String title, String contents, String image1, String image2, String image3, LocalDate revdate, Integer revstar) {
        this.revnum = revnum;
        this.resnum = resnum;
        this.cnum = cnum;
        this.id = id;
        this.nickname = nickname;
        this.title = title;
        this.contents = contents;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.revdate = revdate;
        this.revstar = revstar;
    }
}
