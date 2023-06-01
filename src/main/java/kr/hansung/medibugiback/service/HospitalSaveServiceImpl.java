package kr.hansung.medibugiback.service;

import kr.hansung.medibugiback.domain.Hospital;
import kr.hansung.medibugiback.domain.Review;
import kr.hansung.medibugiback.dto.HospitalDto;
import kr.hansung.medibugiback.repository.HospitalRepository;
import kr.hansung.medibugiback.repository.ReviewRepository;
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

    @Autowired
    ReviewRepository reviewRepo;

    @Override
    public List<HospitalDto> getHospitalList() {

       List<Hospital> hospitalList = hosRepo.findMediDepartByCode();

       List<Review> reviewList = reviewRepo.findAll();

       List<HospitalDto> hospitalDtos = new ArrayList<>();

        for (Hospital hospital : hospitalList) {
            float rating = 0;
            int cnt = 0;
            for (Review review : reviewList) {
                if (hospital.getCode().equals(review.getHospital().getCode())) {
                    rating += review.getRating();
                    cnt++;
                }
            }
            HospitalDto hospitalDto = new HospitalDto(hospital);
            if(rating == 0){
                hospitalDto.setRating(0);
            }
            else
                hospitalDto.setRating(rating / cnt);
            hospitalDtos.add(hospitalDto);
        }

       return hospitalDtos;
    }
    @Override
    public List<HospitalDto> getHospitalList(String depart){

        List<Hospital> hospitalPage = hosRepo.findByMediDepart(depart);

        List<Review> reviewList = reviewRepo.findAll();

        List<HospitalDto> hospitalDtos = new ArrayList<>();

        List<Hospital> resultList = new ArrayList<>();
        if(depart.equals("내과")){
            for (Hospital hospital : hospitalPage) {
                float rating = 0;
                int cnt = 0;
                if ((hospital.getMediDepart().contains("한방내과")) || (hospital.getMediDepart().contains("구강내과"))) {
                    continue;
                }
                for(Review review : reviewList){
                    if(hospital.getCode().equals(review.getHospital().getCode())){
                        rating+=review.getRating();
                        cnt++;
                    }
                }
                HospitalDto hospitalDto = new HospitalDto(hospital);
                if(rating == 0){
                    hospitalDto.setRating(0);
                }
                else
                    hospitalDto.setRating(rating / cnt);
                hospitalDtos.add(hospitalDto);
            }
            return hospitalDtos;
        }
        else if(depart.equals("외과")){
            for(Hospital hospital : hospitalPage){
                float rating = 0;
                int cnt = 0;
                if((hospital.getMediDepart().contains("정형외과"))||(hospital.getMediDepart().contains("신경외과"))||(hospital.getMediDepart().contains("구강악안면외과"))||(hospital.getMediDepart().contains("성형외과"))||(hospital.getMediDepart().contains("심장혈관흉부외과"))||(hospital.getMediDepart().contains("흉부외과"))){
                    continue;
                }
                for(Review review : reviewList){
                    if(hospital.getCode().equals(review.getHospital().getCode())){
                        rating+=review.getRating();
                        cnt++;
                    }
                }
                HospitalDto hospitalDto = new HospitalDto(hospital);
                if(rating == 0){
                    hospitalDto.setRating(0);
                }
                else
                    hospitalDto.setRating(rating / cnt);
                hospitalDtos.add(hospitalDto);
            }
            return hospitalDtos;
        }
        else if(depart.equals("피부과")){
            for(Hospital hospital : hospitalPage){
                float rating = 0;
                int cnt = 0;
                if((hospital.getMediDepart().equals("한방안·이비인후·피부과"))||(hospital.getMediDepart().contains("한방안이비인후피부과"))){
                    continue;
                }
                for(Review review : reviewList){
                    if(hospital.getCode().equals(review.getHospital().getCode())){
                        rating+=review.getRating();
                        cnt++;
                    }
                }
                HospitalDto hospitalDto = new HospitalDto(hospital);
                if(rating == 0){
                    hospitalDto.setRating(0);
                }
                else
                    hospitalDto.setRating(rating / cnt);
                hospitalDtos.add(hospitalDto);
            }
            return hospitalDtos;
        }
        else if(depart.equals("치과")){
            for(Hospital hospital : hospitalPage){
                float rating = 0;
                int cnt = 0;
                if((hospital.getMediDepart().contains("치과보철과"))||(hospital.getMediDepart().contains("치과보존과"))||(hospital.getMediDepart().contains("소아치과"))||(hospital.getMediDepart().contains("치과교정과"))||(hospital.getMediDepart().contains("예방치과"))){
                    continue;
                }
                for(Review review : reviewList){
                    if(hospital.getCode().equals(review.getHospital().getCode())){
                        rating+=review.getRating();
                        cnt++;
                    }
                }
                HospitalDto hospitalDto = new HospitalDto(hospital);
                if(rating == 0){
                    hospitalDto.setRating(0);
                }
                else
                    hospitalDto.setRating(rating / cnt);
                hospitalDtos.add(hospitalDto);
            }
            return hospitalDtos;
        }

        for (Hospital hospital : hospitalPage) {
            float rating = 0;
            int cnt = 0;
            for (Review review : reviewList) {
                if (hospital.getCode().equals(review.getHospital().getCode())) {
                    rating += review.getRating();
                    cnt++;
                }
            }
            HospitalDto hospitalDto = new HospitalDto(hospital);
            if(rating == 0){
                hospitalDto.setRating(0);
            }
            else
                hospitalDto.setRating(rating / cnt);
            hospitalDtos.add(hospitalDto);
        }

        return hospitalDtos;
    }

    @Override
    public List<HospitalDto> getHospitalListBySido(String sido) {

        List<Hospital> hospitalList = hosRepo.findHospitalsByAddr(sido);

        List<Review> reviewList = reviewRepo.findAll();

        List<HospitalDto> hospitalDtos = new ArrayList<>();

        for (Hospital hospital : hospitalList) {
            float rating = 0;
            int cnt = 0;
            for (Review review : reviewList) {
                if (hospital.getCode().equals(review.getHospital().getCode())) {
                    rating += review.getRating();
                    cnt++;
                }
            }
            HospitalDto hospitalDto = new HospitalDto(hospital);
            if(rating == 0){
                hospitalDto.setRating(0);
            }
            else
                hospitalDto.setRating(rating / cnt);
            hospitalDtos.add(hospitalDto);
        }

        return hospitalDtos;
    }

    @Override
    public List<HospitalDto> getHospitalListBySidoAndDepart(String sido, String depart) {

        List<Hospital> hospitalPage = hosRepo.findByAddrStartingWithAndMediDepart(sido,depart);

        List<Review> reviewList = reviewRepo.findAll();

        List<HospitalDto> hospitalDtos = new ArrayList<>();

        List<Hospital> resultList = new ArrayList<>();
        if(depart.equals("내과")){
            for (Hospital hospital : hospitalPage) {
                float rating = 0;
                int cnt = 0;
                if ((hospital.getMediDepart().contains("한방내과")) || (hospital.getMediDepart().contains("구강내과"))) {
                    continue;
                }
                for(Review review : reviewList){
                    if(hospital.getCode().equals(review.getHospital().getCode())){
                        rating+=review.getRating();
                        cnt++;
                    }
                }
                HospitalDto hospitalDto = new HospitalDto(hospital);
                if(rating == 0){
                    hospitalDto.setRating(0);
                }
                else
                    hospitalDto.setRating(rating / cnt);
                hospitalDtos.add(hospitalDto);
            }
            return hospitalDtos;
        }
        else if(depart.equals("외과")){
            for(Hospital hospital : hospitalPage){
                float rating = 0;
                int cnt = 0;
                if((hospital.getMediDepart().contains("정형외과"))||(hospital.getMediDepart().contains("신경외과"))||(hospital.getMediDepart().contains("구강악안면외과"))||(hospital.getMediDepart().contains("성형외과"))||(hospital.getMediDepart().contains("심장혈관흉부외과"))||(hospital.getMediDepart().contains("흉부외과"))){
                    continue;
                }
                for(Review review : reviewList){
                    if(hospital.getCode().equals(review.getHospital().getCode())){
                        rating+=review.getRating();
                        cnt++;
                    }
                }
                HospitalDto hospitalDto = new HospitalDto(hospital);
                if(rating == 0){
                    hospitalDto.setRating(0);
                }
                else
                    hospitalDto.setRating(rating / cnt);
                hospitalDtos.add(hospitalDto);
            }
            return hospitalDtos;
        }
        else if(depart.equals("피부과")){
            for(Hospital hospital : hospitalPage){
                float rating = 0;
                int cnt = 0;
                if((hospital.getMediDepart().equals("한방안·이비인후·피부과"))||(hospital.getMediDepart().contains("한방안이비인후피부과"))){
                    continue;
                }
                for(Review review : reviewList){
                    if(hospital.getCode().equals(review.getHospital().getCode())){
                        rating+=review.getRating();
                        cnt++;
                    }
                }
                HospitalDto hospitalDto = new HospitalDto(hospital);
                if(rating == 0){
                    hospitalDto.setRating(0);
                }
                else
                    hospitalDto.setRating(rating / cnt);
                hospitalDtos.add(hospitalDto);
            }
            return hospitalDtos;
        }
        else if(depart.equals("치과")){
            for(Hospital hospital : hospitalPage){
                float rating = 0;
                int cnt = 0;
                if((hospital.getMediDepart().contains("치과보철과"))||(hospital.getMediDepart().contains("치과보존과"))||(hospital.getMediDepart().contains("소아치과"))||(hospital.getMediDepart().contains("치과교정과"))||(hospital.getMediDepart().contains("예방치과"))){
                    continue;
                }
                for(Review review : reviewList){
                    if(hospital.getCode().equals(review.getHospital().getCode())){
                        rating+=review.getRating();
                        cnt++;
                    }
                }
                HospitalDto hospitalDto = new HospitalDto(hospital);
                if(rating == 0){
                    hospitalDto.setRating(0);
                }
                else
                    hospitalDto.setRating(rating / cnt);
                hospitalDtos.add(hospitalDto);
            }
            return hospitalDtos;
        }

        for (Hospital hospital : hospitalPage) {
            float rating = 0;
            int cnt = 0;
            for (Review review : reviewList) {
                if (hospital.getCode().equals(review.getHospital().getCode())) {
                    rating += review.getRating();
                    cnt++;
                }
            }
            HospitalDto hospitalDto = new HospitalDto(hospital);
            if(rating == 0){
                hospitalDto.setRating(0);
            }
            else
                hospitalDto.setRating(rating / cnt);
            hospitalDtos.add(hospitalDto);
        }

        return hospitalDtos;
    }

    @Override
    public List<HospitalDto> getHospitalListBySidoAndSggu(String sido, String sggu) {

        List<Hospital> hospitalPage = hosRepo.findByAddrStartingWithAndAddrContaining(sido,sggu);

        List<Review> reviewList = reviewRepo.findAll();

        List<HospitalDto> hospitalDtos = new ArrayList<>();

        for (Hospital hospital : hospitalPage) {
            float rating = 0;
            int cnt = 0;
            for (Review review : reviewList) {
                if (hospital.getCode().equals(review.getHospital().getCode())) {
                    rating += review.getRating();
                    cnt++;
                }
            }
            HospitalDto hospitalDto = new HospitalDto(hospital);
            if(rating == 0){
                hospitalDto.setRating(0);
            }
            else
                hospitalDto.setRating(rating / cnt);
            hospitalDtos.add(hospitalDto);
        }

        return hospitalDtos;
    }

    @Override
    public List<HospitalDto> getHospitalList(String sido, String sggu,String depart) {

        List<Hospital> hospitalPage = hosRepo.findHospitalsByAddrAndMediDepart(sido, sggu, depart);
        List<Review> reviewList = reviewRepo.findAll();

        List<HospitalDto> hospitalDtos = new ArrayList<>();

        List<Hospital> resultList = new ArrayList<>();
        if(depart.equals("내과")){
            for (Hospital hospital : hospitalPage) {
                float rating = 0;
                int cnt = 0;
                if ((hospital.getMediDepart().contains("한방내과")) || (hospital.getMediDepart().contains("구강내과"))) {
                    continue;
                }
                for(Review review : reviewList){
                    if(hospital.getCode().equals(review.getHospital().getCode())){
                        rating+=review.getRating();
                        cnt++;
                    }
                }
                HospitalDto hospitalDto = new HospitalDto(hospital);
                if(rating == 0){
                    hospitalDto.setRating(0);
                }
                else
                    hospitalDto.setRating(rating / cnt);
                hospitalDtos.add(hospitalDto);
            }
            return hospitalDtos;
        }
        else if(depart.equals("외과")){
            for(Hospital hospital : hospitalPage){
                float rating = 0;
                int cnt = 0;
                if((hospital.getMediDepart().contains("정형외과"))||(hospital.getMediDepart().contains("신경외과"))||(hospital.getMediDepart().contains("구강악안면외과"))||(hospital.getMediDepart().contains("성형외과"))||(hospital.getMediDepart().contains("심장혈관흉부외과"))||(hospital.getMediDepart().contains("흉부외과"))){
                    continue;
                }
                for(Review review : reviewList){
                    if(hospital.getCode().equals(review.getHospital().getCode())){
                        rating+=review.getRating();
                        cnt++;
                    }
                }
                HospitalDto hospitalDto = new HospitalDto(hospital);
                if(rating == 0){
                    hospitalDto.setRating(0);
                }
                else
                    hospitalDto.setRating(rating / cnt);
                hospitalDtos.add(hospitalDto);
            }
            return hospitalDtos;
        }
        else if(depart.equals("피부과")){
            for(Hospital hospital : hospitalPage){
                float rating = 0;
                int cnt = 0;
                if((hospital.getMediDepart().equals("한방안·이비인후·피부과"))||(hospital.getMediDepart().contains("한방안이비인후피부과"))){
                    continue;
                }
                for(Review review : reviewList){
                    if(hospital.getCode().equals(review.getHospital().getCode())){
                        rating+=review.getRating();
                        cnt++;
                    }
                }
                HospitalDto hospitalDto = new HospitalDto(hospital);
                if(rating == 0){
                    hospitalDto.setRating(0);
                }
                else
                    hospitalDto.setRating(rating / cnt);
                hospitalDtos.add(hospitalDto);
            }
            return hospitalDtos;
        }
        else if(depart.equals("치과")){
            for(Hospital hospital : hospitalPage){
                float rating = 0;
                int cnt = 0;
                if((hospital.getMediDepart().contains("치과보철과"))||(hospital.getMediDepart().contains("치과보존과"))||(hospital.getMediDepart().contains("소아치과"))||(hospital.getMediDepart().contains("치과교정과"))||(hospital.getMediDepart().contains("예방치과"))){
                    continue;
                }
                for(Review review : reviewList){
                    if(hospital.getCode().equals(review.getHospital().getCode())){
                        rating+=review.getRating();
                        cnt++;
                    }
                }
                HospitalDto hospitalDto = new HospitalDto(hospital);
                if(rating == 0){
                    hospitalDto.setRating(0);
                }
                else
                    hospitalDto.setRating(rating / cnt);
                hospitalDtos.add(hospitalDto);
            }
            return hospitalDtos;
        }

        for (Hospital hospital : hospitalPage) {
            float rating = 0;
            int cnt = 0;
            for (Review review : reviewList) {
                if (hospital.getCode().equals(review.getHospital().getCode())) {
                    rating += review.getRating();
                    cnt++;
                }
            }
            HospitalDto hospitalDto = new HospitalDto(hospital);
            if(rating == 0){
                hospitalDto.setRating(0);
            }
            else
                hospitalDto.setRating(rating / cnt);
            hospitalDtos.add(hospitalDto);
        }

        return hospitalDtos;
    }

    @Override
    public List<HospitalDto> getHospitalListAndName(String depart, String name) {

        List<Hospital> hospitalPage = hosRepo.findByMediDepartAndName(depart,name);

        List<Review> reviewList = reviewRepo.findAll();

        List<HospitalDto> hospitalDtos = new ArrayList<>();

        List<Hospital> resultList = new ArrayList<>();
        if(depart.equals("내과")){
            for (Hospital hospital : hospitalPage) {
                float rating = 0;
                int cnt = 0;
                if ((hospital.getMediDepart().contains("한방내과")) || (hospital.getMediDepart().contains("구강내과"))) {
                    continue;
                }
                for(Review review : reviewList){
                    if(hospital.getCode().equals(review.getHospital().getCode())){
                        rating+=review.getRating();
                        cnt++;
                    }
                }
                HospitalDto hospitalDto = new HospitalDto(hospital);
                if(rating == 0){
                    hospitalDto.setRating(0);
                }
                else
                    hospitalDto.setRating(rating / cnt);
                hospitalDtos.add(hospitalDto);
            }
            return hospitalDtos;
        }
        else if(depart.equals("외과")){
            for(Hospital hospital : hospitalPage){
                float rating = 0;
                int cnt = 0;
                if((hospital.getMediDepart().contains("정형외과"))||(hospital.getMediDepart().contains("신경외과"))||(hospital.getMediDepart().contains("구강악안면외과"))||(hospital.getMediDepart().contains("성형외과"))||(hospital.getMediDepart().contains("심장혈관흉부외과"))||(hospital.getMediDepart().contains("흉부외과"))){
                    continue;
                }
                for(Review review : reviewList){
                    if(hospital.getCode().equals(review.getHospital().getCode())){
                        rating+=review.getRating();
                        cnt++;
                    }
                }
                HospitalDto hospitalDto = new HospitalDto(hospital);
                if(rating == 0){
                    hospitalDto.setRating(0);
                }
                else
                    hospitalDto.setRating(rating / cnt);
                hospitalDtos.add(hospitalDto);
            }
            return hospitalDtos;
        }
        else if(depart.equals("피부과")){
            for(Hospital hospital : hospitalPage){
                float rating = 0;
                int cnt = 0;
                if((hospital.getMediDepart().equals("한방안·이비인후·피부과"))||(hospital.getMediDepart().contains("한방안이비인후피부과"))){
                    continue;
                }
                for(Review review : reviewList){
                    if(hospital.getCode().equals(review.getHospital().getCode())){
                        rating+=review.getRating();
                        cnt++;
                    }
                }
                HospitalDto hospitalDto = new HospitalDto(hospital);
                if(rating == 0){
                    hospitalDto.setRating(0);
                }
                else
                    hospitalDto.setRating(rating / cnt);
                hospitalDtos.add(hospitalDto);
            }
            return hospitalDtos;
        }
        else if(depart.equals("치과")){
            for(Hospital hospital : hospitalPage){
                float rating = 0;
                int cnt = 0;
                if((hospital.getMediDepart().contains("치과보철과"))||(hospital.getMediDepart().contains("치과보존과"))||(hospital.getMediDepart().contains("소아치과"))||(hospital.getMediDepart().contains("치과교정과"))||(hospital.getMediDepart().contains("예방치과"))){
                    continue;
                }
                for(Review review : reviewList){
                    if(hospital.getCode().equals(review.getHospital().getCode())){
                        rating+=review.getRating();
                        cnt++;
                    }
                }
                HospitalDto hospitalDto = new HospitalDto(hospital);
                if(rating == 0){
                    hospitalDto.setRating(0);
                }
                else
                    hospitalDto.setRating(rating / cnt);
                hospitalDtos.add(hospitalDto);
            }
            return hospitalDtos;
        }

        for (Hospital hospital : hospitalPage) {
            float rating = 0;
            int cnt = 0;
            for (Review review : reviewList) {
                if (hospital.getCode().equals(review.getHospital().getCode())) {
                    rating += review.getRating();
                    cnt++;
                }
            }
            HospitalDto hospitalDto = new HospitalDto(hospital);
            if(rating == 0){
                hospitalDto.setRating(0);
            }
            else
                hospitalDto.setRating(rating / cnt);
            hospitalDtos.add(hospitalDto);
        }

        return hospitalDtos;
    }

    @Override
    public List<HospitalDto> getHospitalListBySidoAndName(String sido, String name) {

        List<Hospital> hospitalList = hosRepo.findBysidoAndName(sido, name);

        List<Review> reviewList = reviewRepo.findAll();

        List<HospitalDto> hospitalDtos = new ArrayList<>();

        for (Hospital hospital : hospitalList) {
            float rating = 0;
            int cnt = 0;
            for (Review review : reviewList) {
                if (hospital.getCode().equals(review.getHospital().getCode())) {
                    rating += review.getRating();
                    cnt++;
                }
            }
            HospitalDto hospitalDto = new HospitalDto(hospital);
            if(rating == 0){
                hospitalDto.setRating(0);
            }
            else
                hospitalDto.setRating(rating / cnt);
            hospitalDtos.add(hospitalDto);
        }

        return hospitalDtos;
    }

    @Override
    public List<HospitalDto> getHospitalListBySidoAndDepartAndName(String sido, String depart, String name) {

        List<Hospital> hospitalPage = hosRepo.findBySidoAndMediDepartAndName(sido,depart,name);

        List<Review> reviewList = reviewRepo.findAll();

        List<HospitalDto> hospitalDtos = new ArrayList<>();

        List<Hospital> resultList = new ArrayList<>();
        if(depart.equals("내과")){
            for (Hospital hospital : hospitalPage) {
                float rating = 0;
                int cnt = 0;
                if ((hospital.getMediDepart().contains("한방내과")) || (hospital.getMediDepart().contains("구강내과"))) {
                    continue;
                }
                for(Review review : reviewList){
                    if(hospital.getCode().equals(review.getHospital().getCode())){
                        rating+=review.getRating();
                        cnt++;
                    }
                }
                HospitalDto hospitalDto = new HospitalDto(hospital);
                if(rating == 0){
                    hospitalDto.setRating(0);
                }
                else
                    hospitalDto.setRating(rating / cnt);
                hospitalDtos.add(hospitalDto);
            }
            return hospitalDtos;
        }
        else if(depart.equals("외과")){
            for(Hospital hospital : hospitalPage){
                float rating = 0;
                int cnt = 0;
                if((hospital.getMediDepart().contains("정형외과"))||(hospital.getMediDepart().contains("신경외과"))||(hospital.getMediDepart().contains("구강악안면외과"))||(hospital.getMediDepart().contains("성형외과"))||(hospital.getMediDepart().contains("심장혈관흉부외과"))||(hospital.getMediDepart().contains("흉부외과"))){
                    continue;
                }
                for(Review review : reviewList){
                    if(hospital.getCode().equals(review.getHospital().getCode())){
                        rating+=review.getRating();
                        cnt++;
                    }
                }
                HospitalDto hospitalDto = new HospitalDto(hospital);
                if(rating == 0){
                    hospitalDto.setRating(0);
                }
                else
                    hospitalDto.setRating(rating / cnt);
                hospitalDtos.add(hospitalDto);
            }
            return hospitalDtos;
        }
        else if(depart.equals("피부과")){
            for(Hospital hospital : hospitalPage){
                float rating = 0;
                int cnt = 0;
                if((hospital.getMediDepart().equals("한방안·이비인후·피부과"))||(hospital.getMediDepart().contains("한방안이비인후피부과"))){
                    continue;
                }
                for(Review review : reviewList){
                    if(hospital.getCode().equals(review.getHospital().getCode())){
                        rating+=review.getRating();
                        cnt++;
                    }
                }
                HospitalDto hospitalDto = new HospitalDto(hospital);
                if(rating == 0){
                    hospitalDto.setRating(0);
                }
                else
                    hospitalDto.setRating(rating / cnt);
                hospitalDtos.add(hospitalDto);
            }
            return hospitalDtos;
        }
        else if(depart.equals("치과")){
            for(Hospital hospital : hospitalPage){
                float rating = 0;
                int cnt = 0;
                if((hospital.getMediDepart().contains("치과보철과"))||(hospital.getMediDepart().contains("치과보존과"))||(hospital.getMediDepart().contains("소아치과"))||(hospital.getMediDepart().contains("치과교정과"))||(hospital.getMediDepart().contains("예방치과"))){
                    continue;
                }
                for(Review review : reviewList){
                    if(hospital.getCode().equals(review.getHospital().getCode())){
                        rating+=review.getRating();
                        cnt++;
                    }
                }
                HospitalDto hospitalDto = new HospitalDto(hospital);
                if(rating == 0){
                    hospitalDto.setRating(0);
                }
                else
                    hospitalDto.setRating(rating / cnt);
                hospitalDtos.add(hospitalDto);
            }
            return hospitalDtos;
        }

        for (Hospital hospital : hospitalPage) {
            float rating = 0;
            int cnt = 0;
            for (Review review : reviewList) {
                if (hospital.getCode().equals(review.getHospital().getCode())) {
                    rating += review.getRating();
                    cnt++;
                }
            }
            HospitalDto hospitalDto = new HospitalDto(hospital);
            if(rating == 0){
                hospitalDto.setRating(0);
            }
            else
                hospitalDto.setRating(rating / cnt);
            hospitalDtos.add(hospitalDto);
        }

        return hospitalDtos;
    }

    @Override
    public List<HospitalDto> getHospitalListBySidoAndSgguAndName(String sido, String sggu, String name) {

        List<Hospital> hospitalPage = hosRepo.findByAddrAndName(sido, sggu, name);
        List<Review> reviewList = reviewRepo.findAll();

        List<HospitalDto> hospitalDtos = new ArrayList<>();

        for (Hospital hospital : hospitalPage) {
            float rating = 0;
            int cnt = 0;
            for (Review review : reviewList) {
                if (hospital.getCode().equals(review.getHospital().getCode())) {
                    rating += review.getRating();
                    cnt++;
                }
            }
            HospitalDto hospitalDto = new HospitalDto(hospital);
            if(rating == 0){
                hospitalDto.setRating(0);
            }
            else
                hospitalDto.setRating(rating / cnt);
            hospitalDtos.add(hospitalDto);
        }

        return hospitalDtos;
    }

    @Override
    public List<HospitalDto> getHospitalListAndName(String sido, String sggu, String depart, String name) {

        List<Hospital> hospitalPage = hosRepo.findbyAddrAndMediDepartAndName(sido, sggu, depart, name);
        List<Review> reviewList = reviewRepo.findAll();

        List<HospitalDto> hospitalDtos = new ArrayList<>();

        List<Hospital> resultList = new ArrayList<>();
        if(depart.equals("내과")){
            for (Hospital hospital : hospitalPage) {
                float rating = 0;
                int cnt = 0;
                if ((hospital.getMediDepart().contains("한방내과")) || (hospital.getMediDepart().contains("구강내과"))) {
                    continue;
                }
                for(Review review : reviewList){
                    if(hospital.getCode().equals(review.getHospital().getCode())){
                        rating+=review.getRating();
                        cnt++;
                    }
                }
                HospitalDto hospitalDto = new HospitalDto(hospital);
                if(rating == 0){
                    hospitalDto.setRating(0);
                }
                else
                    hospitalDto.setRating(rating / cnt);
                hospitalDtos.add(hospitalDto);
            }
            return hospitalDtos;
        }
        else if(depart.equals("외과")){
            for(Hospital hospital : hospitalPage){
                float rating = 0;
                int cnt = 0;
                if((hospital.getMediDepart().contains("정형외과"))||(hospital.getMediDepart().contains("신경외과"))||(hospital.getMediDepart().contains("구강악안면외과"))||(hospital.getMediDepart().contains("성형외과"))||(hospital.getMediDepart().contains("심장혈관흉부외과"))||(hospital.getMediDepart().contains("흉부외과"))){
                    continue;
                }
                for(Review review : reviewList){
                    if(hospital.getCode().equals(review.getHospital().getCode())){
                        rating+=review.getRating();
                        cnt++;
                    }
                }
                HospitalDto hospitalDto = new HospitalDto(hospital);
                if(rating == 0){
                    hospitalDto.setRating(0);
                }
                else
                    hospitalDto.setRating(rating / cnt);
                hospitalDtos.add(hospitalDto);
            }
            return hospitalDtos;
        }
        else if(depart.equals("피부과")){
            for(Hospital hospital : hospitalPage){
                float rating = 0;
                int cnt = 0;
                if((hospital.getMediDepart().equals("한방안·이비인후·피부과"))||(hospital.getMediDepart().contains("한방안이비인후피부과"))){
                    continue;
                }
                for(Review review : reviewList){
                    if(hospital.getCode().equals(review.getHospital().getCode())){
                        rating+=review.getRating();
                        cnt++;
                    }
                }
                HospitalDto hospitalDto = new HospitalDto(hospital);
                if(rating == 0){
                    hospitalDto.setRating(0);
                }
                else
                    hospitalDto.setRating(rating / cnt);
                hospitalDtos.add(hospitalDto);
            }
            return hospitalDtos;
        }
        else if(depart.equals("치과")){
            for(Hospital hospital : hospitalPage){
                float rating = 0;
                int cnt = 0;
                if((hospital.getMediDepart().contains("치과보철과"))||(hospital.getMediDepart().contains("치과보존과"))||(hospital.getMediDepart().contains("소아치과"))||(hospital.getMediDepart().contains("치과교정과"))||(hospital.getMediDepart().contains("예방치과"))){
                    continue;
                }
                for(Review review : reviewList){
                    if(hospital.getCode().equals(review.getHospital().getCode())){
                        rating+=review.getRating();
                        cnt++;
                    }
                }
                HospitalDto hospitalDto = new HospitalDto(hospital);
                if(rating == 0){
                    hospitalDto.setRating(0);
                }
                else
                    hospitalDto.setRating(rating / cnt);
                hospitalDtos.add(hospitalDto);
            }
            return hospitalDtos;
        }

        for (Hospital hospital : hospitalPage) {
            float rating = 0;
            int cnt = 0;
            for (Review review : reviewList) {
                if (hospital.getCode().equals(review.getHospital().getCode())) {
                    rating += review.getRating();
                    cnt++;
                }
            }
            HospitalDto hospitalDto = new HospitalDto(hospital);
            if(rating == 0){
                hospitalDto.setRating(0);
            }
            else
                hospitalDto.setRating(rating / cnt);
            hospitalDtos.add(hospitalDto);
        }

        return hospitalDtos;
    }

    @Override
    public List<Hospital> addtimeinfo(){
        List<Hospital> hospitalList = hosRepo.findByAddrStartingWithAndAddrContaining("서울특별시","성북구");
        List<Hospital> resultList = new ArrayList<>();
        for(Hospital hospital : hospitalList){
            hospital.setChMonStart("900");
            hospital.setChMonEnd("1800");
            hospital.setChTueStart("900");
            hospital.setChTueEnd("1800");
            hospital.setChWenStart("900");
            hospital.setChWenEnd("1800");
            hospital.setChThuStart("900");
            hospital.setChThuEnd("1800");
            hospital.setChFriStart("900");
            hospital.setChFriEnd("1800");

            resultList.add(hospital);
            hosRepo.save(hospital);
        }



        return resultList;
    }


}
