package com.springboot.hello.controller;


import com.springboot.hello.domain.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/put-api")       //URI 변경
public class PutController {
    //////POST와 동일
    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample(){
        return "Hello Post API";
    }
    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();         //Builder Pattern

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey()+" : "+map.getValue() + "\n");
        });
        return sb.toString();
    }
    @PostMapping(value = "/member2")
    public String postMemberDto(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }
    /////POST와 동일

    //put 추가
    @PutMapping("/member3")
    public ResponseEntity<MemberDto> postMemberDto3(@RequestBody MemberDto memberDto){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)        //응답 코드 202, 이 메서드를 대상으로 요청을 수행하면 응답 코드가 202로 변경됨
                .body(memberDto);
    }
}
