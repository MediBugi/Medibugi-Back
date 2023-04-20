package kr.hansung.medibugiback.service;

import kr.hansung.medibugiback.domain.MemberEntity;
import kr.hansung.medibugiback.dto.SignRequestDto;
import kr.hansung.medibugiback.dto.SignResponseDto;
import kr.hansung.medibugiback.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public SignResponseDto login(final SignRequestDto request) {
        MemberEntity member = memberRepository.findByMemberidAndPassword(request.getMemberid(), request.getPassword());
        return new SignResponseDto(member);
    }

    public Boolean signup(final MemberEntity member) {
        memberRepository.save(member);
        return true;
    }

    public Boolean checkId(final String memberid) {
        return memberRepository.existsByMemberid(memberid);
    }

    public MemberEntity getMyInfo(final String memberid) {
        return memberRepository.findByMemberid(memberid);
    }
}
