package kr.hansung.medibugiback.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long hoscnt; // 키 병원수
    String code; // 병원 코드
    String yadmNm; // 병원이름
    String clCdNm; // 병원 종류
    String sidoCdNm; // 시도명
    String sgguCdNm; // 시군구명
    String emdongNm; // 읍면구명
    String addr; // 주소
    String telno; // 전화번호
    String hospUrl; // 병원 홈페이지
    Long drTotCnt; // 의사 총 수
    String mediDepart;
    String sunRestDay;
    String restDay;
    String lunchNom;
    String lunchSat;
    String receipt_week;
    String receipt_Sat;
    String chSunStart;
    String chSunEnd;
    String chMonStart;
    String chMonEnd;
    String chTueStart;
    String chTueEnd;
    String chWenStart;
    String chWenEnd;
    String chThuStart;
    String chThuEnd;
    String chFriStart;
    String chFriEnd;
    String chSatStart;
    String chSatEnd;


}
