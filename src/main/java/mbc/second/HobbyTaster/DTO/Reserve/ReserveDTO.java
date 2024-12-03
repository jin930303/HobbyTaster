package mbc.second.HobbyTaster.DTO.Reserve;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mbc.second.HobbyTaster.Entity.Reserve.ReserveEntity;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReserveDTO {
    long resnum;
    long cnum;
    String id;
    String resstate;

    public ReserveEntity entity() {
        return ReserveEntity.builder()
                .reserveId(resnum)
                .classId(cnum)
                .userId(id)
                .reserveState(resstate)
                .build();
    }
}
