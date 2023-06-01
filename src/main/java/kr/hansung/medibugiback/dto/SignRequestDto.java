package kr.hansung.medibugiback.dto;

import lombok.*;


@Getter
@Setter
public class SignRequestDto {
    private String memberid; // 아이디
    private String password; // 비밀번호
}
