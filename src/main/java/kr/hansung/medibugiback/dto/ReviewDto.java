package kr.hansung.medibugiback.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewDto {
    private String content;
    private int rating;

    private int reviewCnt;
    private String writeTime;

    private String memberid;

    private Long hoscnt;

    public ReviewDto(String content, int rating){
        this.content=content;
        this.rating=rating;
    }

}
