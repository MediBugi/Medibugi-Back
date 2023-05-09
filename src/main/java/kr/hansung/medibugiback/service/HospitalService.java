package kr.hansung.medibugiback.service;

import kr.hansung.medibugiback.domain.Hospital;
import org.json.simple.JSONArray;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface HospitalService {

    public void init(String jsonData);

    public JSONArray getHospitalList(int pageNum, int pageSize);

    public JSONArray getHospitalList(String depart);

    public JSONArray getHospitalList(int pageNum, int pageSize, String depart);

    public JSONArray getHospitalList(int pageNuj, int pageSize,String sido, String sggu,String depart);
}
