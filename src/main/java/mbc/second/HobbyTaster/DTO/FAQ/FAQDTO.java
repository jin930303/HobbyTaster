package mbc.second.HobbyTaster.DTO.FAQ;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mbc.second.HobbyTaster.Entity.FAQ.FAQEntity;

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
