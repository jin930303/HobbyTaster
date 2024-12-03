package mbc.second.HobbyTaster.Entity.FAQ;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "FAQ")
@SequenceGenerator(name = "faq1", sequenceName = "fnum_seq", allocationSize = 1)
public class FAQEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "faq1")
    @Column
    long fnum;

    @Column
    String ftitle;

    @Column
    String fcontents;
}
