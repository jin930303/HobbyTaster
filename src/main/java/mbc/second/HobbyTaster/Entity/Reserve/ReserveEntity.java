package mbc.second.HobbyTaster.Entity.Reserve;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "reserve")
@SequenceGenerator(name = "res", sequenceName = "resnum_seq", allocationSize = 1)
public class ReserveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "res")
    @Column(name = "resnum")
    long reserveId;

    @Column(name = "classid")
    long classId;

    @Column(name = "userid")
    String userId;

    @Column(name = "reservestate")
    String reserveState;
}
