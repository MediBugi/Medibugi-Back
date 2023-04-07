package kr.hansung.medibugiback.controller;

import kr.hansung.medibugiback.domain.MemberEntity;
import kr.hansung.medibugiback.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*",maxAge = 3000)
@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberRepository memberRepository;

}
