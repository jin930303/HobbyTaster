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
    long classId;
    String userId;
    String reserveState;

    public ReserveEntity entity() {
        return (new ReserveEntity(resnum, classId, userId, reserveState));
    }
}
