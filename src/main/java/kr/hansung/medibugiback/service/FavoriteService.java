package kr.hansung.medibugiback.service;


import kr.hansung.medibugiback.domain.Favorite;
import kr.hansung.medibugiback.domain.Hospital;
import kr.hansung.medibugiback.domain.MemberEntity;
import kr.hansung.medibugiback.dto.FavoriteRequestDto;
import kr.hansung.medibugiback.repository.FavoriteRepository;
import kr.hansung.medibugiback.repository.HospitalRepository;
import kr.hansung.medibugiback.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoriteService {

    private final FavoriteRepository faRepo;
    private final MemberRepository memberRepo;
    private final HospitalRepository hosRepo;

    public boolean addFavorite(FavoriteRequestDto favoriteRequestDto){
        Long hoscnt = favoriteRequestDto.getHoscnt();
        String member_id = favoriteRequestDto.getMember_id();
        Hospital hospital = hosRepo.findByHoscnt(hoscnt);
        MemberEntity member = memberRepo.findByMemberid(member_id);

        if((faRepo.findByHospital(hospital)==null)){
            Favorite favorite = new Favorite(hospital,member);
            faRepo.save(favorite);

            return true;
        }


        return false;
    }

    public boolean deleteFavorite(FavoriteRequestDto favoriteRequestDto){
        Long hoscnt = favoriteRequestDto.getHoscnt();
        String member_id = favoriteRequestDto.getMember_id();
        Hospital hospital = hosRepo.findByHoscnt(hoscnt);
        MemberEntity member = memberRepo.findByMemberid(member_id);

        Favorite favorite = faRepo.findByHospitalAndMember(hospital,member);

        favorite.unFavorite();

        faRepo.delete(favorite);
        return true;
    }


    public List<Hospital> getFavoriteList(String member_id){
        List<Hospital> hospitalList = new ArrayList<>();

        MemberEntity member = memberRepo.findByMemberid(member_id);

        List<Favorite> favoriteList = faRepo.findByMember(member);

        for(int i=0;i<favoriteList.size();i++){
            Hospital hospital = hosRepo.findHospitalCode(favoriteList.get(i).getHospital().getCode());
            System.out.println(hospital);
            hospitalList.add(hospital);
        }

        return hospitalList;
    }

}
