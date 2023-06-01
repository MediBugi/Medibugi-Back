package kr.hansung.medibugiback.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    private boolean status;

    public Favorite(Hospital hospital, MemberEntity member){
        this.hospital =hospital;
        this.member = member;
        this.status= true;
    }

    public void unFavorite(){
        this.status = false;
    }

}
