package mbc.second.HobbyTaster.dto.FAQ;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mbc.second.HobbyTaster.entity.FAQ.FAQEntity;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FAQDTO {
    long fnum;
    String ftitle;
    String fcontents;

    public FAQEntity entity() {
        return (new FAQEntity(fnum, ftitle, fcontents));
    }
}
