package mbc.second.HobbyTaster.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mbc.second.HobbyTaster.entity.MemberEntity;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberDTO {
    String id;
    String pw;
    String nickname;
    String name;
    String gender;
    String email;
    String phone;
    String address;
    int auth;

    public MemberEntity entity() {
        return MemberEntity.builder()
                .id(id)
                .pw(pw)
                .nickname(nickname)
                .name(name)
                .gender(gender)
                .email(email)
                .phone(phone)
                .address(address)
                .auth(auth)
                .build();
    }
}
