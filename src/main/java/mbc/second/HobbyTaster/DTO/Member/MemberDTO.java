package mbc.second.HobbyTaster.DTO.Member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mbc.second.HobbyTaster.Entity.Member.MemberEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
    String state;

    public MemberEntity entity(BCryptPasswordEncoder encoder) {
        return MemberEntity.builder()
                .id(id)
                .pw(encoder.encode(pw))
                .nickname(nickname)
                .name(name)
                .gender(gender)
                .email(email)
                .phone(phone)
                .address(address)
                .auth(auth)
                .state(state)
                .build();
    }
}
