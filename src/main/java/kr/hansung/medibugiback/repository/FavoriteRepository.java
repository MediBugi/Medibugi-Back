package kr.hansung.medibugiback.repository;

import kr.hansung.medibugiback.domain.Favorite;
import kr.hansung.medibugiback.domain.Hospital;
import kr.hansung.medibugiback.domain.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite,Integer> {

    Favorite findByHospitalAndMember(Hospital hospital, MemberEntity member);

    List<Favorite> findByMember(MemberEntity member);
}
