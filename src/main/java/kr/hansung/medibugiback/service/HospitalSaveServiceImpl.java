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

        List<Hospital> resultList = new ArrayList<>();
        if(depart.equals("내과")){
            for (Hospital hospital : hospitalPage) {
                if ((hospital.getMediDepart().contains("한방내과")) || (hospital.getMediDepart().contains("구강내과"))) {
                    continue;
                }
                resultList.add(hospital);
            }
            return resultList;
        }
        else if(depart.equals("외과")){
            for(Hospital hospital : hospitalPage){
                if((hospital.getMediDepart().contains("정형외과"))||(hospital.getMediDepart().contains("신경외과"))||(hospital.getMediDepart().contains("구강악안면외과"))||(hospital.getMediDepart().contains("성형외과"))||(hospital.getMediDepart().contains("심장혈관흉부외과"))||(hospital.getMediDepart().contains("흉부외과"))){
                    continue;
                }
                resultList.add(hospital);
            }
            return resultList;
        }
        else if(depart.equals("피부과")){
            for(Hospital hospital : hospitalPage){
                if((hospital.getMediDepart().equals("한방안·이비인후·피부과"))||(hospital.getMediDepart().contains("한방안이비인후피부과"))){
                    continue;
                }
                resultList.add(hospital);
            }
            return resultList;
        }
        else if(depart.equals("치과")){
            for(Hospital hospital : hospitalPage){
                if((hospital.getMediDepart().contains("치과보철과"))||(hospital.getMediDepart().contains("치과보존과"))||(hospital.getMediDepart().contains("소아치과"))||(hospital.getMediDepart().contains("치과교정과"))||(hospital.getMediDepart().contains("예방치과"))){
                    continue;
                }
                resultList.add(hospital);
            }
            return resultList;
        }

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

        List<Hospital> resultList = new ArrayList<>();
        if(depart.equals("내과")){
            for (Hospital hospital : hospitalPage) {
                if ((hospital.getMediDepart().contains("한방내과")) || (hospital.getMediDepart().contains("구강내과"))) {
                    continue;
                }
                resultList.add(hospital);
            }
            return resultList;
        }
        else if(depart.equals("외과")){
            for(Hospital hospital : hospitalPage){
                if((hospital.getMediDepart().contains("정형외과"))||(hospital.getMediDepart().contains("신경외과"))||(hospital.getMediDepart().contains("구강악안면외과"))||(hospital.getMediDepart().contains("성형외과"))||(hospital.getMediDepart().contains("심장혈관흉부외과"))||(hospital.getMediDepart().contains("흉부외과"))){
                    continue;
                }
                resultList.add(hospital);
            }
            return resultList;
        }
        else if(depart.equals("피부과")){
            for(Hospital hospital : hospitalPage){
                if((hospital.getMediDepart().equals("한방안·이비인후·피부과"))||(hospital.getMediDepart().contains("한방안이비인후피부과"))){
                    continue;
                }
                resultList.add(hospital);
            }
            return resultList;
        }
        else if(depart.equals("치과")){
            for(Hospital hospital : hospitalPage){
                if((hospital.getMediDepart().contains("치과보철과"))||(hospital.getMediDepart().contains("치과보존과"))||(hospital.getMediDepart().contains("소아치과"))||(hospital.getMediDepart().contains("치과교정과"))||(hospital.getMediDepart().contains("예방치과"))){
                    continue;
                }
                resultList.add(hospital);
            }
            return resultList;
        }

        return hospitalPage;
    }

    @Override
    public List<Hospital> getHospitalListBySidoAndSggu(String sido, String sggu) {



        List<Hospital> hospitalPage = hosRepo.findByAddrStartingWithAndAddrContaining(sido,sggu);



        return hospitalPage;
    }

    @Override
    public List<Hospital> getHospitalList(String sido, String sggu,String depart) {

        List<Hospital> hospitalPage = hosRepo.findHospitalsByAddrAndMediDepart(sido, sggu, depart);
        List<Hospital> resultList = new ArrayList<>();
        if(depart.equals("내과")){
            for (Hospital hospital : hospitalPage) {
                if ((hospital.getMediDepart().contains("한방내과")) || (hospital.getMediDepart().contains("구강내과"))) {
                    continue;
                }
                resultList.add(hospital);
            }
            return resultList;
        }
        else if(depart.equals("외과")){
            for(Hospital hospital : hospitalPage){
                if((hospital.getMediDepart().contains("정형외과"))||(hospital.getMediDepart().contains("신경외과"))||(hospital.getMediDepart().contains("구강악안면외과"))||(hospital.getMediDepart().contains("성형외과"))||(hospital.getMediDepart().contains("심장혈관흉부외과"))||(hospital.getMediDepart().contains("흉부외과"))){
                    continue;
                }
                resultList.add(hospital);
            }
            return resultList;
        }
        else if(depart.equals("피부과")){
            for(Hospital hospital : hospitalPage){
                if((hospital.getMediDepart().equals("한방안·이비인후·피부과"))||(hospital.getMediDepart().contains("한방안이비인후피부과"))){
                    continue;
                }
                resultList.add(hospital);
            }
            return resultList;
        }
        else if(depart.equals("치과")){
            for(Hospital hospital : hospitalPage){
                if((hospital.getMediDepart().contains("치과보철과"))||(hospital.getMediDepart().contains("치과보존과"))||(hospital.getMediDepart().contains("소아치과"))||(hospital.getMediDepart().contains("치과교정과"))||(hospital.getMediDepart().contains("예방치과"))){
                    continue;
                }
                resultList.add(hospital);
            }
            return resultList;
        }

        return hospitalPage;
    }




}
