package mbc.second.HobbyTaster.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "member")
public class MemberEntity {
    @Id
    @Column
    String id;

    @Column
    String pw;

    @Column
    String nickname;

    @Column
    String name;

    @Column
    String gender;

    @Column
    String email;

    @Column
    String phone;

    @Column
    String address;

    @Column
    int auth;

    @Column
    String state;

    @Builder
    public MemberEntity(String id, String pw, String nickname, String name, String gender, String email, String phone, String address, int auth, String state) {
        this.id = id;
        this.pw = pw;
        this.nickname = nickname;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.auth = auth;
        this.state = state;
    }
}
