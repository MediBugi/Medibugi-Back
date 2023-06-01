package kr.hansung.medibugiback.dto;

import kr.hansung.medibugiback.domain.Hospital;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HospitalDto {
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
    String x;
    String y;
    float rating; // 평점

    public HospitalDto (Hospital hospital){
        this.hoscnt = hospital.getHoscnt();
        this.code = hospital.getCode();
        this.yadmNm = hospital.getYadmNm();
        this.clCdNm = hospital.getClCdNm();
        this.sidoCdNm = hospital.getSidoCdNm();
        this.sgguCdNm = hospital.getSgguCdNm();
        this.emdongNm = hospital.getEmdongNm();
        this.addr = hospital.getAddr();
        this.telno = hospital.getTelno();
        this.hospUrl = hospital.getHospUrl();
        this.drTotCnt = hospital.getDrTotCnt();
        this.mediDepart = hospital.getMediDepart();
        this.sunRestDay = hospital.getSunRestDay();
        this.restDay = hospital.getRestDay();
        this.lunchNom = hospital.getLunchNom();
        this.lunchSat = hospital.getLunchSat();
        this.receipt_week = hospital.getReceipt_week();
        this.receipt_Sat = hospital.getReceipt_Sat();
        this.chSunStart = hospital.getChSunStart();
        this.chSunEnd = hospital.getChSunEnd();
        this.chMonStart = hospital.getChMonStart();
        this.chMonEnd = hospital.getChMonEnd();
        this.chTueStart = hospital.getChTueStart();
        this.chTueEnd = hospital.getChTueEnd();
        this.chWenStart = hospital.getChWenStart();
        this.chWenEnd = hospital.getChWenEnd();
        this.chThuStart = hospital.getChThuStart();
        this.chThuEnd = hospital.getChThuEnd();
        this.chFriStart = hospital.getChFriStart();
        this.chFriEnd = hospital.getChFriEnd();
        this.chSatStart = hospital.getChSatStart();
        this.chSatEnd = hospital.getChSatEnd();
        this.x = hospital.getX();
        this.y= hospital.getY();
    }

}
