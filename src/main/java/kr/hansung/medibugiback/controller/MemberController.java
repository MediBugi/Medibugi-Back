package kr.hansung.medibugiback.controller;

import kr.hansung.medibugiback.domain.MemberEntity;
import kr.hansung.medibugiback.dto.SignRequestDto;
import kr.hansung.medibugiback.dto.SignResponseDto;
import kr.hansung.medibugiback.repository.MemberRepository;
import kr.hansung.medibugiback.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(value = "*",maxAge = 3000)
@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberRepository memberRepository;
    private final MemberService memberService;

    @PostMapping("/login")
    public SignResponseDto login(@RequestBody SignRequestDto member) {
        return memberService.login(member);
    }

    @PostMapping("/signup")
    public Boolean signup(@RequestBody MemberEntity member) {
        return memberService.signup(member);
    }

    @PostMapping("/checkId")
    public Boolean checkId(@RequestBody Map<String, String> res) {
        return memberService.checkId(res.get("memberid"));
    }

    @GetMapping("/getMyInfo")
    public MemberEntity getMyInfo(@RequestParam String memberid) {
        return memberService.getMyInfo(memberid);
    }
}
