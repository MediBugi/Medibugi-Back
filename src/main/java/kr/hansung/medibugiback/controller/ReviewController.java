package kr.hansung.medibugiback.controller;

import kr.hansung.medibugiback.domain.Review;
import kr.hansung.medibugiback.dto.ReviewDto;
import kr.hansung.medibugiback.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*",maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;


    @PostMapping("/add")
    public List<ReviewDto> ReviewAdd(ReviewDto reviewDto, @RequestParam("memberid") String memberid, @RequestParam("hoscnt") Long hoscnt){


        return reviewService.addReview(reviewDto,memberid,hoscnt);
    }

    @PostMapping("/delete")
    public boolean ReviewDelete(@RequestParam("memberid") String memberid, @RequestParam("reviewCnt") int reviewCnt){

        return reviewService.deleteReview(memberid,reviewCnt);
    }

    @GetMapping("/getReview")
    public List<ReviewDto> getReviewList(@RequestParam("hoscnt") Long hoscnt){

        return reviewService.getReview(hoscnt);
    }


}
