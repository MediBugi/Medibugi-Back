package kr.hansung.medibugiback.service;

import kr.hansung.medibugiback.domain.Hospital;
import kr.hansung.medibugiback.dto.HospitalDto;
import org.json.simple.JSONArray;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface HospitalService {

    public List<HospitalDto> getHospitalList();

    public List<HospitalDto> getHospitalList(String depart);

    public List<HospitalDto> getHospitalListBySido(String sido);

    public List<HospitalDto> getHospitalListBySidoAndDepart(String sido,String depart);

    public List<HospitalDto> getHospitalListBySidoAndSggu(String sido,String sggu);

    public List<HospitalDto> getHospitalList(String sido, String sggu,String depart);

    public List<HospitalDto> getHospitalListAndName(String depart, String name);

    public List<HospitalDto> getHospitalListBySidoAndName(String sido, String name);

    public List<HospitalDto> getHospitalListBySidoAndDepartAndName(String sido,String depart, String name);

    public List<HospitalDto> getHospitalListBySidoAndSgguAndName(String sido,String sggu,String name);

    public List<HospitalDto> getHospitalListAndName(String sido, String sggu,String depart, String name);



    public List<Hospital> addtimeinfo();

}
