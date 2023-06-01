package kr.hansung.medibugiback.controller;

import kr.hansung.medibugiback.domain.Hospital;
import kr.hansung.medibugiback.dto.HospitalDto;
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
    public List<HospitalDto> hospitalList(@RequestParam("depart")
                                  String depart){


        return hospitalService.getHospitalList(depart);
    }

    @GetMapping("/getHospitalListByLocation")
    public List<HospitalDto> hospitalListByLocation(@RequestParam
            ("sido")String sido, @RequestParam("sggu") String sggu, @RequestParam("depart")String depart, @RequestParam("name") String name){
        if(sido.equals("전체")&&sggu.equals("전체")&&depart.equals("전체")&&name.equals("전체")){
            return hospitalService.getHospitalList();
        }
        if(sido.equals("전체")&&sggu.equals("전체")&&!depart.equals("전체")){
            if(name.equals("전체")){
                return hospitalService.getHospitalList(depart);
            }
            else{
                return hospitalService.getHospitalListAndName(depart,name);
            }

        }
        if(!sido.equals("전체")&&sggu.equals("전체")&&!depart.equals("전체")){
            if(name.equals("전체")){
                return hospitalService.getHospitalListBySidoAndDepart(sido, depart);
            }
            else{
                return hospitalService.getHospitalListBySidoAndDepartAndName(sido, depart, name);
            }
        }
        if(!sido.equals("전체")&&!sggu.equals("전체")&&depart.equals("전체")){
            if(name.equals("전체")){
                return hospitalService.getHospitalListBySidoAndSggu(sido, sggu);
            }
            else{
                return hospitalService.getHospitalListBySidoAndSgguAndName(sido, sggu, name);
            }
        }
        if(!sido.equals("전체")&&sggu.equals("전체")&&depart.equals("전체")){
            if(name.equals("전체")){
                return hospitalService.getHospitalListBySido(sido);
            }
            else{
                return hospitalService.getHospitalListBySidoAndName(sido, name);
            }
        }


        // ja = hospitalService.getHospitalList(sido, sggu,depart);
        if(name.equals("전체")){
            return hospitalService.getHospitalList(sido, sggu, depart);        }
        else{
            return hospitalService.getHospitalListAndName(sido, sggu, depart, name);
        }
    }

    @GetMapping("/getAllList")
    public List<HospitalDto> getHospitalList(@RequestParam("sido") String sido){
        return hospitalService.getHospitalListBySido(sido);
    }

    @GetMapping("/timetest")
    public List<Hospital> timetest(){
        return hospitalService.addtimeinfo();
    }

}

