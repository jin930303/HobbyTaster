package mbc.second.HobbyTaster.entity.Reserve;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "reserve")
@SequenceGenerator(name = "res", sequenceName = "resnum_seq", allocationSize = 1)
public class ReserveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "res")
    @Column(name = "resnum")
    long reserveId;

    @Column(name = "cnum")
    long classId;

    @Column(name = "id")
    String userId;

    @Column(name = "resstate")
    String reserveState;

    @Builder
    public ReserveEntity(long reserveId, long classId, String userId, String reserveState) {
        this.reserveId = reserveId;
        this.classId = classId;
        this.userId = userId;
        this.reserveState = reserveState;
    }
}
