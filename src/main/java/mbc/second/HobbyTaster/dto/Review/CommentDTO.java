package mbc.second.HobbyTaster.dto.Review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mbc.second.HobbyTaster.entity.review.CommentEntity;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentDTO {
    long comnum;
    Integer revnum;
    String id;
    String comcontents;
    LocalDate comdate;

    public CommentEntity commentEntity(){
        return CommentEntity.builder()
                .comnum(comnum)
                .id(id)
                .comcontents(comcontents)
                .comdate(comdate)
                .build();
    }
}
