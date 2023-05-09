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
    public JSONArray getHospitalList(int pageNum, int pageSize) {


        JSONArray hosDataList= new JSONArray();
        PageRequest pageRequest = PageRequest.of(pageNum,pageSize);


        Page<Hospital> hospitalPage = hosRepo.findAll(pageRequest);

        for(Hospital hospital : hospitalPage.getContent()){
            JSONObject jsonHospital = new JSONObject();
            jsonHospital.put("hoscnt",hospital.getHoscnt());
            jsonHospital.put("yadmNm", hospital.getYadmNm());
            jsonHospital.put("clCdNm", hospital.getClCdNm());
            jsonHospital.put("sidoCdNm", hospital.getSidoCdNm());
            jsonHospital.put("sgguCdNm", hospital.getSgguCdNm());
            jsonHospital.put("emdongNm", hospital.getEmdongNm());
            jsonHospital.put("addr", hospital.getAddr());
            jsonHospital.put("telno", hospital.getTelno());
            jsonHospital.put("hospUrl", hospital.getHospUrl());
            jsonHospital.put("drTotCnt", hospital.getDrTotCnt());
            jsonHospital.put("mediDepart", hospital.getMediDepart());
            jsonHospital.put("sunRestDay", hospital.getSunRestDay());
            jsonHospital.put("restDay", hospital.getRestDay());
            jsonHospital.put("lunchNom", hospital.getLunchNom());
            jsonHospital.put("lunchSat", hospital.getLunchSat());
            jsonHospital.put("receipt_week", hospital.getReceipt_week());
            jsonHospital.put("receipt_Sat", hospital.getReceipt_Sat());
            jsonHospital.put("chSunStart", hospital.getChSunStart());
            jsonHospital.put("chSunEnd", hospital.getChSunEnd());
            jsonHospital.put("chMonStart", hospital.getChMonStart());
            jsonHospital.put("chMonEnd", hospital.getChMonEnd());
            jsonHospital.put("chTueStart", hospital.getChTueStart());
            jsonHospital.put("chTueEnd", hospital.getChTueEnd());
            jsonHospital.put("chWenStart", hospital.getChWenStart());
            jsonHospital.put("chWenEnd", hospital.getChWenEnd());
            jsonHospital.put("chThuStart", hospital.getChThuStart());
            jsonHospital.put("chThuEnd", hospital.getChThuEnd());
            jsonHospital.put("chFriStart", hospital.getChFriStart());
            jsonHospital.put("chFriEnd", hospital.getChFriEnd());
            jsonHospital.put("chSatStart", hospital.getChSatStart());
            jsonHospital.put("chSatEnd", hospital.getChSatEnd());
            jsonHospital.put("x", hospital.getX());
            jsonHospital.put("y", hospital.getY());
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

    @Override
    public JSONArray getHospitalList(int pageNum, int pageSize, String depart){
        JSONArray hosDataList= new JSONArray();


        PageRequest pageRequest = PageRequest.of(pageNum,pageSize);

        Page<Hospital> hospitalPage = hosRepo.findByMediDepart(depart,pageRequest);

        for(Hospital hospital : hospitalPage.getContent()){
            JSONObject jsonHospital = new JSONObject();
            jsonHospital.put("hoscnt",hospital.getHoscnt());
            jsonHospital.put("yadmNm", hospital.getYadmNm());
            jsonHospital.put("clCdNm", hospital.getClCdNm());
            jsonHospital.put("sidoCdNm", hospital.getSidoCdNm());
            jsonHospital.put("sgguCdNm", hospital.getSgguCdNm());
            jsonHospital.put("emdongNm", hospital.getEmdongNm());
            jsonHospital.put("addr", hospital.getAddr());
            jsonHospital.put("telno", hospital.getTelno());
            jsonHospital.put("hospUrl", hospital.getHospUrl());
            jsonHospital.put("drTotCnt", hospital.getDrTotCnt());
            jsonHospital.put("mediDepart", hospital.getMediDepart());
            jsonHospital.put("sunRestDay", hospital.getSunRestDay());
            jsonHospital.put("restDay", hospital.getRestDay());
            jsonHospital.put("lunchNom", hospital.getLunchNom());
            jsonHospital.put("lunchSat", hospital.getLunchSat());
            jsonHospital.put("receipt_week", hospital.getReceipt_week());
            jsonHospital.put("receipt_Sat", hospital.getReceipt_Sat());
            jsonHospital.put("chSunStart", hospital.getChSunStart());
            jsonHospital.put("chSunEnd", hospital.getChSunEnd());
            jsonHospital.put("chMonStart", hospital.getChMonStart());
            jsonHospital.put("chMonEnd", hospital.getChMonEnd());
            jsonHospital.put("chTueStart", hospital.getChTueStart());
            jsonHospital.put("chTueEnd", hospital.getChTueEnd());
            jsonHospital.put("chWenStart", hospital.getChWenStart());
            jsonHospital.put("chWenEnd", hospital.getChWenEnd());
            jsonHospital.put("chThuStart", hospital.getChThuStart());
            jsonHospital.put("chThuEnd", hospital.getChThuEnd());
            jsonHospital.put("chFriStart", hospital.getChFriStart());
            jsonHospital.put("chFriEnd", hospital.getChFriEnd());
            jsonHospital.put("chSatStart", hospital.getChSatStart());
            jsonHospital.put("chSatEnd", hospital.getChSatEnd());
            jsonHospital.put("x", hospital.getX());
            jsonHospital.put("y", hospital.getY());
            hosDataList.add(jsonHospital);
        }
        return hosDataList;
    }

    @Override
    public JSONArray getHospitalList(int pageNum, int pageSize, String sido, String sggu,String depart) {
        JSONArray jsonArray = new JSONArray();
        PageRequest pageRequest = PageRequest.of(pageNum,pageSize);
        Page<Hospital> hospitalPage = hosRepo.findBySidoCdNmAndSgguCdNmAndMediDepart(sido,sggu,depart,pageRequest);

        for(Hospital hospital : hospitalPage.getContent()){
            JSONObject jsonHospital = new JSONObject();
            jsonHospital.put("hoscnt",hospital.getHoscnt());
            jsonHospital.put("yadmNm", hospital.getYadmNm());
            jsonHospital.put("clCdNm", hospital.getClCdNm());
            jsonHospital.put("sidoCdNm", hospital.getSidoCdNm());
            jsonHospital.put("sgguCdNm", hospital.getSgguCdNm());
            jsonHospital.put("emdongNm", hospital.getEmdongNm());
            jsonHospital.put("addr", hospital.getAddr());
            jsonHospital.put("telno", hospital.getTelno());
            jsonHospital.put("hospUrl", hospital.getHospUrl());
            jsonHospital.put("drTotCnt", hospital.getDrTotCnt());
            jsonHospital.put("mediDepart", hospital.getMediDepart());
            jsonHospital.put("sunRestDay", hospital.getSunRestDay());
            jsonHospital.put("restDay", hospital.getRestDay());
            jsonHospital.put("lunchNom", hospital.getLunchNom());
            jsonHospital.put("lunchSat", hospital.getLunchSat());
            jsonHospital.put("receipt_week", hospital.getReceipt_week());
            jsonHospital.put("receipt_Sat", hospital.getReceipt_Sat());
            jsonHospital.put("chSunStart", hospital.getChSunStart());
            jsonHospital.put("chSunEnd", hospital.getChSunEnd());
            jsonHospital.put("chMonStart", hospital.getChMonStart());
            jsonHospital.put("chMonEnd", hospital.getChMonEnd());
            jsonHospital.put("chTueStart", hospital.getChTueStart());
            jsonHospital.put("chTueEnd", hospital.getChTueEnd());
            jsonHospital.put("chWenStart", hospital.getChWenStart());
            jsonHospital.put("chWenEnd", hospital.getChWenEnd());
            jsonHospital.put("chThuStart", hospital.getChThuStart());
            jsonHospital.put("chThuEnd", hospital.getChThuEnd());
            jsonHospital.put("chFriStart", hospital.getChFriStart());
            jsonHospital.put("chFriEnd", hospital.getChFriEnd());
            jsonHospital.put("chSatStart", hospital.getChSatStart());
            jsonHospital.put("chSatEnd", hospital.getChSatEnd());
            jsonHospital.put("x", hospital.getX());
            jsonHospital.put("y", hospital.getY());
            jsonArray.add(jsonHospital);
        }

        return jsonArray;
    }

}
