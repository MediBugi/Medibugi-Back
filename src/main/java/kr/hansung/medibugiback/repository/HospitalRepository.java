package kr.hansung.medibugiback.repository;

import kr.hansung.medibugiback.domain.Hospital;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
@Repository
public interface HospitalRepository extends JpaRepository<Hospital,Long> {

    @Query(value = "SELECT h.code AS hospital_code, " +
            "GROUP_CONCAT(DISTINCT h.mediDepart SEPARATOR ', ') AS mediDepart, " +
            "h.addr, h.chFriEnd, h.chFriStart, h.chMonEnd, h.chMonStart, h.chSatEnd, h.chSatStart, " +
            "h.chSunEnd, h.chSunStart, h.chThuEnd, h.chThuStart, h.chTueEnd, h.chTueStart, " +
            "h.chWenEnd, h.chWenStart, h.clCdNm, h.code, h.drTotCnt, h.emdongNm, " +
            "h.hospUrl, h.lunchNom, h.lunchSat, h.receipt_Sat, h.receipt_Week, " +
            "h.restDay, h.sgguCdNm, h.sidoCdNm, h.sunRestDay, h.telno, h.x, h.y, h.yadmNm, h.hoscnt " +
            "FROM Hospital h " +
            "WHERE h.hoscnt = :hoscnt "+
            "GROUP BY h.code ", nativeQuery = true)
    Hospital findByHoscnt(Long hoscnt);

    @Query(value = "SELECT h.code AS hospital_code, " +
            "GROUP_CONCAT(DISTINCT h.mediDepart SEPARATOR ', ') AS mediDepart, " +
            "h.addr, h.chFriEnd, h.chFriStart, h.chMonEnd, h.chMonStart, h.chSatEnd, h.chSatStart, " +
            "h.chSunEnd, h.chSunStart, h.chThuEnd, h.chThuStart, h.chTueEnd, h.chTueStart, " +
            "h.chWenEnd, h.chWenStart, h.clCdNm, h.code, h.drTotCnt, h.emdongNm, " +
            "h.hospUrl, h.lunchNom, h.lunchSat, h.receipt_Sat, h.receipt_Week, " +
            "h.restDay, h.sgguCdNm, h.sidoCdNm, h.sunRestDay, h.telno, h.x, h.y, h.yadmNm, h.hoscnt " +
            "FROM Hospital h " +
            "WHERE h.yadmNm = :yadmNm "+
            "GROUP BY h.code ", nativeQuery = true)
    Hospital findByYadmNm(String yadmNm);
    @Query(value = "SELECT h.code AS hospital_code, " +
            "GROUP_CONCAT(DISTINCT h.mediDepart SEPARATOR ', ') AS mediDepart, " +
            "h.addr, h.chFriEnd, h.chFriStart, h.chMonEnd, h.chMonStart, h.chSatEnd, h.chSatStart, " +
            "h.chSunEnd, h.chSunStart, h.chThuEnd, h.chThuStart, h.chTueEnd, h.chTueStart, " +
            "h.chWenEnd, h.chWenStart, h.clCdNm, h.code, h.drTotCnt, h.emdongNm, " +
            "h.hospUrl, h.lunchNom, h.lunchSat, h.receipt_Sat, h.receipt_Week, " +
            "h.restDay, h.sgguCdNm, h.sidoCdNm, h.sunRestDay, h.telno, h.x, h.y, h.yadmNm, h.hoscnt " +
            "FROM Hospital h " +
            "GROUP BY h.code " +
            "HAVING GROUP_CONCAT(DISTINCT h.mediDepart SEPARATOR ', ') LIKE %:depart%", nativeQuery = true)
    List<Hospital> findByMediDepart(String depart);

    @Query(value = "SELECT h.code AS hospital_code, " +
            "GROUP_CONCAT(DISTINCT h.mediDepart SEPARATOR ', ') AS mediDepart, " +
            "h.addr, h.chFriEnd, h.chFriStart, h.chMonEnd, h.chMonStart, h.chSatEnd, h.chSatStart, " +
            "h.chSunEnd, h.chSunStart, h.chThuEnd, h.chThuStart, h.chTueEnd, h.chTueStart, " +
            "h.chWenEnd, h.chWenStart, h.clCdNm, h.code, h.drTotCnt, h.emdongNm, " +
            "h.hospUrl, h.lunchNom, h.lunchSat, h.receipt_Sat, h.receipt_Week, " +
            "h.restDay, h.sgguCdNm, h.sidoCdNm, h.sunRestDay, h.telno, h.x, h.y, h.yadmNm, h.hoscnt " +
            "FROM Hospital h " +
            "WHERE h.addr like %:sido% " +
            "GROUP BY h.code ", nativeQuery = true)
    List<Hospital> findHospitalsByAddr(String sido);

    @Query(value = "select h.yadmNm," +
            "GROUP_CONCAT(distinct h.mediDepart SEPARATOR ', ') AS mediDepart," +
            "            h.addr, h.chFriEnd, h.chFriStart, h.chMonEnd, h.chMonStart, h.chSatEnd, h.chSatStart," +
            "            h.chSunEnd, h.hoscnt ,h.chSunStart, h.chThuEnd, h.chThuStart, h.chTueEnd, h.chTueStart," +
            "            h.chWenEnd, h.chWenStart, h.clCdNm,  h.drTotCnt, h.emdongNm," +
            "            h.hospUrl, h.lunchNom, h.lunchSat, h.receipt_Sat, h.receipt_Week," +
            "            h.restDay, h.sgguCdNm, h.sidoCdNm, h.sunRestDay, h.telno, h.x, h.y, h.code"+
    "            FROM Hospital h " +
            "            GROUP BY h.yadmNm", nativeQuery = true)
    List<Hospital> findMediDepartByYadmNm(); // 모두 전체 골랐을때 쿼리
    @Query(value = "SELECT h.code AS hospital_code, " +
            "GROUP_CONCAT(DISTINCT h.mediDepart SEPARATOR ', ') AS mediDepart, " +
            "h.addr, h.chFriEnd, h.chFriStart, h.chMonEnd, h.chMonStart, h.chSatEnd, h.chSatStart, " +
            "h.chSunEnd, h.chSunStart, h.chThuEnd, h.chThuStart, h.chTueEnd, h.chTueStart, " +
            "h.chWenEnd, h.chWenStart, h.clCdNm, h.code, h.drTotCnt, h.emdongNm, " +
            "h.hospUrl, h.lunchNom, h.lunchSat, h.receipt_Sat, h.receipt_Week, " +
            "h.restDay, h.sgguCdNm, h.sidoCdNm, h.sunRestDay, h.telno, h.x, h.y, h.yadmNm, h.hoscnt " +
            "FROM Hospital h " +
            "WHERE h.addr like %:sido% " +
            "GROUP BY h.code " +
            "HAVING GROUP_CONCAT(DISTINCT h.mediDepart SEPARATOR ', ') LIKE %:depart%", nativeQuery = true)
    List<Hospital> findByAddrStartingWithAndMediDepart(String sido, String depart);
    @Query(value = "SELECT h.code AS hospital_code, " +
            "GROUP_CONCAT(DISTINCT h.mediDepart SEPARATOR ', ') AS mediDepart, " +
            "h.addr, h.chFriEnd, h.chFriStart, h.chMonEnd, h.chMonStart, h.chSatEnd, h.chSatStart, " +
            "h.chSunEnd, h.chSunStart, h.chThuEnd, h.chThuStart, h.chTueEnd, h.chTueStart, " +
            "h.chWenEnd, h.chWenStart, h.clCdNm, h.code, h.drTotCnt, h.emdongNm, " +
            "h.hospUrl, h.lunchNom, h.lunchSat, h.receipt_Sat, h.receipt_Week, " +
            "h.restDay, h.sgguCdNm, h.sidoCdNm, h.sunRestDay, h.telno, h.x, h.y, h.yadmNm, h.hoscnt " +
            "FROM Hospital h " +
            "WHERE h.addr like %:sido% AND h.addr like %:sggu% " +
            "GROUP BY h.code ", nativeQuery = true)
    List<Hospital> findByAddrStartingWithAndAddrContaining(String sido,String sggu);

    @Query(value = "SELECT h.code AS hospital_code, " +
            "GROUP_CONCAT(DISTINCT h.mediDepart SEPARATOR ', ') AS mediDepart, " +
            "h.addr, h.chFriEnd, h.chFriStart, h.chMonEnd, h.chMonStart, h.chSatEnd, h.chSatStart, " +
            "h.chSunEnd, h.chSunStart, h.chThuEnd, h.chThuStart, h.chTueEnd, h.chTueStart, " +
            "h.chWenEnd, h.chWenStart, h.clCdNm, h.code, h.drTotCnt, h.emdongNm, " +
            "h.hospUrl, h.lunchNom, h.lunchSat, h.receipt_Sat, h.receipt_Week, " +
            "h.restDay, h.sgguCdNm, h.sidoCdNm, h.sunRestDay, h.telno, h.x, h.y, h.yadmNm, h.hoscnt " +
            "FROM Hospital h " +
            "WHERE h.addr like %:sido% AND h.addr like %:sggu% " +
            "GROUP BY h.code " +
            "HAVING GROUP_CONCAT(DISTINCT h.mediDepart SEPARATOR ', ') LIKE %:mediDepart%", nativeQuery = true)
    List<Hospital> findHospitalsByAddrAndMediDepart(String sido, String sggu, String mediDepart); // 모든 선택지를 다 골랐을때 쿼리

}
