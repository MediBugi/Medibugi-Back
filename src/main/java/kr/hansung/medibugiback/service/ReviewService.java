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


    public String addReview(ReviewDto reviewDto, String memberid, Long hoscnt){



        MemberEntity member = memRepo.findByMemberid(memberid);

        Hospital hospital = hosRepo.findByHoscnt(hoscnt);

        Review review = new Review(member,hospital);

        review.setContent(reviewDto.getContent());
        review.setRating(reviewDto.getRating());
        reviewRepo.save(review);

        return review.toString();
    }

    public boolean deleteReview(String memberid, int reviewCnt){



        Review review = reviewRepo.findByReviewCnt(reviewCnt);


        if(review.getMember().getMemberid().equals(memberid)){
            reviewRepo.delete(review);

            return true;
        }


        return false;
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
            int reviewCnt = reviewList.get(i).getReviewCnt();

            ReviewDto reviewDto = new ReviewDto(content,rating);
            reviewDto.setMemberid(memberid);
            reviewDto.setHoscnt(hos);
            reviewDto.setReviewCnt(reviewCnt);
            reviewDtos.add(reviewDto);
        }

        return reviewDtos;
    }


}
