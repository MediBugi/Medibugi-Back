package kr.hansung.medibugiback.repository;


import kr.hansung.medibugiback.domain.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    MemberEntity findByMemberid(final String memberid);
    MemberEntity findByMemberidAndPassword(final String memberid, final String password);
    Boolean existsByMemberid(final String memberid);

}
