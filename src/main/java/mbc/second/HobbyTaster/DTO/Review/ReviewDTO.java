package mbc.second.HobbyTaster.DTO.Review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mbc.second.HobbyTaster.Entity.Review.ReviewEntity;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ReviewDTO {
    long revnum;
    Integer resnum;
    Integer cnum;
    String id;
    String nickname;
    String title;
    String contents;
    String rimage1;
    String rimage2;
    String rimage3;
    LocalDate revdate;
    Integer revstar;

    public ReviewEntity reviewEntity(){
        return ReviewEntity.builder()
                .revnum(revnum)
                .resnum(resnum)
                .cnum(cnum)
                .id(id)
                .nickname(nickname)
                .title(title)
                .contents(contents)
                .image1(rimage1)
                .image2(rimage2)
                .image3(rimage3)
                .revdate(revdate)
                .revstar(revstar)
                .build();
    }
}
