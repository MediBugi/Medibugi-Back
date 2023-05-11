package kr.hansung.medibugiback.service;

import kr.hansung.medibugiback.domain.Hospital;
import org.json.simple.JSONArray;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface HospitalService {

    public void init(String jsonData);

    public JSONArray getHospitalList();

    public JSONArray getHospitalList(String depart);

    public JSONArray getHospitalListBySido(String sido);

    public JSONArray getHospitalListBySidoAndDepart(String sido,String depart);

    public JSONArray getHospitalListBySidoAndSggu(String sido,String sggu);

    public JSONArray getHospitalList(String sido, String sggu,String depart);
}
