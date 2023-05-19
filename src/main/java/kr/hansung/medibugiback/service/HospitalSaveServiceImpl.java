package kr.hansung.medibugiback.service;

import kr.hansung.medibugiback.domain.Hospital;
import kr.hansung.medibugiback.repository.HospitalRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class HospitalSaveServiceImpl implements HospitalService {

    @Autowired
    HospitalRepository hosRepo;

    @Override
    public List<Hospital> getHospitalList() {

       return hosRepo.findMediDepartByCode();
    }
    @Override
    public List<Hospital> getHospitalList(String depart){

        List<Hospital> hospitalPage = hosRepo.findByMediDepart(depart);


        return hospitalPage;
    }

    @Override
    public List<Hospital> getHospitalListBySido(String sido) {

        List<Hospital> hospitalPage = hosRepo.findHospitalsByAddr(sido);

        return hospitalPage;
    }

    @Override
    public List<Hospital> getHospitalListBySidoAndDepart(String sido, String depart) {



        List<Hospital> hospitalPage = hosRepo.findByAddrStartingWithAndMediDepart(sido,depart);



        return hospitalPage;
    }

    @Override
    public List<Hospital> getHospitalListBySidoAndSggu(String sido, String sggu) {



        List<Hospital> hospitalPage = hosRepo.findByAddrStartingWithAndAddrContaining(sido,sggu);



        return hospitalPage;
    }

    @Override
    public List<Hospital> getHospitalList(String sido, String sggu,String depart) {

        return hosRepo.findHospitalsByAddrAndMediDepart(sido, sggu, depart);
    }




}
