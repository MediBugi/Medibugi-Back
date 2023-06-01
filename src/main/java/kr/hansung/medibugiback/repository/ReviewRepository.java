package kr.hansung.medibugiback.repository;

import kr.hansung.medibugiback.domain.Hospital;
import kr.hansung.medibugiback.domain.MemberEntity;
import kr.hansung.medibugiback.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    Review findByHospitalAndMember(Hospital hospital, MemberEntity member);

    List<Review> findByHospital(Hospital hospital);

    Review findByReviewCnt(int reviewCnt);
}
