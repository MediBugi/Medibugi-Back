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
import java.util.Random;
@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepo;

    private final HospitalRepository hosRepo;

    private final MemberRepository memRepo;


    public ReviewDto addReview(ReviewDto reviewDto, String memberid, Long hoscnt){



        MemberEntity member = memRepo.findByMemberid(memberid);

        Hospital hospital = hosRepo.findByHoscnt(hoscnt);

        Review review = new Review(member,hospital);


        review.setContent(reviewDto.getContent());
        review.setRating(reviewDto.getRating());
        review.setWriteTime(reviewDto.getWriteTime());
        reviewRepo.save(review);

        ReviewDto reviewDtoo = new ReviewDto(reviewDto.getContent(),reviewDto.getRating());
        reviewDtoo.setMemberid(memberid);
        reviewDtoo.setHoscnt(hoscnt);
        reviewDtoo.setReviewCnt(review.getReviewCnt());
        reviewDtoo.setWriteTime(reviewDto.getWriteTime());



        return reviewDtoo;
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
            String writeTime = reviewList.get(i).getWriteTime();

            ReviewDto reviewDto = new ReviewDto(content,rating);
            reviewDto.setMemberid(memberid);
            reviewDto.setHoscnt(hos);
            reviewDto.setReviewCnt(reviewCnt);
            reviewDto.setWriteTime(writeTime);
            reviewDtos.add(reviewDto);

        }

        return reviewDtos;
    }

    public List<Review> addreviewTest(){
        List<Review> reviewList = new ArrayList<>();
        List<Hospital> hospitalList = hosRepo.findByAddrStartingWithAndAddrContaining("서울특별시","중구");
        MemberEntity member = memRepo.findByMemberid("hello");

        Random random = new Random();
        long seed = System.currentTimeMillis();
        random.setSeed(seed);
        String[] testreview = new String[5];

        testreview[0] = "의사 선생님이 친절해요";
        testreview[1] = "병원이 청결해요";
        testreview[2] = "다른 곳보다 병원비가 비싸요";
        testreview[3] = "의사 선생님이 불친절해요";
        testreview[4] = "병원 상태가 청결하지 못해요";
        
        for(Hospital hospital : hospitalList){
            Review review = new Review(member,hospital);
            Long time = System.currentTimeMillis();
            String timestr = time+" ";
            int rating = random.nextInt(6);
            int i = random.nextInt(5);
            review.setRating(rating);
            review.setContent(testreview[i]);
            review.setWriteTime(timestr);

            reviewList.add(review);
            reviewRepo.save(review);
        }
        return reviewList;
    }

}
