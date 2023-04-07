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
        List<Hospital> hosList = hosRepo.findAll();

        for(int i=0;i<hosList.size();i++){
            JSONObject jo = new JSONObject();
            jo.put("yadmNm",hosList.get(i).getYadmNm());
            jo.put("addr",hosList.get(i).getAddr());
            jo.put("telno",hosList.get(i).getTelno());
            hosDataList.add(jo);
        }

        System.out.println(hosDataList.toJSONString());
        System.out.println("검색결과");
            System.out.println("---> " + hosList.toString());
        return hosDataList;
    }
}
