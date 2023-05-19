package kr.hansung.medibugiback.service;

import kr.hansung.medibugiback.domain.Hospital;
import org.json.simple.JSONArray;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface HospitalService {

    public List<Hospital> getHospitalList();

    public List<Hospital> getHospitalList(String depart);

    public List<Hospital> getHospitalListBySido(String sido);

    public List<Hospital> getHospitalListBySidoAndDepart(String sido,String depart);

    public List<Hospital> getHospitalListBySidoAndSggu(String sido,String sggu);

    public List<Hospital> getHospitalList(String sido, String sggu,String depart);

}
