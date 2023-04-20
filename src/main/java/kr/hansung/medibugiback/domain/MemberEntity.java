package kr.hansung.medibugiback.domain;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="member")
public class MemberEntity {

    @Id
    String memberid; // 아이디
    String password; // 비밀번호
    String name; // 이름
    String telno; // 전화번호
    String address; // 주소
    String gender; // 성별
    Date birthday; // 생일
}
