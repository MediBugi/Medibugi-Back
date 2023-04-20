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

    @GetMapping("/apitest")
    public String callApiWithXml() {
        StringBuilder result = new StringBuilder();
        try {
            String apiUrl = "https://apis.data.go.kr/B551182/hospInfoServicev2/getHospBasisList?" +
                    "serviceKey=hRyDtWdl9ka1Ns9OkR3Mzi2rwq1QvxyA8wc%2B%2BQAyeHGF79OiC%2Bi2rUUvIkjmTaxFZFUEAlre%2FFepLG1Q540y3g%3D%3D"+
                    "&numOfRows=5"+
                    "&pageNO=0"+
                    "&sidoCd=110000"+
                    "&_type=json";
            URL url = new URL(apiUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

            String returnLine;
            while((returnLine = bufferedReader.readLine()) != null) {
                result.append(returnLine).append("\n");
            }
            urlConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        hospitalService.init(result.toString());

        return result.toString();
    }

    @GetMapping("/getHospitalList")
    public JSONArray hospitalList(){
      JSONArray ja = hospitalService.getHospitalList();

        return ja;
    }
}

