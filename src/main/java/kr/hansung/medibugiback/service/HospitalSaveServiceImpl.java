package kr.hansung.medibugiback.service;

import kr.hansung.medibugiback.domain.Hospital;
import kr.hansung.medibugiback.repository.HospitalRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalSaveServiceImpl implements HospitalService {

    @Autowired
    HospitalRepository hosRepo;
    @Override
    public void init(String jsonData) {
        try{
            JSONObject jObj;
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObj=(JSONObject) jsonParser.parse(jsonData);
            JSONObject parseResponse = (JSONObject) jsonObj.get("response");
            JSONObject parseBody = (JSONObject) parseResponse.get("body");
            JSONObject parseItems = (JSONObject) parseBody.get("items");
            JSONArray array = (JSONArray) parseItems.get("item");
            System.out.println(array.toJSONString());
            for (Object o : array) {
                jObj = (JSONObject) o;
                Hospital hosVO = new Hospital();

                hosVO.setAddr(jObj.get("addr").toString());
                if(jObj.get("hospUrl")==null){
                    continue;
                }
                hosVO.setHospUrl(jObj.get("hospUrl").toString());
                hosVO.setTelno(jObj.get("telno").toString());
                hosVO.setClCdNm(jObj.get("clCdNm").toString());
                hosVO.setYadmNm(jObj.get("yadmNm").toString());
                hosVO.setSgguCdNm(jObj.get("sgguCdNm").toString());
                hosVO.setSidoCdNm(jObj.get("sidoCdNm").toString());
                if(hosRepo.existsByTelno(jObj.get("telno").toString())){
                    continue;
                }else{
                    hosRepo.save(hosVO);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public JSONArray getHospitalList() {


        JSONArray hosDataList= new JSONArray();
        List<Hospital> hospital = hosRepo.findAll();

        for(int i=0;i<5;i++){
            JSONObject jsonHospital = new JSONObject();
            jsonHospital.put("hoscnt",hospital.get(i).getHoscnt());
            jsonHospital.put("yadmNm", hospital.get(i).getYadmNm());
            jsonHospital.put("clCdNm", hospital.get(i).getClCdNm());
            jsonHospital.put("sidoCdNm", hospital.get(i).getSidoCdNm());
            jsonHospital.put("sgguCdNm", hospital.get(i).getSgguCdNm());
            jsonHospital.put("emdongNm", hospital.get(i).getEmdongNm());
            jsonHospital.put("addr", hospital.get(i).getAddr());
            jsonHospital.put("telno", hospital.get(i).getTelno());
            jsonHospital.put("hospUrl", hospital.get(i).getHospUrl());
            jsonHospital.put("drTotCnt", hospital.get(i).getDrTotCnt());
            jsonHospital.put("mediDepart", hospital.get(i).getMediDepart());
            jsonHospital.put("sunRestDay", hospital.get(i).getSunRestDay());
            jsonHospital.put("restDay", hospital.get(i).getRestDay());
            jsonHospital.put("lunchNom", hospital.get(i).getLunchNom());
            jsonHospital.put("lunchSat", hospital.get(i).getLunchSat());
            jsonHospital.put("receipt_week", hospital.get(i).getReceipt_week());
            jsonHospital.put("receipt_Sat", hospital.get(i).getReceipt_Sat());
            jsonHospital.put("chSunStart", hospital.get(i).getChSunStart());
            jsonHospital.put("chSunEnd", hospital.get(i).getChSunEnd());
            jsonHospital.put("chMonStart", hospital.get(i).getChMonStart());
            jsonHospital.put("chMonEnd", hospital.get(i).getChMonEnd());
            jsonHospital.put("chTueStart", hospital.get(i).getChTueStart());
            jsonHospital.put("chTueEnd", hospital.get(i).getChTueEnd());
            jsonHospital.put("chWenStart", hospital.get(i).getChWenStart());
            jsonHospital.put("chWenEnd", hospital.get(i).getChWenEnd());
            jsonHospital.put("chThuStart", hospital.get(i).getChThuStart());
            jsonHospital.put("chThuEnd", hospital.get(i).getChThuEnd());
            jsonHospital.put("chFriStart", hospital.get(i).getChFriStart());
            jsonHospital.put("chFriEnd", hospital.get(i).getChFriEnd());
            jsonHospital.put("chSatStart", hospital.get(i).getChSatStart());
            jsonHospital.put("chSatEnd", hospital.get(i).getChSatEnd());
            hosDataList.add(jsonHospital);
        }

        return hosDataList;
    }

    @Override
    public JSONArray getHospitalList(String depart) {
        JSONArray hosDataList= new JSONArray();
        List<Hospital> hospital = hosRepo.findByMediDepart(depart);

        for(int i=0;i<hospital.size();i++){
            JSONObject jsonHospital = new JSONObject();
            jsonHospital.put("hoscnt",hospital.get(i).getHoscnt());
            jsonHospital.put("yadmNm", hospital.get(i).getYadmNm());
            jsonHospital.put("clCdNm", hospital.get(i).getClCdNm());
            jsonHospital.put("sidoCdNm", hospital.get(i).getSidoCdNm());
            jsonHospital.put("sgguCdNm", hospital.get(i).getSgguCdNm());
            jsonHospital.put("emdongNm", hospital.get(i).getEmdongNm());
            jsonHospital.put("addr", hospital.get(i).getAddr());
            jsonHospital.put("telno", hospital.get(i).getTelno());
            jsonHospital.put("hospUrl", hospital.get(i).getHospUrl());
            jsonHospital.put("drTotCnt", hospital.get(i).getDrTotCnt());
            jsonHospital.put("mediDepart", hospital.get(i).getMediDepart());
            jsonHospital.put("sunRestDay", hospital.get(i).getSunRestDay());
            jsonHospital.put("restDay", hospital.get(i).getRestDay());
            jsonHospital.put("lunchNom", hospital.get(i).getLunchNom());
            jsonHospital.put("lunchSat", hospital.get(i).getLunchSat());
            jsonHospital.put("receipt_week", hospital.get(i).getReceipt_week());
            jsonHospital.put("receipt_Sat", hospital.get(i).getReceipt_Sat());
            jsonHospital.put("chSunStart", hospital.get(i).getChSunStart());
            jsonHospital.put("chSunEnd", hospital.get(i).getChSunEnd());
            jsonHospital.put("chMonStart", hospital.get(i).getChMonStart());
            jsonHospital.put("chMonEnd", hospital.get(i).getChMonEnd());
            jsonHospital.put("chTueStart", hospital.get(i).getChTueStart());
            jsonHospital.put("chTueEnd", hospital.get(i).getChTueEnd());
            jsonHospital.put("chWenStart", hospital.get(i).getChWenStart());
            jsonHospital.put("chWenEnd", hospital.get(i).getChWenEnd());
            jsonHospital.put("chThuStart", hospital.get(i).getChThuStart());
            jsonHospital.put("chThuEnd", hospital.get(i).getChThuEnd());
            jsonHospital.put("chFriStart", hospital.get(i).getChFriStart());
            jsonHospital.put("chFriEnd", hospital.get(i).getChFriEnd());
            jsonHospital.put("chSatStart", hospital.get(i).getChSatStart());
            jsonHospital.put("chSatEnd", hospital.get(i).getChSatEnd());
            hosDataList.add(jsonHospital);
        }
        return hosDataList;
    }
}
