package mbc.second.HobbyTaster.entity.review;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
@SequenceGenerator(name = "comnum",sequenceName = "comnum_seq",allocationSize = 1,initialValue = 1)
@Table(name = "reviewcomment")
public class CommentEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "comnum")
    long comnum;

    @Column
    Long revnum;

    @Column
    String id;

    @Column
    String comcontents;

    @Column
    LocalDate comdate;

    @ManyToOne
    @JoinColumn(name = "revnum", referencedColumnName = "revnum", insertable = false, updatable = false)
    private ReviewEntity review;

    @Builder
    public CommentEntity(long comnum, Long revnum, String id, String comcontents, LocalDate comdate) {
        this.comnum = comnum;
        this.revnum = revnum;
        this.id = id;
        this.comcontents = comcontents;
        this.comdate = comdate;
    }
}
