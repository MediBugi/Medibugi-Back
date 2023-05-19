package kr.hansung.medibugiback.service;

import kr.hansung.medibugiback.domain.Hospital;
import kr.hansung.medibugiback.domain.MemberEntity;
import kr.hansung.medibugiback.domain.Review;
import kr.hansung.medibugiback.dto.ReviewDto;
import kr.hansung.medibugiback.repository.HospitalRepository;
import kr.hansung.medibugiback.repository.MemberRepository;
import kr.hansung.medibugiback.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepo;

    private final HospitalRepository hosRepo;

    private final MemberRepository memRepo;


    public boolean addReview(ReviewDto reviewDto, String memberid, Long hoscnt){


        MemberEntity member = memRepo.findByMemberid(memberid);

        Hospital hospital = hosRepo.findByHoscnt(hoscnt);

        Review review = new Review(member,hospital);

        reviewRepo.save(review);

        return true;
    }

    public boolean deleteReview(ReviewDto reviewDto, String memberid, Long hoscnt){

        MemberEntity member = memRepo.findByMemberid(memberid);

        Hospital hospital = hosRepo.findByHoscnt(hoscnt);

        Review review = reviewRepo.findByHospitalAndMember(hospital,member);

        reviewRepo.delete(review);

        return true;
    }

    public List<Review> getReview(Long hoscnt){

        Hospital hospital = hosRepo.findByHoscnt(hoscnt);

        return reviewRepo.findByHospital(hospital);
    }


}
