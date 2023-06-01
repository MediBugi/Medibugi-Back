package kr.hansung.medibugiback.dto;

import kr.hansung.medibugiback.domain.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignResponseDto {
    private String memberid; // 아이디
    private String name; // 이름
    private String telno; // 전화번호
    private String address; // 주소
    private String gender; // 성별
    private Date birthday; // 생일

    public SignResponseDto(MemberEntity memberEntity) {
        this.memberid = memberEntity.getMemberid();
        this.name = memberEntity.getName();
        this.telno = memberEntity.getTelno();
        this.address = memberEntity.getAddress();
        this.gender = memberEntity.getGender();
        this.birthday = memberEntity.getBirthday();
    }
}
