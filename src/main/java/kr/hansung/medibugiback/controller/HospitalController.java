package kr.hansung.medibugiback.controller;

import kr.hansung.medibugiback.domain.Hospital;
import kr.hansung.medibugiback.repository.HospitalRepository;
import kr.hansung.medibugiback.service.HospitalService;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
@CrossOrigin(value = "*",maxAge = 3000)
@RestController
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;


    @GetMapping("/getHospitalList")
    public List<Hospital> hospitalList(@RequestParam("depart")
                                  String depart){


        return hospitalService.getHospitalList(depart);
    }

    @GetMapping("/getHospitalListByLocation")
    public List<Hospital> hospitalListByLocation(@RequestParam
            ("sido")String sido, @RequestParam("sggu") String sggu, @RequestParam("depart")String depart){
        if(sido.equals("전체")&&sggu.equals("전체")&&depart.equals("전체")){
            return hospitalService.getHospitalList();
        }
        if(sido.equals("전체")&&sggu.equals("전체")&&!depart.equals("전체")){
            return hospitalService.getHospitalList(depart);
        }
        if(!sido.equals("전체")&&sggu.equals("전체")&&!depart.equals("전체")){
            return hospitalService.getHospitalListBySidoAndDepart(sido, depart);
        }
        if(!sido.equals("전체")&&!sggu.equals("전체")&&depart.equals("전체")){
            return hospitalService.getHospitalListBySidoAndSggu(sido, sggu);
        }
        if(!sido.equals("전체")&&sggu.equals("전체")&&depart.equals("전체")){
            return hospitalService.getHospitalListBySido(sido);
        }


        // ja = hospitalService.getHospitalList(sido, sggu,depart);
        return hospitalService.getHospitalList(sido, sggu, depart);
    }

    @GetMapping("/getAllList")
    public List<Hospital> getHospitalList(){
        return hospitalService.getHospitalList();
    }

}

