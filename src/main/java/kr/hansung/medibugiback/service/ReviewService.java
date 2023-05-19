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

import java.util.ArrayList;
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

    public boolean deleteReview(String memberid, Long hoscnt){

        MemberEntity member = memRepo.findByMemberid(memberid);

        Hospital hospital = hosRepo.findByHoscnt(hoscnt);

        Review review = reviewRepo.findByHospitalAndMember(hospital,member);

        reviewRepo.delete(review);

        return true;
    }

    public List<ReviewDto> getReview(Long hoscnt){

        Hospital hospital = hosRepo.findByHoscnt(hoscnt);

        List<Review> reviewList = reviewRepo.findByHospital(hospital);

        List<ReviewDto> reviewDtos = new ArrayList<>();


        for(int i=0;i<reviewList.size();i++){
            String content = reviewList.get(i).getContent();
            int rating = reviewList.get(i).getRating();
            String memberid = reviewList.get(i).getMember().getMemberid();
            Long hos = reviewList.get(i).getHospital().getHoscnt();

            ReviewDto reviewDto = new ReviewDto(content,rating);
            reviewDto.setMemberid(memberid);
            reviewDto.setHoscnt(hos);

            reviewDtos.add(reviewDto);
        }

        return reviewDtos;
    }


}
