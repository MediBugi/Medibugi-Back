package kr.hansung.medibugiback.service;

import kr.hansung.medibugiback.domain.Hospital;
import org.json.simple.JSONArray;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface HospitalService {

    public void init(String jsonData);

    public JSONArray getHospitalList();

    public JSONArray getHospitalList(String depart);

}
